package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import constant.PageCodeEnum;
import dto.PageCodeDto;
import dto.UserDto;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/account")
	public String account(){
		return "/account";
	}

	@ResponseBody
	@RequestMapping("/show")
	public UserDto show(@RequestBody User user){
		return userService.showInfo(user);
	}
	@ResponseBody
	@RequestMapping("/signIn")
	public User signIn(){
		return userService.signIn();
	}
	/**
	 * �޸��û���
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public PageCodeDto update(@RequestBody User user){
		try{
			if(userService.update(user)!=null){
				return new PageCodeDto(PageCodeEnum.UPDATE_SUCCESS);
			}
		}catch(Exception e){
			
			return new PageCodeDto(PageCodeEnum.REGISTER_USERNAME_EXIST);
		}
		return new PageCodeDto(PageCodeEnum.REGISTER_USERNAME_EXIST);
		
	}
	@ResponseBody
	@RequestMapping("/updateInfo")
	public PageCodeDto updateInfo(@RequestBody UserDto userDto){
		if(userService.updateInfo(userDto)!=null){
			return new PageCodeDto(PageCodeEnum.UPDATE_SUCCESS);
		}
		return new PageCodeDto(PageCodeEnum.UPDATE_FAIL);
		
	}
	@RequestMapping("/logout")
	public String logout(){
		userService.logout();
		return "redirect:/login";
	}
	@ResponseBody
	@RequestMapping("/loadHeadImg")
	public PageCodeDto loadHeadImg(UserDto userDto){
		if(userService.loadHeadImg(userDto)){
			return new PageCodeDto(PageCodeEnum.SUCCESS);
		}
		return new PageCodeDto(PageCodeEnum.FAIL);
		
	}
}
