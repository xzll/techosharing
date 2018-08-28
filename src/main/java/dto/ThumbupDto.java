package dto;

import bean.Thumbup;

public class ThumbupDto extends Thumbup{
	private TechoDto techoDto;

	public TechoDto getTechoDto() {
		return techoDto;
	}

	public void setTechoDto(TechoDto techoDto) {
		this.techoDto = techoDto;
	}
	
}
