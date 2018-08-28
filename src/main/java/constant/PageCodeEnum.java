package constant;

public enum PageCodeEnum {
	
	REGISTER_FAIL(1000,"ע��ʧ�ܣ������ѱ�ע�ᣡ"),
	REGISTER_USERNAME_EXIST(1001,"�ǳ��Ѵ��ڣ�"),
	REGISTER_EMAIL_EXIST(1002,"�����ѱ�ע�ᣡ"),
	CHECKCODE_FAIL(1003,"��֤�����"),
	REGISTER_SUCCESS(1004,"ע��ɹ���"),
	REGISTER_EMAIL_ERROR(1005,"�����ʽ����"),
	REGISTER_SENDCODE_SUCCESS(1006,"��֤���ѷ��ͣ���ȥ����鿴"),
	REGISTER_SENDCODE_FAIL(1007,"��֤�뷢��ʧ��"),
	
	LOGIN_FAIL(1100,"��¼ʧ�ܣ��û������������"),
	SESSION_TIMEOUT(1101,"���ȵ�¼��"),
	
	THUMPUP_SUCCESS(1200,"���޳ɹ�"),
	THUMPUP_FAIL(1201,"����ʧ��"),
	
	COLLECTION_SUCCESS(1300,"�ղسɹ�"),
	COLLECTION_FAIL(1301,"�ղ�ʧ��"),
	
	MATERIAL_SUCCESS(1400,"�ز���ӳɹ�"),
	MATERIAL_FAIL(1401,"�ز����ʧ��"),
	
	TECHO_ADD_SUCCESS(1500,"�����ɹ�"),
	TECHO_ADD_FAIL(1501,"����ʧ��"),
	
	DEL_SUCCESS(1600,"ɾ���ɹ�"),
	DEL_FAIL(1601,"ɾ��ʧ��"),
	
	FAN_ADD_SUCCESS(1700,"��ע�ɹ�"),
	FAN_ADD_FAIL(1701,"��עʧ��"),
	
	UPDATE_SUCCESS(1800,"�޸ĳɹ�"),
	UPDATE_FAIL(1801,"�޸�ʧ��"),
	
	NOTICE_TECHO(2100,"֪ͨ�����µ�����"),
	NOTICE_COMMENT(2101,"֪ͨ���յ�����"),
	NOTICE_THUMPUP(2102,"֪ͨ���յ���"),
	NOTICE_COLLECTION(2103,"֪ͨ�����ʱ��ղ���"),
	NOTICE_FOLLOW(2104,"֪ͨ�����˹�ע����"),
	
	PASSWORD_NULL(2000,"����Ϊ��"), 
	SUCCESS(2001,"�ɹ�"), 
	FAIL(2002,"ʧ��"),;
    
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
