package dao;


import java.util.List;

import bean.Collect;
import bean.Comment;

public interface CommentDao {
	/**
	 * 新增评论
	 * @param commentDto
	 * @return 影响行数
	 */
	int insert(Comment comment);
	/**
	 * 手帐id为tid的评论总数
	 * @param tid
	 * @return
	 */
	Long countByTid(Long tid);

	/**
	 * 查找该用户发出的评论
	 * @param comment 查找条件 uid 该用户id，content 内容
	 * @return 
	 */
	List<Comment> selectUserCommentsByPage(Comment comment);
	/**
	 * 查找该用户收到的评论
	 * @param comment 查找条件 uid 该用户id，content 内容
	 * @return 
	 */
	List<Comment> selectUserReceiveCommentsByPage(Comment comment);
	/**
	 * 查找手帐下的评论
	 * @param comment 查找条件 tid 手帐id，content 内容
	 * @return 
	 */
	List<Comment> selectTechoCommentByPage(Comment comment);
	
	List<Comment> selectCommentsByPage(Comment comment);
	
	/**
	 * 根据id查找评论
	 * @param id
	 * @return
	 */
	Comment selectById(Long id);
	/**
	 * 删除收到的评论
	 * 即将del至1，并不是真正的删除
	 * @param id
	 * @return
	 */
	int deleteReceive(Long id);
	/**
	 * 删除评论
	 * 真正的从数据库中删除
	 * @param id
	 * @return
	 */
	int delete(Long id);
	
	int deleteAll(Comment comment);
	
}
