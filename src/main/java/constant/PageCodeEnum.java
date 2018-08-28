package constant;

public enum PageCodeEnum {
	
	REGISTER_FAIL(1000,"注册失败！邮箱已被注册！"),
	REGISTER_USERNAME_EXIST(1001,"昵称已存在！"),
	REGISTER_EMAIL_EXIST(1002,"邮箱已被注册！"),
	CHECKCODE_FAIL(1003,"验证码错误！"),
	REGISTER_SUCCESS(1004,"注册成功！"),
	REGISTER_EMAIL_ERROR(1005,"邮箱格式错误！"),
	REGISTER_SENDCODE_SUCCESS(1006,"验证码已发送，请去邮箱查看"),
	REGISTER_SENDCODE_FAIL(1007,"验证码发送失败"),
	
	LOGIN_FAIL(1100,"登录失败！用户名或密码错误！"),
	SESSION_TIMEOUT(1101,"请先登录！"),
	
	THUMPUP_SUCCESS(1200,"点赞成功"),
	THUMPUP_FAIL(1201,"点赞失败"),
	
	COLLECTION_SUCCESS(1300,"收藏成功"),
	COLLECTION_FAIL(1301,"收藏失败"),
	
	MATERIAL_SUCCESS(1400,"素材添加成功"),
	MATERIAL_FAIL(1401,"素材添加失败"),
	
	TECHO_ADD_SUCCESS(1500,"发布成功"),
	TECHO_ADD_FAIL(1501,"发布失败"),
	
	DEL_SUCCESS(1600,"删除成功"),
	DEL_FAIL(1601,"删除失败"),
	
	FAN_ADD_SUCCESS(1700,"关注成功"),
	FAN_ADD_FAIL(1701,"关注失败"),
	
	UPDATE_SUCCESS(1800,"修改成功"),
	UPDATE_FAIL(1801,"修改失败"),
	
	NOTICE_TECHO(2100,"通知：有新的手帐"),
	NOTICE_COMMENT(2101,"通知：收到评论"),
	NOTICE_THUMPUP(2102,"通知：收到赞"),
	NOTICE_COLLECTION(2103,"通知：手帐被收藏了"),
	NOTICE_FOLLOW(2104,"通知：有人关注了你"),
	
	PASSWORD_NULL(2000,"密码为空"), 
	SUCCESS(2001,"成功"), 
	FAIL(2002,"失败"),;
    
    private Integer code;
    private String msg;
    
    public static final String KEY = "pageCode";
    
    PageCodeEnum(Integer code,String msg) {
	this.code = code;
	this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
