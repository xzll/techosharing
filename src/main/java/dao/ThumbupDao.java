package dao;


import java.util.List;

import bean.Comment;
import bean.Thumbup;

public interface ThumbupDao {

	/**
	 * ����޵ļ�¼
	 * @param thumbup uid ���޵��û� tid ���޵�����
	 * @return Ӱ������
	 */
	int insert(Thumbup thumbup);
	/**
	 * ����idΪtid�ĵ�����
	 * @param tid
	 * @return
	 */
	Long countByTid(Long tid);
	/**
	 * ֪ͨ��˭������
	 * @param thumbup uid��techo.content
	 * @return
	 */
	List<Thumbup> selectBeThumbupByPage(Thumbup thumbup);
	/**
	 * ������˭
	 * @param thumbup uid��techo.content
	 * @return
	 */
	List<Thumbup> selectMyThumbupByPage(Thumbup thumbup);
	/**
	 * 
	 * @param thumbup uid,tid
	 * @return
	 */
	int deleteNotice(Thumbup thumbup);
	int delete(Thumbup thumbup);
	int deleteAll(Thumbup thumbup);
	
}
