package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import constant.PageCodeEnum;
import dto.PageCodeDto;
import dto.ThumbupDto;
import service.ThumbupService;

@Controller
@RequestMapping("/thumbup")
public class ThumbupController {
	@Autowired
	private ThumbupService thumbupService;
	@Autowired
	private HttpSession session;
	/**
	 * 
	 * @param thumbupDto tid uid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public PageCodeDto add(@RequestBody ThumbupDto thumbupDto) {
		PageCodeDto pageCodeDto = new PageCodeDto(PageCodeEnum.THUMPUP_FAIL);;
		thumbupDto.setUid(((User)session.getAttribute("user")).getId());
		try {
			if(thumbupService.thumbup(thumbupDto)){
				pageCodeDto = new PageCodeDto(PageCodeEnum.THUMPUP_SUCCESS);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return pageCodeDto;
	}
	/**
	 * Œ“‘ﬁ¡ÀÀ≠
	 * @param thumbupDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/myThumbupList")
	public List<ThumbupDto> searchMyThumbup(@RequestBody ThumbupDto thumbupDto){
		thumbupDto.setUid(((User)session.getAttribute("user")).getId());

		return thumbupService.searchMyThumbupByPage(thumbupDto);
	}
	@ResponseBody
	@RequestMapping("/notice")
	public List<ThumbupDto> searchNotice(@RequestBody ThumbupDto thumbupDto){
		thumbupDto.setUid(((User)session.getAttribute("user")).getId());

		return thumbupService.searchBeThumbupByPage(thumbupDto);
	}
	@ResponseBody
	@RequestMapping("/delNotice")
	public PageCodeDto delNotice(@RequestBody ThumbupDto thumbupDto){
		if(thumbupService.delNotice(thumbupDto)){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		}else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);
		}
	}
	@ResponseBody
	@RequestMapping("/del")
	public PageCodeDto del(@RequestBody ThumbupDto thumbupDto){
		thumbupDto.setUid(((User)session.getAttribute("user")).getId());

		if(thumbupService.del(thumbupDto)){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		}else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);
		}
	}
}
