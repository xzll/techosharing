package dao;

import java.util.List;

import bean.NoticeTecho;


public interface NoticeTechoDao {
	/**
	 * 批量新增
	 * @param list noticeTecho列表
	 * @return
	 */
	int insertBatch(List<NoticeTecho> list);
	int deleteNotice(NoticeTecho noticeTecho);
}
