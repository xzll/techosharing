package dao;


import java.util.List;

import bean.Collect;

public interface CollectDao {

	/**
	 * ����ղصļ�¼
	 * @param collect tid ����id uid �ղظ������û�
	 * @return Ӱ������
	 */
	int insert(Collect collect);
	/**
	 * ����idΪtid���ղ�����
	 * @param tid
	 * @return
	 */
	Long countByTid(Long tid);
	/**
	 * �����û��ղص�
	 * @param collect uid,techo.content
	 * @return
	 */
	List<Collect> selectByUidByPage(Collect collect);
	/**
	 * �����û����ղص�
	 * @param collect uid ,techo.content
	 * @return
	 */
	List<Collect> selectBeCollectByPage(Collect collect);
	/**
	 * ɾ���յ����ղ�
	 * ����del��1��������������ɾ��
	 * @param id
	 * @return
	 */
	int deleteReceive(Collect collect);
	/**
	 * ɾ���Լ����ղ�
	 * �����Ĵ����ݿ���ɾ��
	 * @param id
	 * @return
	 */
	int delete(Collect collect);
	
	int deleteAll(Collect collect);
}
