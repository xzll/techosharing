package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;
import constant.PageCodeEnum;
import dao.MaterialDao;
import dto.FanDto;
import dto.MaterialDto;
import dto.PageCodeDto;
import service.MaterialService;

@Controller
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public PageCodeDto add( MaterialDto materialDto){
		PageCodeDto pageCodeDto;
		if(materialService.add(materialDto)) {
			pageCodeDto = new PageCodeDto(PageCodeEnum.MATERIAL_SUCCESS);
		} else {
			pageCodeDto = new PageCodeDto(PageCodeEnum.MATERIAL_FAIL);
		}
		return pageCodeDto;
	}
	@ResponseBody
	@RequestMapping("/list")
	public List<MaterialDto> getByPage(@RequestBody MaterialDto materialDto){
		return materialService.getByPage(materialDto);
	}
	@ResponseBody
	@RequestMapping("/update")
	public PageCodeDto update( MaterialDto materialDto){
		PageCodeDto pageCodeDto;
		if(materialService.update(materialDto)) {
			pageCodeDto = new PageCodeDto(PageCodeEnum.UPDATE_SUCCESS);
		} else {
			pageCodeDto = new PageCodeDto(PageCodeEnum.UPDATE_FAIL);
		}
		return pageCodeDto;
	}
	/**
	 * 不是真正删除数据
	 * @param fanDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/del")
	public PageCodeDto del(@RequestBody MaterialDto materialDto){

		if( materialService.delete(materialDto.getId())){
			return new PageCodeDto(PageCodeEnum.DEL_SUCCESS);
		} else {
			return new PageCodeDto(PageCodeEnum.DEL_FAIL);

		
		}
	}
	
}
