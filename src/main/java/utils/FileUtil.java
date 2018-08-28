package utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	/**
	 * ��MultipartFile���浽ָ����·����
	 * 
	 * @param file
	 *            Spring��MultipartFile����
	 * @param savePath
	 *            ����·��
	 * @return ������ļ�����������NULLʱΪ����ʧ�ܡ�
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static String save(MultipartFile file, String savePath) throws IllegalStateException, IOException {
		if (file != null && file.getSize() > 0) {
			File fileFolder = new File(savePath);
			if (!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			File saveFile = getFile(savePath, file.getOriginalFilename());
			file.transferTo(saveFile);
			return saveFile.getName();
		}
		return null;
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @return �Ƿ�ɾ���ɹ���true-ɾ���ɹ���false-ɾ��ʧ��
	 */
	public static boolean delete(String filePath) {
		File file = new File(filePath);
		if (file.isFile()) {
			file.delete();
			return true;
		}
		return false;
	}

	private static File getFile(String savePath, String originalFilename) {
		String fileName = System.currentTimeMillis() + "_" + originalFilename;
		File file = new File(savePath + fileName);
		if (file.exists()) {
			return getFile(savePath, originalFilename);
		}
		return file;
	}
}
