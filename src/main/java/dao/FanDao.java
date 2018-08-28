package dao;

import java.util.List;

import bean.Comment;
import bean.Fan;

public interface FanDao {
	/**
	 * 用户被关注，新增粉丝
	 * @param fan 粉丝表对象
	 * @return 影响行数
	 */
	int insert(Fan fan);
	/**
	 * 查找用户的所有粉丝
	 * @param uid 该用户的id
	 * @return 粉丝列表
	 */
	List<Fan> selectByUid(Long uid);
	/**
	 * 查找用户关注的所有人
	 * @param fanid 用户的id
	 * @return 关注列表
	 */
	List<Fan> selectByFanid(Long fanid);
	List<Fan> selectByUidByPage(Fan fan);
	List<Fan> selectByFanidByPage(Fan fan);
	List<Fan> selectNoticeByPage(Fan fan);
	int deleteNotice(Fan fan);
	int delete(Fan fan);
	int deleteAll(Fan fan);
}
