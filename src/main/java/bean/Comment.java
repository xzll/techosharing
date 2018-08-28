package bean;

public class Comment extends BaseBean{
	private Long id;
	private Long tid;
	private Long uid;
	private String content;
	private String createtime;
	private Boolean read;
	private String username;
	private Techo techo;
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
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
 }
