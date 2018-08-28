package dao;


import java.util.List;

import bean.Comment;
import bean.Material;

public interface MaterialDao {
	/**
	 * Ìí¼ÓËØ²ÄÊÛÂô
	 * @param material
	 * @return
	 */
	public int insert(Material material);
	public List<Material> getByTidByPage(Material material);
	public int update(Material material);
	public int delete(Long id);
	public int numberAddAndSub(Material material);
	public Material selectById(Long id);
	
	int deleteAll(Material material);
	public List<Material> getByTid(Material material);
	
}
