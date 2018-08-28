package controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.NoticeTecho;
import bean.User;
import constant.PageCodeEnum;
import dto.PageCodeDto;
import dto.TechoDto;
import service.TechoService;

@Controller
@RequestMapping("/techo")
public class TechoController {
	
	@Autowired
	private TechoService techoService;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/uploadJo")
	public String uploadJo(){
		return "/uploadJo";
	}
	
	@ResponseBody
	@RequestMapping("/add")
	public PageCodeDto addTecho(TechoDto techoDto/*,Model model*/){
		PageCodeDto pageCodeDto = new PageCodeDto(PageCodeEnum.TECHO_ADD_FAIL);
		System.out.println(techoDto.getTitle());
		techoDto.setUid(((User)session.getAttribute("user")).getId());
		if(techoService.add(techoDto)) {
			pageCodeDto = new PageCodeDto(PageCodeEnum.TECHO_ADD_SUCCESS);
			pageCodeDto.setMsg(""+techoDto.getId());
			return pageCodeDto;
//			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.TECHO_ADD_SUCCESS);
		}else{
			return pageCodeDto;
//			model.addAttribute(PageCodeEnum.KEY,PageCodeEnum.TECHO_ADD_FAIL);
		}
		
//		return "/index";//跳转到index.jsp
	}
	/**
	 * 手帐列表
	 * @param techoDto 查询条件（page一定要，uid,content 主页的可为空，自己的填uid，别人的填uid，
	 * 关注者动态填noticeTechoUid即自己的id）
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/search")
	public List<TechoDto> searchByPage(@RequestBody TechoDto techoDto){
		return techoService.searchByPage(techoDto);
	}
	/**
	 * 手帐
	 * @param techoDto 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/search/{id}")
	public TechoDto searchById(@PathVariable(value="id") String id){
		
		return techoService.searchById(Long.valueOf(id));
	}
	@ResponseBody
	@RequestMapping("/delNotice")
	public PageCodeDto delNotice(@RequestBody NoticeTecho noticeTecho){
		noticeTecho.setUid(((User)session.getAttribute("user")).getId());
		if(techoService.deleteNotice(noticeTecho)){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		}else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);
		}
		
	}
	@ResponseBody
	@RequestMapping("/del")
	public PageCodeDto del(@RequestBody NoticeTecho noticeTecho){
		//TODO 加用户id
		try {
			if(techoService.delete(noticeTecho.getTid(),true)){
				return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
			}else {
				return new PageCodeDto(PageCodeEnum.DEL_FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);
			
		}
	}
	/**
	 * 手帐列表
	 * @param techoDto
	 * @return
	 */
/*	@RequestMapping
	public String search(Model model,TechoDto techoDto){
		model.addAttribute("list", techoService.searchByPage(techoDto));
		
		return "";
	}*/
}
