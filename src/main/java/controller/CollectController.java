package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import constant.PageCodeEnum;
import dto.CollectDto;
import dto.CommentDto;
import dto.PageCodeDto;
import service.CollectService;

@Controller
@RequestMapping("/collection")
public class CollectController {

	@Autowired
	private CollectService collectService;
	@Autowired
	private HttpSession session;
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public PageCodeDto add(@RequestBody CollectDto collectDto) {
		collectDto.setUid(((User)session.getAttribute("user")).getId());

		PageCodeDto pageCodeDto;
		if(collectService.add(collectDto)){
			pageCodeDto = new PageCodeDto(PageCodeEnum.COLLECTION_SUCCESS);
		} else {
			pageCodeDto = new PageCodeDto(PageCodeEnum.COLLECTION_FAIL);
		}
		return pageCodeDto;
	}
	@ResponseBody
	@RequestMapping("/list/user")
	public List<CollectDto> userCollectList(@RequestBody CollectDto collectDto) {
		collectDto.setUid(((User)session.getAttribute("user")).getId());

		return collectService.searchByUidByPage(collectDto);
	}
	@ResponseBody
	@RequestMapping("/list/notice")
	public List<CollectDto> beCollectList(@RequestBody CollectDto collectDto) {
		collectDto.setUid(((User)session.getAttribute("user")).getId());

		return collectService.searchBeCollectByPage(collectDto);
	}

	@ResponseBody
	@RequestMapping("/del")
	public PageCodeDto del(@RequestBody CollectDto collectDto) {
		collectDto.setUid(((User)session.getAttribute("user")).getId());
		if(collectService.delete(collectDto)){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);

		}
	}
	@ResponseBody
	@RequestMapping("/delReceive")
	public PageCodeDto delReceive(@RequestBody CollectDto collectDto) {
		collectDto.setUid(((User)session.getAttribute("user")).getId());

		if(collectService.deleteReceive(collectDto)){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);

		}
	}
}
