package dao;


import java.util.List;

import bean.Comment;
import bean.Thumbup;

public interface ThumbupDao {

	/**
	 * 添加赞的记录
	 * @param thumbup uid 点赞的用户 tid 被赞的手帐
	 * @return 影响行数
	 */
	int insert(Thumbup thumbup);
	/**
	 * 手帐id为tid的点赞数
	 * @param tid
	 * @return
	 */
	Long countByTid(Long tid);
	/**
	 * 通知：谁赞了我
	 * @param thumbup uid，techo.content
	 * @return
	 */
	List<Thumbup> selectBeThumbupByPage(Thumbup thumbup);
	/**
	 * 我赞了谁
	 * @param thumbup uid，techo.content
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
