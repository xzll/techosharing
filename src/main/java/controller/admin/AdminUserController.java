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
import dto.PageCodeDto;
import dto.UserDto;
import service.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	@Autowired
	private UserService userService;

	/**
	 * �û�����ҳ��ʼ��
	 */
	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		UserDto userDto = new UserDto();
		model.addAttribute("list", userService.searchByPage(userDto));
		model.addAttribute("searchParam", userDto);
		return "/userList";
	}

	/**
	 * ��ѯ
	 */
	@RequestMapping("/search")
	public String search(Model model, UserDto userDto) {
		model.addAttribute("list", userService.searchByPage(userDto));
		model.addAttribute("searchParam", userDto);
		return "/userList";
	}

	/**
	 * ɾ��
	 */
	@RequestMapping("/remove")
	public String remove(@RequestParam("id") Long id,Model model) {
		try{
			if(userService.remove(id)) {
				model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_SUCCESS);
			} else {
				model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_FAIL);
			}
		}catch(Exception e){
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_FAIL);
			e.printStackTrace();
		}
		return "forward:/admin/user";
	}


	/**
	 * ����
	 */
	@ResponseBody
	@RequestMapping("/add")
	public PageCodeDto add(@RequestBody UserDto userDto) {
		if(userService.isEmailExist(userDto.getEmail())){
			return new PageCodeDto(PageCodeEnum.REGISTER_EMAIL_EXIST);
		}
		if(userService.isUsernameExist(userDto)){
			return new PageCodeDto(PageCodeEnum.REGISTER_USERNAME_EXIST);
		}
		if (userService.addUser(userDto)) {
			return new PageCodeDto(PageCodeEnum.SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.FAIL);
		}
	}


	/**
	 * �޸�
	 */
	@ResponseBody
	@RequestMapping("/modify")
	public PageCodeDto modify(@RequestBody UserDto userDto) {
		if(userService.isUsernameExist(userDto)){
			return new PageCodeDto(PageCodeEnum.REGISTER_USERNAME_EXIST);
		}
		if (userService.modify(userDto)) {
			return new PageCodeDto(PageCodeEnum.UPDATE_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.UPDATE_FAIL);
		}
	}
}
