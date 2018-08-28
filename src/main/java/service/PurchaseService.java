package service;

import java.util.List;

import bean.Purchase;
import dto.PurchaseDto;

public interface PurchaseService {
	/**
	 * 
	 * @param purchase uid,mid,content
	 * @return
	 */
	public boolean add(PurchaseDto purchaseDto);
	/**
	 * 
	 * @param purchase uid
	 * @return
	 */
	public List<PurchaseDto> searchByUidByPage(PurchaseDto purchaseDto);
	/**
	 * 
	 * @param purchase uid
	 * @return
	 */
	public List<PurchaseDto> searchSellByPage(PurchaseDto purchaseDto);
	
	/**
	 * 
	 * @param purchase tid,uid
	 * @return
	 */
//	public int delete(PurchaseDto purchaseDto);
}
