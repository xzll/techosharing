package controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constant.PageCodeEnum;
import dto.CommentDto;
import service.CommentService;
@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		CommentDto commentDto = new CommentDto();
		model.addAttribute("list", commentService.selectCommentsByPage(commentDto));
		model.addAttribute("searchParam", commentDto);
		return "/commentList";
	}

	/**
	 * ²éÑ¯
	 */
	@RequestMapping("/search")
	public String search(Model model, CommentDto CommentDto) {
		model.addAttribute("list", commentService.selectCommentsByPage(CommentDto));
		model.addAttribute("searchParam", CommentDto);
		return "/commentList";
	}

	/**
	 * É¾³ý
	 */
	@RequestMapping("/remove")
	public String remove(@RequestParam("id") Long id,Model model) {
		if(commentService.delete(id)) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_SUCCESS);
		} else {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_FAIL);
		}
		return "forward:/admin/comment";
	}
}
