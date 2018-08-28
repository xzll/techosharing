package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import bean.Notice;
import bean.User;
import constant.PageCodeEnum;
import dao.NoticeDao;
import dao.UserDao;
import dto.NoticeDto;
import dto.UserDto;
import notice.SpringWebSocketHandler;
import service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private HttpSession session;
	@Autowired
	private SpringWebSocketHandler websocket;
	@Override
	public boolean add(NoticeDto noticeDto) {
		if(noticeDao.insert(noticeDto)==1){
			userDao.updateAllRead();
			//通知用户
			websocket.sendMessageToUsers(new TextMessage("通知：有新公告"));
			
			return true;
		}
		return false;
	}

	@Override
	public NoticeDto getNoticeById(Long id) {
		NoticeDto dto=new NoticeDto();
		Notice notice = noticeDao.selectById(id);
		if(notice==null){
			return null;
		}
		BeanUtils.copyProperties(notice, dto);
		return dto;
	}

	@Override
	public List<NoticeDto> searchByPage(NoticeDto noticeDto) {
		List<Notice> list = noticeDao.selectByPage(noticeDto);
		List<NoticeDto> result = new ArrayList<NoticeDto>();
		System.out.println(list);
		if(list.isEmpty()){
			return null;
		}
		for(Notice item:list){
			NoticeDto dto = new NoticeDto();
			BeanUtils.copyProperties(item, dto);
			dto.setPage(noticeDto.getPage());
			result.add(dto);
		}
		return result;
	}

	@Override
	public boolean remove(Long id) {
		
		return noticeDao.delete(id)==1;
	}

	@Override
	public boolean readNotice() {
		User user = new User();
		user.setId(((User)session.getAttribute("user")).getId());
		user.setRead(false);
		return userDao.updateRead(user)==1;
	}

	@Override
	public NoticeDto getCurrentNotice() {
		Notice notice = noticeDao.selectCurrent();
		if(notice==null){
			return null;
		}
		NoticeDto dto = new NoticeDto();
		BeanUtils.copyProperties(notice, dto);
		return dto;
		
	}


}
