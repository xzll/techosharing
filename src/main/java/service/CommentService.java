package service;


import java.util.List;

import bean.Comment;
import dto.CommentDto;

public interface CommentService {
	/**
	 * 新增评论，
	 * 给作者发送消息提醒
	 * 并完善CommentDto的信息（id,createtime等）
	 * @param commentDto
	 * @return true 成功；false 失败
	 */
	public boolean add(CommentDto commentDto);
	
	public List<CommentDto> searchUserCommentsByPage(CommentDto commentDto);
	
	public List<CommentDto> selectUserReceiveCommentsByPage(CommentDto commentDto);
	
	public List<CommentDto> selectTechoCommentByPage(CommentDto commentDto);
	/**
	 * 用户删除收到的评论
	 * 即将del至1，并不是真正的删除
	 * @param id
	 * @return
	 */
	public boolean deleteReceive(Long id);
	/**
	 * 用户删除自己的评论
	 * 真正的从数据库中删除
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

	List<CommentDto> selectCommentsByPage(CommentDto commentDto);
}
