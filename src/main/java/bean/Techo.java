package bean;

public class Techo extends BaseBean{
	private Long id;
	private Long uid;
	private String title;
	private String createtime;
	private String content;
	private String imgnames;
	private String username;
	private String headimgname;
	private Long noticeTechoUid;
	public String getHeadimgname() {
		return headimgname;
	}
	public void setHeadimgname(String headimgname) {
		this.headimgname = headimgname;
	}
	public Long getNoticeTechoUid() {
		return noticeTechoUid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setNoticeTechoUid(Long noticeTechoUid) {
		this.noticeTechoUid = noticeTechoUid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgnames() {
		return imgnames;
	}
	public void setImgnames(String imgnames) {
		this.imgnames = imgnames;
	}
	

}
