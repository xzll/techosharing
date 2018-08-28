package bean;

public class Fan extends BaseBean{
	private Long uid;
	private Long fanid;
	private String createtime;
	private Boolean read;
	private String username;
	private Techo techo;
	private String headimgname;
	public String getHeadimgname() {
		return headimgname;
	}
	public void setHeadimgname(String headimgname) {
		this.headimgname = headimgname;
	}
	public String getUsername() {
		return username;
	}
	public Techo getTecho() {
		return techo;
	}
	public void setTecho(Techo techo) {
		this.techo = techo;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getFanid() {
		return fanid;
	}
	public void setFanid(Long fanid) {
		this.fanid = fanid;
	}
}
