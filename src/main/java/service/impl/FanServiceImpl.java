package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import bean.Fan;
import constant.PageCodeEnum;
import dao.FanDao;
import dto.FanDto;
import notice.SpringWebSocketHandler;
import service.FanService;

@Service
public class FanServiceImpl implements FanService {
	@Autowired
	private FanDao fanDao;
	@Autowired
	private SpringWebSocketHandler websocket;
	@Override
	public boolean add(FanDto fanDto) {
//		if(fanDto.getUid()) 
//		TODO 确定uid和fanid是否存在
		if(fanDao.insert(fanDto) == 1) {
			//通知被关注者
			websocket.sendMessageToUser(fanDto.getUid(), new TextMessage(PageCodeEnum.NOTICE_FOLLOW.getMsg()));
			return true;
		} else {
			return false;
		}
		
	}
	@Override
	public List<FanDto> searchFanByPage(FanDto fanDto) {
		 List<Fan> list = fanDao.selectByUidByPage(fanDto);
		 List<FanDto> result = new ArrayList<FanDto>();
		 for(Fan item:list){
			 FanDto dto = new FanDto();
			 BeanUtils.copyProperties(item, dto);
			 
			 dto.setPage(fanDto.getPage());
			 result.add(dto);
		 }
		 return result;
	}
	@Override
	public List<FanDto> searchFollowerByPage(FanDto fanDto) {
		 List<Fan> list = fanDao.selectByFanidByPage(fanDto);
		 List<FanDto> result = new ArrayList<FanDto>();
		 for(Fan item:list){
			 FanDto dto = new FanDto();
			 BeanUtils.copyProperties(item, dto);
			 
			 dto.setPage(fanDto.getPage());
			 result.add(dto);
		 }
		 return result;
	}
	@Override
	public List<FanDto> searchNoticeByPage(FanDto fanDto) {
		 List<Fan> list = fanDao.selectNoticeByPage(fanDto);
		 List<FanDto> result = new ArrayList<FanDto>();
		 for(Fan item:list){
			 FanDto dto = new FanDto();
			 BeanUtils.copyProperties(item, dto);
			 
			 dto.setPage(fanDto.getPage());
			 result.add(dto);
		 }
		 return result;
	}
	@Override
	public boolean deleteNotice(FanDto fanDto) {
		if(fanDao.deleteNotice(fanDto) == 1){
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(FanDto fanDto) {
		if(fanDao.delete(fanDto) == 1){
			return true;
		}
		return false;
	}

}
