package service;

import java.util.List;

import bean.Material;
import dto.MaterialDto;

public interface MaterialService {
	/**
	 * ����ز�
	 * @param materialDto
	 * @return
	 */
	public boolean add(MaterialDto materialDto);
	/**
	 * �ز��б�
	 * @param tid
	 * @return
	 */
	public List<MaterialDto> getByPage(MaterialDto materialDto);
	/**
	 * �޸�
	 * @param materialDto
	 * @return
	 */
	public boolean update(MaterialDto materialDto);
	public boolean delete(Long id);
	boolean deleteAll(Material material,Long uid, boolean delImg);
	
}
