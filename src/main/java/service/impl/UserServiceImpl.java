package service.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import bean.Collect;
import bean.Comment;
import bean.Fan;
import bean.Purchase;
import bean.Techo;
import bean.Thumbup;
import bean.User;
import dao.CollectDao;
import dao.CommentDao;
import dao.FanDao;
import dao.PurchaseDao;
import dao.TechoDao;
import dao.ThumbupDao;
import dao.UserDao;
import dto.TechoDto;
import dto.UserDto;
import notice.SpringWebSocketHandler;
import service.MaterialService;
import service.TechoService;
import service.UserService;
import utils.CommonUtil;
import utils.MailUtil;

@Service
public class UserServiceImpl implements UserService{

	/**
	 * 用户表相关数据库操作
	 */
	@Autowired
	private UserDao userDao;
	/**
	 * 手帐表相关数据库操作
	 */
	@Autowired
	private TechoDao techoDao;
	/**
	 * 粉丝表相关数据库操作
	 */
	@Autowired
	private FanDao fanDao;
	/**
	 * 收藏表相关数据库操作
	 */
	@Autowired
	private CollectDao collectDao;
	/**
	 * 评论表相关数据库操作
	 */
	@Autowired
	private CommentDao commentDao;
	/**
	 * 点赞表相关数据库操作
	 */
	@Autowired
	private ThumbupDao thumbupDao;
	/**
	 * 订单表相关数据库操作
	 */
	@Autowired
	private PurchaseDao purchaseDao;
	/**
	 * 手帐相关服务
	 */
	@Autowired
	private TechoService techoService;
	/**
	 * 发送邮件的工具
	 */
	@Autowired
	private MailUtil mailUtil;
	/**
	 * session
	 */
	@Autowired
	private HttpSession session;
	/**
	 * websocket 服务端想客户端发送数据
	 */
	@Autowired
	private SpringWebSocketHandler webSocket;
	/**
	 * 用户图片存储根路径
	 */
	@Value("${userImage.saveFolder}")
	private String userImageFolder;
	/**
	 * 图片访问路径
	 */
	@Value("${userImage.url}")
	private String userImageUrl;
	/**
	 * 用户手帐图片存储根路径
	 */
	@Value("${techoImage.saveFolder}")
	private String techoImageFolder;
	/**
	 * 添加用户信息<br/>
	 * 随机用户名和密码，更新引用userDto为添加的用户的信息，包括id
	 * 
	 */
	@Override
	public boolean add(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);//其实不用复制，userDto是user的子类
		//TODO ǰ���ȼ��ܣ�����������
		user.setPassword(userDto.getPassword());
		//TODO ����ǳ�
		
