package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.PageCodeEnum;
import dto.UserDto;
import service.UserService;
import utils.CommonUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	
	/**
	 * ��¼ҳ��
	 * @return
	 */
	@RequestMapping
	public String index() {
		System.out.println(session.getServletContext().getRealPath("/"));
		return "/index";
	}
	
	/**
	 * ��֤�û��������Ƿ���ȷ����֤ͨ����ת����ҳ����֤ʧ�ܣ����ص�¼ҳ
	 * @param userDto
	 * @param attr
	 * @return
	 */
	@RequestMapping("/validate")
	public String validate(UserDto userDto,RedirectAttributes attr) {
		if(!CommonUtil.isEmpty(userDto.getEmail())&&!CommonUtil.isEmpty(userDto.getPassword())){
			
			if(userService.validate(userDto)) {
				session.setAttribute("user", userDto);
				return "redirect:/index";
			}
		}
		attr.addFlashAttribute("userDto",userDto);
		attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.LOGIN_FAIL);
		return "redirect:/login";
	}
	
/*	@RequestMapping("/noAuth")
	public String noAuth(RedirectAttributes attr) {
		attr.addFlashAttribute("loginFail", "û��Ȩ�޷��ʣ����ȵ�¼��");
		session.invalidate();
		return "redirect:/login";
		
		
	}*/
	
	/**
	 * session��ʱ
	 * @param attr
	 * @return
	 */
	@RequestMapping("/sessionTimeout")
	public String sessionTimeout(RedirectAttributes attr) {
		attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.SESSION_TIMEOUT);
		return "redirect:/login";
	}
}
