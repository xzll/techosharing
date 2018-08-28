package dto;

import bean.Purchase;

public class PurchaseDto extends Purchase{
	private MaterialDto materialDto;

	public MaterialDto getMaterialDto() {
		return materialDto;
	}

	public void setMaterialDto(MaterialDto materialDto) {
		this.materialDto = materialDto;
	}
}
