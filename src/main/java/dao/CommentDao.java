package dao;


import java.util.List;

import bean.Collect;
import bean.Comment;

public interface CommentDao {
	/**
	 * ��������
	 * @param commentDto
	 * @return Ӱ������
	 */
	int insert(Comment comment);
	/**
	 * ����idΪtid����������
	 * @param tid
	 * @return
	 */
	Long countByTid(Long tid);

	/**
	 * ���Ҹ��û�����������
	 * @param comment �������� uid ���û�id��content ����
	 * @return 
	 */
	List<Comment> selectUserCommentsByPage(Comment comment);
	/**
	 * ���Ҹ��û��յ�������
	 * @param comment �������� uid ���û�id��content ����
	 * @return 
	 */
	List<Comment> selectUserReceiveCommentsByPage(Comment comment);
	/**
	 * ���������µ�����
	 * @param comment �������� tid ����id��content ����
	 * @return 
	 */
	List<Comment> selectTechoCommentByPage(Comment comment);
	
	List<Comment> selectCommentsByPage(Comment comment);
	
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	Comment selectById(Long id);
	/**
	 * ɾ���յ�������
	 * ����del��1��������������ɾ��
	 * @param id
	 * @return
	 */
	int deleteReceive(Long id);
	/**
	 * ɾ������
	 * �����Ĵ����ݿ���ɾ��
	 * @param id
	 * @return
	 */
	int delete(Long id);
	
	int deleteAll(Comment comment);
	
}
