package dao;


import java.util.List;

import bean.Comment;
import bean.Techo;

public interface TechoDao {
    /**
     * 新增
     * @param techo 手帐表对象
     * @return 影响行数
     */
    int insert(Techo techo);
    /**
     * 
     * @param id
     * @return
     */
    Techo selectById(Long id);
    /**
     * 根据查询条件分页查询手帐列表
     * @param techo
     * @return
     */
    List<Techo> selectByPage(Techo techo);
    int delete(Long id);
    
    int deleteAll(Techo techo);
    List<Long> selectIdByUid(Long uid);
}