		User username = new User();//新建一个user只为能当userDao.select的参数
		do {//因为userDao中的select方法只接受user类型的参数
			username.setUsername(RandomStringUtils.randomAlphanumeric(8));
		} while (!userDao.select(username).isEmpty());//检查生成的用户昵称是否已存在
		user.setUsername(username.getUsername());
		//数据库中添加用户，返回用户id
		if(userDao.insert(user) == 1) {	
			userDto = showInfo(user);//更新userDto
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * 登录验证<br/>
	 * 只需要userDto中的密码和邮箱<br/>
	 * 正确，保存用户信息到userDto中
	 */
	@Override
	public boolean validate(UserDto userDto) {
			User user = new User();//只需要userDto中的密码和邮箱
			//TODO ��ǰ���ȼ�������
			user.setPassword(userDto.getPassword());
			user.setEmail(userDto.getEmail());
			List<User> list = userDao.select(user);
			if(list.size() == 1) {
				//正确，保存用户信息到userDto中
				BeanUtils.copyProperties(list.get(0), userDto);
				return true;
			}
			return false;
			
	}

	/**
	 * 昵称是否存在<br/>
	 * 只需要username
	 */
	@Override
	public boolean isUsernameExist(UserDto userDto) {
		if(CommonUtil.isEmpty(userDto.getUsername())){
			return true;
		}
		User user = new User();
		user.setUsername(userDto.getUsername());
		return userDao.select(user).size() == 1;
	
	}

	/**
	 * 邮箱是否已被注册<br/>
	 * 只需要email
	 */
	@Override
	public boolean isEmailExist(String email) {
//		if(CommonUtil.isEmpty(email)){
//			return true;
//		}
		User user = new User();
		user.setEmail(email);
		return userDao.select(user).size() == 1;
	}

	@Override
	public boolean checkEmail(String email) {
		String regex="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$";
		if(email.matches(regex)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean sendCodeByEmail(String email) {
		String code = RandomStringUtils.randomAlphanumeric(6);//验证码
		try{
			mailUtil.send(email,"手帐分享网站","验证码:"+code);
			session.setAttribute("codeAndEmail", code+"|"+email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 用户签到
	 * 硬币加1
	 * 天数+1
	 * 成功返回新的用户信息
	 */
	@Override
	public User signIn() {
		User user =  (User)session.getAttribute("user") ;
		
		user.setCoin(1l);//coin+1
		user.setSignin(1l);//signin+1
		
		if(userDao.signIn(user)==1){
			return userDao.selectById(user.getId());
		}
		return null;
	}

	/**
	 * 更新所有信息？？
	 */
	@Override
	public User update(User user) {
		user.setId(((User)session.getAttribute("user")).getId());//获得当前用户id
		if(userDao.update(user)==1){
			session.setAttribute("user", user);
			return user;
		}
		return null;
	}

	/**
	 * 退出登录
	 * 退出websocket的用户队列
	 * 清除session
	 */
	@Override
	public boolean logout() {
		webSocket.logout(((User)session.getAttribute("user")).getId());
		session.invalidate();//清除session
		return true;
	}

	/**
	 * 
	 */
	@Override
	public User updateInfo(UserDto userDto) {
		userDto.setId(((User)session.getAttribute("user")).getId());
		
		if(userDao.updateInfo(userDto)==1){
			User result = userDao.selectById(userDto.getId());
			result.setPassword(null);
			return result;
		}
		return null;
		
	}

	
	@Override
	public UserDto showInfo(User user) {
		
		User u = userDao.selectById(user.getId());//根据id获得用户所有信息
		u.setPassword(null);//清空密码
		UserDto result = new UserDto();
		BeanUtils.copyProperties(u, result);
		if(result.getHeadimgname()!=null){
			result.setHeadimgurl(userImageUrl+result.getHeadimgname());//头像图片访问链接
		}
		result.setTechoSum(userDao.countTecho(u.getId()));//发布的手帐数量
		result.setFanSum(userDao.countFan(u.getId()));//粉丝数量
		result.setFollowerSum(userDao.countFollower(u.getId()));//关注数量
		
		String signdate = u.getSigndate();//签到日期 Date形式
		if(signdate==null || signdate==""){
			result.setIsSign(false);
		}else{
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = sdf.format(d);//获得当前日期
			System.out.println("现在：" + currentDate) ;
			try {
				signdate = sdf.format(sdf.parse(signdate));//string转化为Data
				System.out.println("签到日" + signdate);
				if(signdate.equals(currentDate)){//当前日期是否和签到日期相同
					result.setIsSign(true);
				}else{
					result.setIsSign(false);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	@Override
	public Boolean loadHeadImg(UserDto userDto) {
		userDto.setId(((User)session.getAttribute("user")).getId());
		MultipartFile  imgFile = userDto.getHeadimgfile();//图片的二进制文件
		if(imgFile!=null && imgFile.getSize() > 0 ){//判断
			String fileName = userDao.selectById(userDto.getId()).getHeadimgname();
			if(!fileName.equals("default.jpg")) {//数据库中的名字是否默认，默认表示为默认头像
				//不是默认就删除原来的文件
				CommonUtil.delFile(fileName);
			}
			//当前毫秒数+文件原名
			fileName = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
			User user = new User();
			//更新数据库中头像名
			user.setId(userDto.getId());
			user.setHeadimgname(imgFile.getOriginalFilename());
			userDao.updateInfo(user);
			//创建路径
			String path = userImageFolder+"/";
			File file = new File(path+fileName);
			File fileFolder = new File(path);
			if(!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			//将文件输出到文件夹中
			try {
				imgFile.transferTo(file);
				userDto.setHeadimgname(fileName);
				return false;
			} catch (IllegalStateException | IOException e ) {
				e.printStackTrace();
				return false;
			}
//			UserDto dto = new UserDto();
//			dto.setHeadimgname(fileName);
//			dto.setId(userDto.getId());
//			if(userDao.updateInfo(dto)==1){
//				return true;
//			}
		}

		return false;
		
	}

	/**
	 * 
	 */
	@Override
	public List<UserDto> searchByPage(UserDto userDto) {
		List<User> list = userDao.selectByPage(userDto);
		List<UserDto> result = new ArrayList<UserDto>();
		if(list.isEmpty()){
			return null;
		}
		
		for(User item:list) {
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(item, dto);
			//ͼƬ����
			dto.setHeadimgurl(userImageUrl+item.getHeadimgname());//设置从数据库获得的用户的头像访问链接
			
			result.add(dto);
		}
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean modify(UserDto userDto) {
		
		return userDao.update(userDto)==1;
	}

	/**
	 * 获得用户所有信息 
	 * 表中的+头像访问链接
	 */
	@Override
	public UserDto getById(Long id) {
		User user = userDao.selectById(id);
		if(user!=null){
			UserDto dto = new UserDto();
			dto.setHeadimgurl(userImageUrl+user.getHeadimgname());
			return dto;
		}
		return null;
	}

	/**
	 * 管理员直接添加用户
	 */
	@Override
	public boolean addUser(UserDto userDto) {
		if(userDto.getCoin()<0){
			userDto.setCoin(0L);
		}
		return userDao.insert(userDto)==1;
	}
	@Transactional
	@Override
	public boolean remove(Long id) {
		List<Long> list = techoDao.selectIdByUid(id);
		User user = userDao.selectById(id);
		if(user!=null){
			//ɾ���û�ͼƬ(ͷ��)
			if(!user.getHeadimgname().equals("default.jpg")){
				CommonUtil.delFile(userImageFolder+"/"+user.getHeadimgname());				
			}
			//ɾ������
			if(!list.isEmpty()){
				for(Long item:list){
					techoService.delete(item, true);
				}
				
			}
			//��ע�ͷ�˿
			Fan fan = new Fan();
			fan.setFanid(id);
			fan.setUid(id);
			fanDao.deleteAll(fan);
			//����
			Comment comment = new Comment();
			comment.setUid(id);
			commentDao.deleteAll(comment);
			//�ղ�
			Collect collect = new Collect();
			collect.setUid(id);
			collectDao.deleteAll(collect);
			//��
			Thumbup thumbup = new Thumbup();
			thumbup.setUid(id);
			thumbupDao.deleteAll(thumbup);
			//������Ϣ
			Purchase purchase = new Purchase();
			purchase.setUid(id);
			purchaseDao.deleteAll(purchase);
			
			userDao.delete(id);
			return true;
		}
		
		return false;
	}
	




}
