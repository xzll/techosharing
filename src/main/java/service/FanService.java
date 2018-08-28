package service;

import java.util.List;

import dto.FanDto;

public interface FanService {
    /**
     * 新增粉丝
     * @param fanDto
     * @return 是否新增成功：true-成功;fale-失败
     */
	public boolean add(FanDto fanDto);
	/**
	 * 查找粉丝
	 * @param fanDto uid,username
	 * @return 
	 */
	public List<FanDto> searchFanByPage(FanDto fanDto); 
	/**
	 * 查找关注者
	 * @param fanDto fanid,username
	 * @return
	 */
	public List<FanDto> searchFollowerByPage(FanDto fanDto);
	/**
	 * 通知列表
	 * @param fanDto uid,username
	 * @return
	 */
	public List<FanDto> searchNoticeByPage(FanDto fanDto);
	/**
	 * 删除通知
	 * @param fanDto uid，tid
	 * @return
	 */
	public boolean deleteNotice(FanDto fanDto);
	/**
	 * 取消关注
	 * @param fanDto uid,tid
	 * @return
	 */
	public boolean delete(FanDto fanDto);
}
