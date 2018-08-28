package service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import bean.Material;
import bean.Purchase;
import bean.User;
import dao.MaterialDao;
import dao.PurchaseDao;
import dto.MaterialDto;
import service.MaterialService;
import utils.CommonUtil;
@Service
public class MaterialSerivceImpl implements MaterialService{
	@Value("${techoImage.saveFolder}")
	private String techoImageFolder;
	@Value("${techoImage.url}")
	private String techoImageUrl;
	@Autowired
	private MaterialDao materialDao;
	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private HttpSession session;
	@Override
	public boolean add(MaterialDto materialDto) {
		MultipartFile imgFile = materialDto.getImgFile();
		if(imgFile.getSize() > 0 ){
			String fileName = System.currentTimeMillis() + "_" + imgFile.getOriginalFilename();
			String path = techoImageFolder+materialDto.getTid()+"/";
			File file = new File(path+fileName);
			File fileFolder = new File(path);
			if(!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			
			try {
				imgFile.transferTo(file);
				materialDto.setImgname(fileName);
			} catch (IllegalStateException | IOException e ) {
				e.printStackTrace();
				return false;
			} 
		}
		Material material = new Material();
		BeanUtils.copyProperties(materialDto, material);
		if(materialDao.insert(material)==1){
			materialDto.setId(material.getId());
			return true;
		}
		return false;
}
	@Override
	public List<MaterialDto> getByPage(MaterialDto materialDto) {
		List<Material> list = materialDao.getByTidByPage(materialDto);
		List<MaterialDto> result = new ArrayList<MaterialDto>();
		for(Material item:list){
			MaterialDto dto = new MaterialDto();
			BeanUtils.copyProperties(item, dto);
			if(item.getImgname()!=null){
				dto.setImgurl(techoImageUrl+item.getTid()+"/"+item.getImgname());
			}
			
			dto.setPage(materialDto.getPage());
			result.add(dto);
		}
		return result;
	}
	@Override
	public boolean update(MaterialDto materialDto) {
		//´¦ÀíÍ¼Æ¬
		MultipartFile imgfile = materialDto.getImgFile();
		if(imgfile !=null && imgfile.getSize() > 0){
			String fileName = materialDao.selectById(materialDto.getId()).getImgname();
			if(fileName ==null) {
				fileName = System.currentTimeMillis() + "_" + imgfile.getOriginalFilename();
			}
			String path = techoImageFolder+materialDto.getTid()+"/";
			File file = new File(path+fileName);
			File fileFolder = new File(path);
			if(!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			
			try {
				materialDto.getImgFile().transferTo(file);
				materialDto.setImgname(fileName);
			} catch (IllegalStateException | IOException e ) {
				e.printStackTrace();
				return false;
			}
				
		}
		if(materialDao.update(materialDto)==1){
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(Long id) {
		return materialDao.delete(id)==1;
	}
	@Transactional
	@Override
	public boolean deleteAll(Material material,Long uid,boolean delImg){
		List<Material> list = materialDao.getByTid(material);
		
		if(list.isEmpty()){
			return true;
		}
		for(Material item:list){
			if(delImg){
				CommonUtil.delFile(techoImageFolder+"/"+material.getTid()+material.getImgname());
			}
			
			Purchase purchase = new Purchase();
			purchase.setMid(item.getId());
			purchaseDao.deleteAll(purchase);
		}
		
		materialDao.deleteAll(material);
		
		return true;
		
	}
}