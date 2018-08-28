package dao;


import java.util.List;

import bean.User;

public interface UserDao {
	/**
     * ���ݲ�ѯ������ѯ�û�
     * @param user ��ѯ����(username/password/email)
     * @return �û�
     */
    List<User> select(User user);
    
    /**
     * ����
     * @param user
     * @return Ӱ������������û����Ѵ��ڣ�Ӱ������Ϊ0�������ɹ���Ӱ������Ϊ1
     */
    int insert(User user);
    /**
     * ����
     * @param user
     * @return Ӱ������������û������ǳ��Ѵ��ڣ�Ӱ������Ϊ0�������ɹ���Ӱ������Ϊ1
     */
    int insertUser(User user);
    
    /**
     * ����������ȡ�û�ʵ��
     * @param id ����
     * @return �û�ʵ��
     */
    User selectById(Long id);
    List<User> selectByPage(User user);
    /**
     * 
     * @param user id,coin ���ӻ���ٵ�����
     * @return 1 �ɹ���0 ʧ�ܣ�coin����С��0
     */
    int coinAddAndSub(User user);
    /**
     * �޸�
     * @param user
     * @return Ӱ�����������û������޸ĳ��������û����û�����ͬ��Ӱ������Ϊ0���޸ĳɹ���Ӱ������Ϊ1
     */
    int update(User user);
    int updateInfo(User user);
    int signIn(User user);
    Long countTecho(Long id);
    Long countFan(Long id);
    Long countFollower(Long id);
    /**
     * ��������ɾ��
     * @param id ����
     * @return Ӱ������
     */
    int delete(Long id);
    int updateRead(User user);
    int updateAllRead();
}
