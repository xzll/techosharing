package service;

import java.util.List;

import dto.ThumbupDto;

public interface ThumbupService {
	/**
	 * ����
	 * ��֪ͨ�����޵��û�
	 * @return true �ɹ� false ʧ��
	 */
	public boolean thumbup(ThumbupDto thumbupDto);
	/**
	 * ֪ͨ��˭������
	 * @param thumbup uid��techo.content
	 * @return
	 */
	public List<ThumbupDto> searchBeThumbupByPage(ThumbupDto thumbupDto);
	/**
	 * ������˭
	 * @param thumbup uid��techo.content
	 * @return
	 */
	public List<ThumbupDto> searchMyThumbupByPage(ThumbupDto thumbupDto);
	
	public boolean delNotice(ThumbupDto thumbupDto);
	public boolean del(ThumbupDto thumbupDto);
	
	
}
