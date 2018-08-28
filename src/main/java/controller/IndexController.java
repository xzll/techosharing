package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.User;
import dto.UserDto;
import service.TechoService;
import service.UserService;

@Controller
public class IndexController {
	@Autowired
	private TechoService techoService;
	@Autowired
	private UserService userService;
	@RequestMapping("/index")
	public String index(){
		return "/admin";
	}
/*	@RequestMapping(value="/journalOther/{tid}")
	public String journalOther(@PathVariable(value="tid") String tid,Model model){
		model.addAttribute("tid", tid);
		return "/journalOther";
	}*/
	@RequestMapping(value="/journal/{tid}")
	public String journal(@PathVariable(value="tid") String tid,@RequestParam(value="area",required=false) String area,Model model){
		model.addAttribute("tid", tid);
		model.addAttribute("area", area);
		if(techoService.isUserTecho(Long.valueOf(tid))){
			return "/journal";
		}
		return "/journalOther";
	}
	
	@RequestMapping("/transact")
	public String transact(){
		return "/transact";
	}
	@RequestMapping("/userinfo/{id}")
	public String accountOther(@PathVariable(value="id") String id,Model model){
		User user = new User();
		user.setId(Long.valueOf(id));
		UserDto dto = userService.showInfo(user);
		model.addAttribute("user", dto);
		return "/userinfo";
	}
	@RequestMapping("/adminOther/{id}")
	public String adminOther(@PathVariable(value="id") String id,Model model){
		model.addAttribute("hid", id);
		return "/adminOther";
	}
}
