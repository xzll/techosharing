package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import bean.Collect;
import bean.Techo;
import constant.PageCodeEnum;
import dao.CollectDao;
import dao.TechoDao;
import dto.CollectDto;
import dto.TechoDto;
import notice.SpringWebSocketHandler;
import service.CollectService;
import service.TechoService;
@Service
public class CollectServiceImpl implements CollectService{

	@Autowired
	private CollectDao collectDao;
	@Autowired
	private TechoDao techoDao;
	@Autowired
	private SpringWebSocketHandler websocket;
	@Autowired
	private TechoService techoService;

	@Override
	public boolean add(CollectDto collectDto) {
//		Collect collect = new Collect();
//		BeanUtils.copyProperties(collectDto, collect);
		Techo techo = techoDao.selectById(collectDto.getTid());
		if(techo!=null){
			try{
			if(collectDao.insert(collectDto) == 1) {
				Long userId = techo.getUid();
				websocket.sendMessageToUser(userId, new TextMessage(PageCodeEnum.NOTICE_COLLECTION.getMsg()));
				return true;
			} }catch(Exception e){//TODO 日志
				return false;
			}
			
		}
		return false;
	}
	@Override
	public List<CollectDto> searchByUidByPage(CollectDto collectDto) {
		Collect collect = new Collect();
		BeanUtils.copyProperties(collectDto, collect);
		List<Collect> list = collectDao.selectByUidByPage(collect);
		List<CollectDto> result = new ArrayList<CollectDto>();
		if(list.isEmpty()){
			return null;
		}
		//处理每条收藏
		for(Collect item:list) {
			CollectDto dto = new CollectDto();
			BeanUtils.copyProperties(item, dto);
			//techo
			TechoDto techoDto = new TechoDto();
			BeanUtils.copyProperties(item.getTecho(), techoDto);
			//图片
			techoDto.setImgsurl(techoService.imgNameToUrl(techoDto));
			dto.setTechoDto(techoDto);
			//分页
			dto.setPage(collectDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public List<CollectDto> searchBeCollectByPage(CollectDto collectDto) {
		Collect collect = new Collect();
		BeanUtils.copyProperties(collectDto, collect);
		List<Collect> list = collectDao.selectBeCollectByPage(collect);
		List<CollectDto> result = new ArrayList<CollectDto>();
		if(list.isEmpty()){
			return null;
		}
		//处理每条收藏
		for(Collect item:list) {
			CollectDto dto = new CollectDto();
			BeanUtils.copyProperties(item, dto);
			//techo
			TechoDto techoDto = new TechoDto();
			BeanUtils.copyProperties(item.getTecho(), techoDto);
			//图片
			techoDto.setImgsurl(techoService.imgNameToUrl(techoDto));
			
			dto.setTechoDto(techoDto);
			dto.setPage(collectDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public boolean deleteReceive(CollectDto collectDto) {
		if(collectDao.deleteReceive(collectDto) == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(CollectDto collectDto) {
		if(collectDao.delete(collectDto) == 1) {
			return true;
		}
		return false;
	}



}
