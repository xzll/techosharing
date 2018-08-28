package bean;

public class Thumbup extends BaseBean{
	private Long uid;
	private Long tid;
	private Boolean read;
	private String createtime;
	private Techo techo;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Techo getTecho() {
		return techo;
	}
	public void setTecho(Techo techo) {
		this.techo = techo;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Boolean getRead() {
		return read;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	
}
