package bean;

public class User extends BaseBean{
	private Long id;
	private String username;
	private String password;
	private String email;
	private String createtime; 
	private Long coin;
	private Long signin;
	private String content;
	private String city;
	private Boolean sex;
	private String headimgname;
	private String signdate;
	private Boolean read;
	private String contact;
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public String getSigndate() {
		return signdate;
	}
	public void setSigndate(String signdate) {
		this.signdate = signdate;
	}
	public String getHeadimgname() {
		return headimgname;
	}
	public void setHeadimgname(String headimgname) {
		this.headimgname = headimgname;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getSignin() {
		return signin;
	}
	public void setSignin(Long signin) {
		this.signin = signin;
	}
	public Long getCoin() {
		return coin;
	}
	public void setCoin(Long coin) {
		this.coin = coin;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
