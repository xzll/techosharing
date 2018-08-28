package dao;

import java.util.List;

import bean.Comment;
import bean.Purchase;

public interface PurchaseDao {
	/**
	 * 
	 * @param purchase uid,mid,content
	 * @return
	 */
	public int insert(Purchase purchase);
	/**
	 * 
	 * @param purchase uid
	 * @return
	 */
	public List<Purchase> selectByUidByPage(Purchase purchase);
	/**
	 * 
	 * @param purchase
	 * @return
	 */
	public List<Purchase> selectSellByPage(Purchase purchase);
	int deleteAll(Purchase purchase);
	/**
	 * 
	 * @param purchase tid,uid
	 * @return
	 */
//	public int delete(Purchase purchase);
}
