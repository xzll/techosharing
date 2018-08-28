package dto;

import org.springframework.web.multipart.MultipartFile;

import bean.Techo;

public class TechoDto extends Techo{
	private String[] imgsurl;
	private MultipartFile[] imgFiles;
	private Long commentNum;
	private Long thumbupNum;
	private Long collectionNum;
	private UserDto userDto;

	public Long getCommentNum() {
		return commentNum;
	}

	public String[] getImgsurl() {
		return imgsurl;
	}

	public void setImgsurl(String[] imgsurl) {
		this.imgsurl = imgsurl;
	}

	public void setCommentNum(Long commentNum) {
		this.commentNum = commentNum;
	}

	public Long getThumbupNum() {
		return thumbupNum;
	}

	public void setThumbupNum(Long thumbupNum) {
		this.thumbupNum = thumbupNum;
	}

	public Long getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(Long collectionNum) {
		this.collectionNum = collectionNum;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public MultipartFile[] getImgFiles() {
		return imgFiles;
	}

	public void setImgFiles(MultipartFile[] imgFiles) {
		this.imgFiles = imgFiles;
	}

	
}
