package dao;


import java.util.List;

import bean.User;

public interface UserDao {
	/**
     * 根据查询条件查询用户
     * @param user 查询条件(username/password/email)
     * @return 用户
     */
    List<User> select(User user);
    
    /**
     * 新增
     * @param user
     * @return 影响行数：如果用户名已存在，影响行数为0，新增成功，影响行数为1
     */
    int insert(User user);
    /**
     * 新增
     * @param user
     * @return 影响行数：如果用户名或昵称已存在，影响行数为0，新增成功，影响行数为1
     */
    int insertUser(User user);
    
    /**
     * 根据主键获取用户实体
     * @param id 主键
     * @return 用户实体
     */
    User selectById(Long id);
    List<User> selectByPage(User user);
    /**
     * 
     * @param user id,coin 增加或减少的数量
     * @return 1 成功，0 失败，coin减后小于0
     */
    int coinAddAndSub(User user);
    /**
     * 修改
     * @param user
     * @return 影响行数：如用户名将修改成与其他用户的用户名相同，影响行数为0，修改成功，影响行数为1
     */
    int update(User user);
    int updateInfo(User user);
    int signIn(User user);
    Long countTecho(Long id);
    Long countFan(Long id);
    Long countFollower(Long id);
    /**
     * 根据主键删除
     * @param id 主键
     * @return 影响行数
     */
    int delete(Long id);
    int updateRead(User user);
    int updateAllRead();
}
