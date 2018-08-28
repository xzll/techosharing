package dto;

import org.springframework.web.multipart.MultipartFile;

import bean.Material;

public class MaterialDto extends Material{
	private MultipartFile imgFile;
	private String imgurl;
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
}
