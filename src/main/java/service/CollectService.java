package service;

import java.util.List;

import dto.CollectDto;

public interface CollectService {

	/**
	 * 添加收藏的记录，并通知作者
	 * @param collectDto
	 * @return true 成功 false 失败
	 */
	public boolean add(CollectDto collectDto);
	/**
	 * 用户收藏列表
	 * @param collect uid,techo.content 查找内容
	 * @return
	 */
	public List<CollectDto> searchByUidByPage(CollectDto collectDto);
	/**
	 * 用户手帐被收藏的通知列表
	 * @param collect uid ,techo.content 查找内容
	 * @return
	 */
	public List<CollectDto> searchBeCollectByPage(CollectDto collectDto);
	/**
	 * 删除收藏通知
	 * 即将del至1，并不是真正的删除
	 * @param id
	 * @return
	 */
	public boolean deleteReceive(CollectDto collectDto);
	/**
	 * 删除自己的收藏
	 * 真正的从数据库中删除
	 * @param id
	 * @return
	 */
	public boolean delete(CollectDto collectDto);
}
