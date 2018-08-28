package dto;

import bean.Comment;

public class CommentDto extends Comment{
	private TechoDto techoDto;

	public TechoDto getTechoDto() {
		return techoDto;
	}

	public void setTechoDto(TechoDto techoDto) {
		this.techoDto = techoDto;
	}
	
}
