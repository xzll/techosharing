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
	 * �������
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
		} catch (Exception e) {//���ʲ�����
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �û�������
	 * @param commentDto uid �û�id��content ��������
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list/user")
	public List<CommentDto> userCommentList(@RequestBody CommentDto commentDto) {
		commentDto.setUid(((User)session.getAttribute("user")).getId());

		return commentService.searchUserCommentsByPage(commentDto);
	}
	/**
	 * ���ʵ�����
	 * @param commentDto tid ����id��content ��������
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/list/techo")
	public List<CommentDto> techoCommentList(@RequestBody CommentDto commentDto) {
		return commentService.selectTechoCommentByPage(commentDto);
	}
	/**
	 * �û��յ�������
	 * @param commentDto uid �û���content ��������
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
