package controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import constant.PageCodeEnum;
import dto.CommentDto;
import dto.PageCodeDto;
import service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private HttpSession session;
	/**
	 * 添加评论
	 * @param commentDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public CommentDto add(@RequestBody CommentDto commentDto) {
		try {
			commentDto.setUid(((User)session.getAttribute("user")).getId());
			if(commentService.add(commentDto)){
				return commentDto;
			}
		} catch (Exception e) {//手帐不存在
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 用户的评论
	 * @param commentDto uid 用户id，content 查找内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list/user")
	public List<CommentDto> userCommentList(@RequestBody CommentDto commentDto) {
		commentDto.setUid(((User)session.getAttribute("user")).getId());

		return commentService.searchUserCommentsByPage(commentDto);
	}
	/**
	 * 手帐的评论
	 * @param commentDto tid 手帐id，content 查找内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list/techo")
	public List<CommentDto> techoCommentList(@RequestBody CommentDto commentDto) {
		return commentService.selectTechoCommentByPage(commentDto);
	}
	/**
	 * 用户收到的评论
	 * @param commentDto uid 用户，content 查找内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list/receive")
	public List<CommentDto> receiveCommentList(@RequestBody CommentDto commentDto) {
		commentDto.setUid(((User)session.getAttribute("user")).getId());

		return commentService.selectUserReceiveCommentsByPage(commentDto);
	}
	//TODO ??
	@ResponseBody
	@RequestMapping("/del")
	public PageCodeDto del(@RequestBody  CommentDto commentDto) {
		if(commentService.delete(commentDto.getId())){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);

		} else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);

		}
	}
	@ResponseBody
	@RequestMapping("/delReceive")
	public PageCodeDto delReceive(@RequestBody CommentDto commentDto) {
		if(commentService.deleteReceive(commentDto.getId())){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);

		}
	}
	
}
