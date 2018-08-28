package controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import constant.PageCodeEnum;
import dto.NoticeDto;
import dto.PageCodeDto;
import dto.TechoDto;
import dto.NoticeDto;
import service.NoticeService;

@Controller
@RequestMapping("/admin/notice")
public class AdminNoticeController {
	@Autowired
	private NoticeService noticeService;
	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		NoticeDto noticeDto = new NoticeDto();
		model.addAttribute("notice",noticeService.getCurrentNotice());
		model.addAttribute("list", noticeService.searchByPage(noticeDto));
		model.addAttribute("searchParam", noticeDto);
		return "/noticeList";
	}
	@ResponseBody
	@RequestMapping("/add")
	public PageCodeDto add(@RequestBody NoticeDto  noticeDto){
		PageCodeDto pageCodeDto;
		if(noticeService.add(noticeDto)){
			pageCodeDto = new PageCodeDto(PageCodeEnum.SUCCESS);
		}else {
			pageCodeDto = new PageCodeDto(PageCodeEnum.FAIL);
		}
		return pageCodeDto;
	}
	@RequestMapping("/search")
	public String search(Model model, NoticeDto noticeDto) {
		model.addAttribute("notice",noticeService.getCurrentNotice());
		model.addAttribute("list", noticeService.searchByPage(noticeDto));
		model.addAttribute("searchParam", noticeDto);
		return "/noticeList";
	}
	/**
	 * É¾³ý
	 */
	@RequestMapping("/remove")
	public String remove(@RequestParam("id") Long id,Model model) {
		if(noticeService.remove(id)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_FAIL);
		}
		return "forward:/admin/notice";
	}
}
