package service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.TextMessage;

import bean.Collect;
import bean.Comment;
import bean.Fan;
import bean.Material;
import bean.NoticeTecho;
import bean.Techo;
import bean.Thumbup;
import bean.User;
import constant.PageCodeEnum;
import dao.CollectDao;
import dao.CommentDao;
import dao.FanDao;
import dao.TechoDao;
import dao.ThumbupDao;
import dao.UserDao;
import dto.TechoDto;
import notice.SpringWebSocketHandler;
import service.MaterialService;
import service.TechoService;
import utils.CommonUtil;

@Service
public class TechoServiceImpl implements TechoService {
	@Autowired
	private TechoDao techoDao;
	@Autowired
	private FanDao fanDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private MaterialService materialService;
//	@Autowired
//	private NoticeTechoDao noticeTechoDao;
	@Autowired
	private CollectDao collectDao;
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private ThumbupDao thumbupDao;
	@Autowired
	private SpringWebSocketHandler websocket;
	@Autowired
	private HttpSession session;

	
	@Value("${techoImage.url}")
	private String techoImageUrl;
	
	@Value("${techoImage.saveFolder}")
	private String techoImageFolder;
	
	@Override
	public boolean add(TechoDto techoDto) {
		
		Techo techo = new Techo();
		BeanUtils.copyProperties(techoDto, techo);
		MultipartFile[] imgFiles = techoDto.getImgFiles();
		StringBuilder imgnames = new StringBuilder();
		if(imgFiles != null ){
			for (MultipartFile imgFile : imgFiles) {
				if(imgFile.getSize() > 0 ){
					String fileName = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
					//����tomcat��class�ļ����£�ÿ������tomcat��������ٽ�
//					String path = this.getClass().getClassLoader().getResource("").getPath() + TechoImageFolder+techoDto.getUid()+"/"; 
					String path = techoImageFolder+techoDto.getUid()+"/";
					System.out.println(path+fileName);
					File file = new File(path+fileName);
					File fileFolder = new File(path);
					if(!fileFolder.exists()) {
						fileFolder.mkdirs();
					}
					
					try {
						imgFile.transferTo(file);
						imgnames.append(fileName+",");
					} catch (IllegalStateException | IOException e ) {
						e.printStackTrace();
						return false;
					} 
					
				}
			}
			techo.setImgnames(imgnames.toString());
			if(techoDao.insert(techo) == 1) {
				techoDto.setId(techo.getId());
				//�ϴ���100����
				User user = new User();
				user.setId(techo.getUid());
				user.setCoin(100L);
				userDao.coinAddAndSub(user);
				//����notice_techo�����˿�㲥��Ϣ
				//��÷�˿id�б�
				List<Fan> fans = fanDao.selectByUid(techo.getUid());
				if(fans.isEmpty()){
					return true;
				}
//				List<NoticeTecho> noticeTechos = new LinkedList<NoticeTecho>();
//				Long tid = techo.getId();
//				for (Fan fan : fans) {
//					NoticeTecho noticeTecho = new NoticeTecho();
//					noticeTecho.setUid(fan.getFanid());
//					noticeTecho.setTid(tid);
//					noticeTechos.add(noticeTecho);
//				}
				//����notice_techo��,��¼ÿ���û��Ƿ񿴹���ע�߷��͵����ʣ�������ʾ������Ϣ�б�
//				noticeTechoDao.insertBatch(noticeTechos);
				//TODO ���˿�㲥��Ϣ
				for(Fan fan: fans) {
					websocket.sendMessageToUser(fan.getFanid(), new TextMessage(PageCodeEnum.NOTICE_TECHO.getMsg()));
				}
				
				return true;
			} else {
				return false;
			}
			
//			System.out.println(techo.getId()+"\n"+techo.getCreatetime());
			
		} else {
			return false;
		}
		
		
	}
	@Override
	public List<TechoDto> searchByPage(TechoDto techoDto) {
		Techo techo = new Techo();
		BeanUtils.copyProperties(techoDto, techo);
		List<Techo> list = techoDao.selectByPage(techo);
		List<TechoDto> result = new ArrayList<TechoDto>();
		if(list.isEmpty()){
			return null;
		}
		
		for(Techo item:list) {
			TechoDto dto = new TechoDto();
			Long tid = item.getId();

			BeanUtils.copyProperties(item, dto);
			//���۵����ղ���
			dto.setCollectionNum(collectDao.countByTid(tid));
			dto.setCommentNum(commentDao.countByTid(tid));
			dto.setThumbupNum(thumbupDao.countByTid(tid));
			//ͼƬ����
			dto.setImgsurl(imgNameToUrl(item));
			
			dto.setPage(techoDto.getPage());
			result.add(dto);
		}
		return result;
	}
	@Override
	public TechoDto searchById(Long id) {
		Techo techo = techoDao.selectById(id);
		
		TechoDto dto = new TechoDto();
		Long tid = techo.getId();

		BeanUtils.copyProperties(techo, dto);
		//���۵����ղ���
		dto.setCollectionNum(collectDao.countByTid(tid));
		dto.setCommentNum(commentDao.countByTid(tid));
		dto.setThumbupNum(thumbupDao.countByTid(tid));
		//ͼƬ����
		dto.setImgsurl(imgNameToUrl(techo));
		
		return dto;
	}
	@Override
	public String[] imgNameToPath(Techo techo){
		String[] imgname = techo.getImgnames().split(",");
		if(imgname!=null) {
			String[] imgsurl = new String[imgname.length];
			for(int i =0;i<imgname.length;i++) {
				imgsurl[i] = techoImageFolder+ techo.getUid()+"/"+imgname[i];
			}
			return imgsurl;
		} else {
			return null;
		}
	}
	@Override
	public String[] imgNameToUrl(Techo techo){
		String[] imgname = techo.getImgnames().split(",");
		if(imgname!=null) {
			String[] imgsurl = new String[imgname.length];
			for(int i =0;i<imgname.length;i++) {
				imgsurl[i] = techoImageUrl+ techo.getUid()+"/"+imgname[i];
			}
			return imgsurl;
		} else {
			return null;
		}
	}
	@Override
	public boolean deleteNotice(NoticeTecho noticeTecho) {
/*		if(noticeTechoDao.deleteNotice(noticeTecho)==1){
			return true;
		}else{
			return false;
		}*/
		
		return true;
	}
	@Transactional
	@Override
	public boolean delete(Long id,boolean delImg) {
		
		Techo techo = techoDao.selectById(id);
		
		if(techo!=null ){
			//ɾ������ͼƬ
			if(delImg){
				String[] imgFiles = imgNameToPath(techo);
				for(int i=0;i<imgFiles.length;i++){
					CommonUtil.delFile(imgFiles[i]);
				}
			}
			//ɾ���ز�(ɾ��������Ϣ)
			Material material = new Material();
			material.setTid(id);
			materialService.deleteAll(material, techo.getUid(), delImg);
			//ɾ���ղ�
			Collect collect = new Collect();
			collect.setTid(id);
			collectDao.deleteAll(collect);
			//ɾ������
			Thumbup thumbup = new Thumbup();
			thumbup.setTid(id);
			thumbupDao.deleteAll(thumbup);
			//ɾ������
			Comment comment = new Comment();
			comment.setTid(id);
			commentDao.deleteAll(comment);
			//���ɾ����
			techoDao.delete(id);
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean isUserTecho(Long id) {
		Techo techo = techoDao.selectById(id);
		Long uid = ((User)session.getAttribute("user")).getId();
		if(techo!=null && techo.getUid()==uid){
			return true;
		}
		return false;
	}
	

}
