package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;

import bean.Material;
import bean.Purchase;
import bean.User;
import dao.MaterialDao;
import dao.PurchaseDao;
import dao.TechoDao;
import dao.UserDao;
import dto.MaterialDto;
import dto.PurchaseDto;
import notice.SpringWebSocketHandler;
import service.PurchaseService;
@Service
public class PurchaseServiceImpl implements PurchaseService{
	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private MaterialDao materialDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private TechoDao techoDao;
	@Autowired
	private SpringWebSocketHandler websocket;
	@Value("${techoImage.saveFolder}")
	private String techoImageFolder;
	@Value("${techoImage.url}")
	private String techoImageUrl;
	@Transactional
	@Override
	public boolean add(PurchaseDto purchaseDto) throws RuntimeException {
		purchaseDto.setContent(userDao.selectById(purchaseDto.getUid()).getContact());
		Material material = materialDao.selectById(purchaseDto.getMid());
		User user = new User();
		user.setId(purchaseDto.getUid());
		user.setCoin(-material.getPrice());
		//�������coin
		if(userDao.coinAddAndSub(user)==1){
			material.setNumber(-1l);
			//�ز�������һ
			if(materialDao.numberAddAndSub(material)==1){
				user.setId(techoDao.selectById(material.getTid()).getUid());
				user.setCoin(material.getPrice());
				userDao.coinAddAndSub(user);//���һ��coin
				purchaseDao.insert(purchaseDto);//�ɹ����ף���ӽ�������
				websocket.sendMessageToUser(user.getId(), new TextMessage("֪ͨ���زı�����"));
			} else{
				throw new RuntimeException("���ﲻ��");
			}
		}else{
			throw new RuntimeException("���Ҳ���");
		}
		return true;
	}

	@Override
	public List<PurchaseDto> searchByUidByPage(PurchaseDto purchaseDto) {
		List<Purchase> list = purchaseDao.selectByUidByPage(purchaseDto);
		List<PurchaseDto> result = new ArrayList<PurchaseDto>();
		for(Purchase item:list) {
			PurchaseDto dto = new PurchaseDto();
			BeanUtils.copyProperties(item, dto);
			
			Material material = dto.getMaterial();
			MaterialDto materialDto = new MaterialDto();
			if(material.getImgname()!=null){
				String imgurl = techoImageUrl+material.getTid()+"/"+material.getImgname();
				materialDto.setImgurl(imgurl);
			}
			BeanUtils.copyProperties(material, materialDto);
			
			dto.setMaterialDto(materialDto);
			dto.setPage(purchaseDto.getPage());//��ҳ
			result.add(dto);
		}
		return result;
	}

	@Override
	public List<PurchaseDto> searchSellByPage(PurchaseDto purchaseDto) {
		List<Purchase> list = purchaseDao.selectSellByPage(purchaseDto);
		List<PurchaseDto> result = new ArrayList<PurchaseDto>();
		for(Purchase item:list) {
			PurchaseDto dto = new PurchaseDto();
			BeanUtils.copyProperties(item, dto);
			
			Material material = dto.getMaterial();
			MaterialDto materialDto = new MaterialDto();
			if(material.getImgname()!=null){
				String imgurl = techoImageUrl+material.getTid()+"/"+material.getImgname();
				materialDto.setImgurl(imgurl);
			}
			BeanUtils.copyProperties(material, materialDto);
			dto.setMaterialDto(materialDto);
			dto.setPage(purchaseDto.getPage());
			result.add(dto);
		}
		return result;
	}

}
