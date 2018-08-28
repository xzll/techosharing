package dao;


import java.util.List;

import bean.Comment;
import bean.Techo;

public interface TechoDao {
    /**
     * ����
     * @param techo ���ʱ����
     * @return Ӱ������
     */
    int insert(Techo techo);
    /**
     * 
     * @param id
     * @return
     */
    Techo selectById(Long id);
    /**
     * ���ݲ�ѯ������ҳ��ѯ�����б�
     * @param techo
     * @return
     */
    List<Techo> selectByPage(Techo techo);
    int delete(Long id);
    
    int deleteAll(Techo techo);
    List<Long> selectIdByUid(Long uid);
}
