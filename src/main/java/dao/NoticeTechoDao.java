package dao;

import java.util.List;

import bean.NoticeTecho;


public interface NoticeTechoDao {
	/**
	 * ��������
	 * @param list noticeTecho�б�
	 * @return
	 */
	int insertBatch(List<NoticeTecho> list);
	int deleteNotice(NoticeTecho noticeTecho);
}
