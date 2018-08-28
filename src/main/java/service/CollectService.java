package service;

import java.util.List;

import dto.CollectDto;

public interface CollectService {

	/**
	 * ����ղصļ�¼����֪ͨ����
	 * @param collectDto
	 * @return true �ɹ� false ʧ��
	 */
	public boolean add(CollectDto collectDto);
	/**
	 * �û��ղ��б�
	 * @param collect uid,techo.content ��������
	 * @return
	 */
	public List<CollectDto> searchByUidByPage(CollectDto collectDto);
	/**
	 * �û����ʱ��ղص�֪ͨ�б�
	 * @param collect uid ,techo.content ��������
	 * @return
	 */
	public List<CollectDto> searchBeCollectByPage(CollectDto collectDto);
	/**
	 * ɾ���ղ�֪ͨ
	 * ����del��1��������������ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteReceive(CollectDto collectDto);
	/**
	 * ɾ���Լ����ղ�
	 * �����Ĵ����ݿ���ɾ��
	 * @param id
	 * @return
	 */
	public boolean delete(CollectDto collectDto);
}
