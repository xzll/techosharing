package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import dto.PageCodeDto;
import dto.PurchaseDto;
import service.PurchaseService;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private HttpSession session;
	@ResponseBody
	@RequestMapping("/add")
	public PageCodeDto add(@RequestBody PurchaseDto purchaseDto){
		purchaseDto.setUid(((User)session.getAttribute("user")).getId());
		PageCodeDto pageCodeDto = new PageCodeDto();
		try{
			purchaseService.add(purchaseDto);
		} catch(RuntimeException e){
			e.printStackTrace();
			pageCodeDto.setMsg("购买失败，有可能余额不足或素材已售完");
			return pageCodeDto;
		}
		pageCodeDto.setMsg("购买成功");
		return pageCodeDto;
	}
	@ResponseBody
	@RequestMapping("/buyList")
	public List<PurchaseDto> searchByPage(@RequestBody PurchaseDto purchaseDto){
		purchaseDto.setUid(((User)session.getAttribute("user")).getId());

		return purchaseService.searchByUidByPage(purchaseDto);
	}
	@ResponseBody
	@RequestMapping("/sellList")
	public List<PurchaseDto> searchSellByPage(@RequestBody PurchaseDto purchaseDto){
		purchaseDto.setUid(((User)session.getAttribute("user")).getId());

		return purchaseService.searchSellByPage(purchaseDto);
	}
}
