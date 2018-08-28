package controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constant.PageCodeEnum;
import dto.TechoDto;
import service.TechoService;

@Controller
@RequestMapping("/admin/techo")
public class AdminTechoController {

	@Autowired
	private TechoService techoService;

	/**
	 * ���ʹ���ҳ��ʼ��(�����ʹ���˵�����ĵ�һ��ҳ��)
	 */
	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		TechoDto techoDto = new TechoDto();
		model.addAttribute("list", techoService.searchByPage(techoDto));
		model.addAttribute("searchParam", techoDto);
		return "/techoList";
	}

	/**
	 * ��ѯ
	 */
	@RequestMapping("/search")
	public String search(Model model, TechoDto TechoDto) {
		model.addAttribute("list", techoService.searchByPage(TechoDto));
		model.addAttribute("searchParam", TechoDto);
		return "/techoList";
	}

	/**
	 * ɾ��
	 */
	@RequestMapping("/remove")
	public String remove(@RequestParam("id") Long id,Model model) {
		try {
			if(techoService.delete(id,true)) {
				model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_SUCCESS);
			} else {
				model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_FAIL);
			}
		} catch (Exception e) {
			model.addAttribute(PageCodeEnum.KEY, PageCodeEnum.DEL_FAIL);
			e.printStackTrace();
		}
		return "forward:/admin/techo";
	}


}
