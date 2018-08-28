package service;

import java.util.List;

import bean.NoticeTecho;
import bean.Techo;
import dto.TechoDto;

public interface TechoService {
    /**
     * 新增手帐分享
     * @param techoDto
     * @return 是否新增成功：true-成功;fale-失败
     */
    public boolean add(TechoDto techoDto);
    /**
     * 分页搜索手帐列表
     * @param businessDto 查询条件(包含分页对象)
     * @return 商户列表
     */
    public List<TechoDto> searchByPage(TechoDto techoDto);
    
    public TechoDto searchById( Long id);
    
    public String[] imgNameToUrl(Techo techo);
    
    public boolean deleteNotice(NoticeTecho noticeTecho);
    
    public boolean delete(Long id,boolean delImg);
    /**
     * 该手帐是否是登录的用户的
     * @return
     */
    public boolean isUserTecho(Long id);
	String[] imgNameToPath(Techo techo); 
    
}
