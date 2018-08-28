package service;

import java.util.List;

import bean.NoticeTecho;
import bean.Techo;
import dto.TechoDto;

public interface TechoService {
    /**
     * �������ʷ���
     * @param techoDto
     * @return �Ƿ������ɹ���true-�ɹ�;fale-ʧ��
     */
    public boolean add(TechoDto techoDto);
    /**
     * ��ҳ���������б�
     * @param businessDto ��ѯ����(������ҳ����)
     * @return �̻��б�
     */
    public List<TechoDto> searchByPage(TechoDto techoDto);
    
    public TechoDto searchById( Long id);
    
    public String[] imgNameToUrl(Techo techo);
    
    public boolean deleteNotice(NoticeTecho noticeTecho);
    
    public boolean delete(Long id,boolean delImg);
    /**
     * �������Ƿ��ǵ�¼���û���
     * @return
     */
    public boolean isUserTecho(Long id);
	String[] imgNameToPath(Techo techo); 
    
}
