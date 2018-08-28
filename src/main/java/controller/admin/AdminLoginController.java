package controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.PageCodeEnum;
import dto.AdminDto;
import service.AdminService;

@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private HttpSession session;
	@RequestMapping
	public String index() {
		return "/admin/login";
	}
	@RequestMapping("/validate")
	public String validate(AdminDto adminDto,RedirectAttributes attr) {
		if(adminService.validate(adminDto)) {
			session.setAttribute("admin", adminDto);
			System.out.println("µÇÂ¼");
			return "redirect:/admin/techo";
		}
		attr.addFlashAttribute("adminDto",adminDto);
		attr.addFlashAttribute(PageCodeEnum.KEY, PageCodeEnum.LOGIN_FAIL);
		return "redirect:/admin/login";
	}
}
