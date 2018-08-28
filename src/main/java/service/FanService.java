package service;

import java.util.List;

import dto.FanDto;

public interface FanService {
    /**
     * ������˿
     * @param fanDto
     * @return �Ƿ������ɹ���true-�ɹ�;fale-ʧ��
     */
	public boolean add(FanDto fanDto);
	/**
	 * ���ҷ�˿
	 * @param fanDto uid,username
	 * @return 
	 */
	public List<FanDto> searchFanByPage(FanDto fanDto); 
	/**
	 * ���ҹ�ע��
	 * @param fanDto fanid,username
	 * @return
	 */
	public List<FanDto> searchFollowerByPage(FanDto fanDto);
	/**
	 * ֪ͨ�б�
	 * @param fanDto uid,username
	 * @return
	 */
	public List<FanDto> searchNoticeByPage(FanDto fanDto);
	/**
	 * ɾ��֪ͨ
	 * @param fanDto uid��tid
	 * @return
	 */
	public boolean deleteNotice(FanDto fanDto);
	/**
	 * ȡ����ע
	 * @param fanDto uid,tid
	 * @return
	 */
	public boolean delete(FanDto fanDto);
}
