package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	/**
	 * 方法描述：判断一个字符串是否为null或空字符串（被trim后为空字符串的也算）。
	 * 
	 * @param str
	 *            需要判断的字符串
	 * @return false：不是空字符串，true：是空字符串
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
