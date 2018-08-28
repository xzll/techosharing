package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	/**
	 * �����������ж�һ���ַ����Ƿ�Ϊnull����ַ�������trim��Ϊ���ַ�����Ҳ�㣩��
	 * 
	 * @param str
	 *            ��Ҫ�жϵ��ַ���
	 * @return false�����ǿ��ַ�����true���ǿ��ַ���
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	public static boolean delFile(String path){
		File file = new File(path);
		if(file.exists()){
			return file.delete();
		}
		return false;
	}
}
