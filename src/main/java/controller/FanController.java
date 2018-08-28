package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import constant.PageCodeEnum;
import dto.FanDto;
import dto.PageCodeDto;
import service.FanService;

@Controller
@RequestMapping("/fan")
public class FanController {
	
	@Autowired
	private FanService FanService;
	@Autowired
	private HttpSession session;
	@ResponseBody
	@RequestMapping("/add")
	public PageCodeDto add(@RequestBody FanDto fanDto) {
		fanDto.setFanid(((User)session.getAttribute("user")).getId());

		try {
			if(FanService.add(fanDto)){
				return new PageCodeDto(PageCodeEnum.FAN_ADD_SUCCESS);
			} else {
				return new PageCodeDto(PageCodeEnum.FAN_ADD_FAIL);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new PageCodeDto(PageCodeEnum.FAN_ADD_FAIL);
	}
	@ResponseBody
	@RequestMapping("/list")
	public List<FanDto> searchByUid(@RequestBody FanDto fanDto) {
		return FanService.searchFanByPage(fanDto);
	}
	@ResponseBody
	@RequestMapping("/followerList")
	public List<FanDto> searchByFanid(@RequestBody FanDto fanDto) {
		return FanService.searchFollowerByPage(fanDto);
	}
	@ResponseBody
	@RequestMapping("/noticeList")
	public List<FanDto> searchNotice(@RequestBody FanDto fanDto) {
		fanDto.setUid(((User)session.getAttribute("user")).getId());

		return FanService.searchNoticeByPage(fanDto);
	}
	@ResponseBody
	@RequestMapping("/del")
	public PageCodeDto del(@RequestBody FanDto fanDto){
		fanDto.setFanid(((User)session.getAttribute("user")).getId());

		if( FanService.delete(fanDto)){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);

		
		}
	}
	@ResponseBody
	@RequestMapping("/delNotice")
	public PageCodeDto delNotice(@RequestBody FanDto fanDto){
		fanDto.setFanid(((User)session.getAttribute("user")).getId());

		if( FanService.deleteNotice(fanDto)){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);

		
		}
	}
	
}
