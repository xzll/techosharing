package service;


import java.util.List;

import bean.Comment;
import dto.CommentDto;

public interface CommentService {
	/**
	 * �������ۣ�
	 * �����߷�����Ϣ����
	 * ������CommentDto����Ϣ��id,createtime�ȣ�
	 * @param commentDto
	 * @return true �ɹ���false ʧ��
	 */
	public boolean add(CommentDto commentDto);
	
	public List<CommentDto> searchUserCommentsByPage(CommentDto commentDto);
	
	public List<CommentDto> selectUserReceiveCommentsByPage(CommentDto commentDto);
	
	public List<CommentDto> selectTechoCommentByPage(CommentDto commentDto);
	/**
	 * �û�ɾ���յ�������
	 * ����del��1��������������ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteReceive(Long id);
	/**
	 * �û�ɾ���Լ�������
	 * �����Ĵ����ݿ���ɾ��
	 * @param id
	 * @return
	 */
	public boolean delete(Long id);

	List<CommentDto> selectCommentsByPage(CommentDto commentDto);
}
