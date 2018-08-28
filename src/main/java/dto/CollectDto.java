package dto;

import bean.Collect;

public class CollectDto extends Collect{
	private TechoDto techoDto;

	public TechoDto getTechoDto() {
		return techoDto;
	}

	public void setTechoDto(TechoDto techoDto) {
		this.techoDto = techoDto;
	}
	
}
