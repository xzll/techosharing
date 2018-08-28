package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;

import bean.Comment;
import bean.Techo;
import constant.PageCodeEnum;
import dao.CommentDao;
import dao.TechoDao;
import dto.CommentDto;
import dto.TechoDto;
import notice.SpringWebSocketHandler;
import service.CommentService;
import service.TechoService;
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	@Autowired
	private TechoDao techoDao;
	@Autowired
	private SpringWebSocketHandler websocket;
	@Autowired
	private TechoService techoService;
	@Override
	public boolean add(CommentDto commentDto) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(commentDto, comment);
		if(commentDao.insert(comment) == 1) {
			comment = commentDao.selectById(comment.getId());
			BeanUtils.copyProperties(comment, commentDto);
			//通知被评论的用户
			Long userId = techoDao.selectById(comment.getTid()).getUid();
			websocket.sendMessageToUser(userId, new TextMessage(PageCodeEnum.NOTICE_COMMENT.getMsg()));
			return true;
		}
		return false;
	}
	@Override
	public List<CommentDto> searchUserCommentsByPage(CommentDto commentDto) {
		List<Comment> list = commentDao.selectUserCommentsByPage(commentDto);
		List<CommentDto> result = new ArrayList<CommentDto>();
		if(list.isEmpty()){
			return null;
		}
		//处理每条评论
		for(Comment item:list) {
			CommentDto dto = new CommentDto();
			BeanUtils.copyProperties(item, dto);
			//techo
			TechoDto techoDto = new TechoDto();
			BeanUtils.copyProperties(item.getTecho(), techoDto);
			//图片
			techoDto.setImgsurl(techoService.imgNameToUrl(techoDto));
			
			dto.setTechoDto(techoDto);
			dto.setPage(commentDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public List<CommentDto> selectUserReceiveCommentsByPage(CommentDto commentDto) {
		List<Comment> list = commentDao.selectUserReceiveCommentsByPage(commentDto);
		List<CommentDto> result = new ArrayList<CommentDto>();
		if(list.isEmpty()){
			return null;
		}
		//处理每条评论
		for(Comment item:list) {
			CommentDto dto = new CommentDto();
			BeanUtils.copyProperties(item, dto);
			//techo
			TechoDto techoDto = new TechoDto();
			BeanUtils.copyProperties(item.getTecho(), techoDto);
			//图片
			techoDto.setImgsurl(techoService.imgNameToUrl(techoDto));
			
			dto.setTechoDto(techoDto);
			dto.setPage(commentDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public List<CommentDto> selectTechoCommentByPage(CommentDto commentDto) {
		List<Comment> list = commentDao.selectTechoCommentByPage(commentDto);
		List<CommentDto> result = new ArrayList<CommentDto>();
		if(list.isEmpty()){
			return null;
		}
		//处理每条评论
		for(Comment item:list) {
			CommentDto dto = new CommentDto();
			BeanUtils.copyProperties(item, dto);
			
			dto.setPage(commentDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public List<CommentDto> selectCommentsByPage(CommentDto commentDto) {
		List<Comment> list = commentDao.selectCommentsByPage(commentDto);
		List<CommentDto> result = new ArrayList<CommentDto>();
		if(list.isEmpty()){
			return null;
		}
		//处理每条评论
		for(Comment item:list) {
			CommentDto dto = new CommentDto();
			BeanUtils.copyProperties(item, dto);
			
			dto.setPage(commentDto.getPage());
			result.add(dto);
		}

		return result;
	}
	@Override
	public boolean deleteReceive(Long id) {
		if(commentDao.deleteReceive(id) == 1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(Long id) {
		if(commentDao.delete(id) == 1) {
			return true;
		}
		return false;
	}

}
