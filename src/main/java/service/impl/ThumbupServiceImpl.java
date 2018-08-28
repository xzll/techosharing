package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import bean.Comment;
import bean.Thumbup;
import constant.PageCodeEnum;
import dao.TechoDao;
import dao.ThumbupDao;
import dto.CommentDto;
import dto.TechoDto;
import dto.ThumbupDto;
import notice.SpringWebSocketHandler;
import service.TechoService;
import service.ThumbupService;
@Service
public class ThumbupServiceImpl implements ThumbupService{
	@Autowired
	private ThumbupDao thumbupDao;
	@Autowired 
	private TechoDao techoDao;
	@Autowired
	private SpringWebSocketHandler websocket;
	@Autowired
	private TechoService techoService;
	@Override
	public boolean thumbup(ThumbupDto thumbupDto) {
		Thumbup thumbup = new Thumbup();
		BeanUtils.copyProperties(thumbupDto, thumbup);
		if(thumbupDao.insert(thumbup) == 1) {
			Long userId = techoDao.selectById(thumbup.getTid()).getUid();//TODO 日志
			websocket.sendMessageToUser(userId, new TextMessage(PageCodeEnum.NOTICE_THUMPUP.getMsg()));
			return true;
		}
		return false;
	}
	@Override
	public List<ThumbupDto> searchBeThumbupByPage(ThumbupDto thumbupDto) {
		List<Thumbup> list = thumbupDao.selectBeThumbupByPage(thumbupDto);
		List<ThumbupDto> result = new ArrayList<ThumbupDto>();
		//处理每条评论
		for(Thumbup item:list) {
			ThumbupDto dto = new ThumbupDto();
			BeanUtils.copyProperties(item, dto);
			//techo
			TechoDto techoDto = new TechoDto();
			BeanUtils.copyProperties(item.getTecho(), techoDto);
			//图片
			techoDto.setImgsurl(techoService.imgNameToUrl(techoDto));
			
			dto.setTechoDto(techoDto);
			dto.setPage(thumbupDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public List<ThumbupDto> searchMyThumbupByPage(ThumbupDto thumbupDto) {
		List<Thumbup> list = thumbupDao.selectMyThumbupByPage(thumbupDto);
		List<ThumbupDto> result = new ArrayList<ThumbupDto>();
		//处理每条评论
		for(Thumbup item:list) {
			ThumbupDto dto = new ThumbupDto();
			BeanUtils.copyProperties(item, dto);
			//techo
			TechoDto techoDto = new TechoDto();
			BeanUtils.copyProperties(item.getTecho(), techoDto);
			//图片
			techoDto.setImgsurl(techoService.imgNameToUrl(techoDto));
			
			dto.setTechoDto(techoDto);
			dto.setPage(thumbupDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public boolean delNotice(ThumbupDto thumbupDto) {
		if(thumbupDao.deleteNotice(thumbupDto)==1){
			return true;
		}
		return false;
	}
	@Override
	public boolean del(ThumbupDto thumbupDto) {
		if(thumbupDao.delete(thumbupDto)==1){
			return true;
		}
		return false;
	}

}
