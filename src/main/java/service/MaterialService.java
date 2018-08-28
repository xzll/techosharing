package service;

import java.util.List;

import bean.Material;
import dto.MaterialDto;

public interface MaterialService {
	/**
	 * 添加素材
	 * @param materialDto
	 * @return
	 */
	public boolean add(MaterialDto materialDto);
	/**
	 * 素材列表
	 * @param tid
	 * @return
	 */
	public List<MaterialDto> getByPage(MaterialDto materialDto);
	/**
	 * 修改
	 * @param materialDto
	 * @return
	 */
	public boolean update(MaterialDto materialDto);
	public boolean delete(Long id);
	boolean deleteAll(Material material,Long uid, boolean delImg);
	
}
