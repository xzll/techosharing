package dao;


import java.util.List;

import bean.Collect;

public interface CollectDao {

	/**
	 * 添加收藏的记录
	 * @param collect tid 手帐id uid 收藏该手帐用户
	 * @return 影响行数
	 */
	int insert(Collect collect);
	/**
	 * 手帐id为tid的收藏总数
	 * @param tid
	 * @return
	 */
	Long countByTid(Long tid);
	/**
	 * 查找用户收藏的
	 * @param collect uid,techo.content
	 * @return
	 */
	List<Collect> selectByUidByPage(Collect collect);
	/**
	 * 查找用户被收藏的
	 * @param collect uid ,techo.content
	 * @return
	 */
	List<Collect> selectBeCollectByPage(Collect collect);
	/**
	 * 删除收到的收藏
	 * 即将del至1，并不是真正的删除
	 * @param id
	 * @return
	 */
	int deleteReceive(Collect collect);
	/**
	 * 删除自己的收藏
	 * 真正的从数据库中删除
	 * @param id
	 * @return
	 */
	int delete(Collect collect);
	
	int deleteAll(Collect collect);
}
