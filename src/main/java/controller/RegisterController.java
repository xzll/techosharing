package controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.PageCodeEnum;
import dto.PageCodeDto;
import dto.UserDto;
import service.UserService;
import utils.CommonUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {
	/**
	 * 用户服务
	 */
	@Autowired
	private UserService userService;
	/**
	 * session注入
	 */
	@Autowired
	private HttpSession session;
	@RequestMapping
	public String index(){
		return "/index";
	}
	/**
	 * 注册
	 * @param userDto
	 * @param attr
	 * @return userDto.email userDto.password userDto.code pageCode.msg
	 * userDto.id userDto.username
	 */
	@RequestMapping("/validate")
	public String register(UserDto userDto,RedirectAttributes attr){
		//将属性放进session中，为重定向做准备
		attr.addFlashAttribute("userDto", userDto);
		//检查邮箱格式是否正确
		if(!userService.checkEmail(userDto.getEmail())) {
			attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.REGISTER_EMAIL_ERROR);
			return "redirect:/register";
		}
		//检查邮箱是否已经被注册
		if(userService.isEmailExist(userDto.getEmail())) {
			attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.REGISTER_EMAIL_EXIST);
			return "redirect:/register";
		}
		//检查密码是否为空
		if(CommonUtil.isEmpty(userDto.getPassword())){
			attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.PASSWORD_NULL);
			return "redirect:/register";
		}
		//验证码和邮箱的组合，组合是为了验证码和邮箱能够一一对应，否则不知道验证码是不是该邮箱的
		String codeAndEmail = userDto.getCode()+"|"+userDto.getEmail();
		//验证是否与session中的一样
		if(codeAndEmail.equals((String)session.getAttribute("codeAndEmail"))) {
			session.removeAttribute("codeAndEmail");//将之前生成的放在session的验证码邮箱移除
			if(userService.add(userDto)) {//添加用户
				session.setAttribute("user", userDto);//添加成功后session存放用户数据
				return "redirect:/index";//重定向到index
			} else {//添加失败或者验证码错误，错误信息放进session，重定向到注册页面
				attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.REGISTER_FAIL);
				return "redirect:/register";
			}
		} else {
			attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.CHECKCODE_FAIL);
			return "redirect:/register";
		}
		
		
	}

	/**
	 * 发送验证码
	 * @param email
	 * @return PageCodeDto:
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/sendCode",method = RequestMethod.POST)
	public PageCodeDto sendCode(@RequestParam("email") String email){
		//检查邮箱格式
		if(!userService.checkEmail(email)) {
			return new PageCodeDto(PageCodeEnum.REGISTER_EMAIL_ERROR);
		}
		//检查邮箱是否存在
		if(userService.isEmailExist(email)) {
			return new PageCodeDto(PageCodeEnum.REGISTER_EMAIL_EXIST);
		}
		//发送验证码
		if(userService.sendCodeByEmail(email)) {
			return new PageCodeDto(PageCodeEnum.REGISTER_SENDCODE_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.REGISTER_SENDCODE_FAIL);
		}
		
		
	}

	
}
