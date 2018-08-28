package dao;

import java.util.List;

import bean.Comment;
import bean.Fan;

public interface FanDao {
	/**
	 * �û�����ע��������˿
	 * @param fan ��˿�����
	 * @return Ӱ������
	 */
	int insert(Fan fan);
	/**
	 * �����û������з�˿
	 * @param uid ���û���id
	 * @return ��˿�б�
	 */
	List<Fan> selectByUid(Long uid);
	/**
	 * �����û���ע��������
	 * @param fanid �û���id
	 * @return ��ע�б�
	 */
	List<Fan> selectByFanid(Long fanid);
	List<Fan> selectByUidByPage(Fan fan);
	List<Fan> selectByFanidByPage(Fan fan);
	List<Fan> selectNoticeByPage(Fan fan);
	int deleteNotice(Fan fan);
	int delete(Fan fan);
	int deleteAll(Fan fan);
}
