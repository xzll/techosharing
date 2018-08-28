package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.NoticeDto;
import service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@ResponseBody
	@RequestMapping("/read")
	public Boolean readNotice(){
		return noticeService.readNotice();
	}
	@ResponseBody
	@RequestMapping
	public NoticeDto getCurrentNotice(){
		return noticeService.getCurrentNotice();
	}
}
