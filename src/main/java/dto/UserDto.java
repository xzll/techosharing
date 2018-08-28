package dto;

import org.springframework.web.multipart.MultipartFile;

import bean.User;

public class UserDto extends User{
	String code;
	private Long fanSum;
	private Long followerSum;
	private Long techoSum;
	private MultipartFile headimgfile;
	private String headimgurl;
	private Boolean isSign;
	public Boolean getIsSign() {
		return isSign;
	}
	public void setIsSign(Boolean isSign) {
		this.isSign = isSign;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public MultipartFile getHeadimgfile() {
		return headimgfile;
	}
	public void setHeadimgfile(MultipartFile headimgfile) {
		this.headimgfile = headimgfile;
	}
	public Long getFanSum() {
		return fanSum;
	}

	public void setFanSum(Long fanSum) {
		this.fanSum = fanSum;
	}

	public Long getFollowerSum() {
		return followerSum;
	}

	public void setFollowerSum(Long followerSum) {
		this.followerSum = followerSum;
	}

	public Long getTechoSum() {
		return techoSum;
	}

	public void setTechoSum(Long techoSum) {
		this.techoSum = techoSum;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
