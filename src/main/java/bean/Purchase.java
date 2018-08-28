package bean;

public class Purchase extends BaseBean{
	private Long uid;
	private Long mid;
	private String content;
	private String createtime;
	private String username;
	private Material material;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
}
