package service;

import java.util.List;

import dto.ThumbupDto;

public interface ThumbupService {
	/**
	 * 点赞
	 * 并通知被点赞的用户
	 * @return true 成功 false 失败
	 */
	public boolean thumbup(ThumbupDto thumbupDto);
	/**
	 * 通知：谁赞了我
	 * @param thumbup uid，techo.content
	 * @return
	 */
	public List<ThumbupDto> searchBeThumbupByPage(ThumbupDto thumbupDto);
	/**
	 * 我赞了谁
	 * @param thumbup uid，techo.content
	 * @return
	 */
	public List<ThumbupDto> searchMyThumbupByPage(ThumbupDto thumbupDto);
	
	public boolean delNotice(ThumbupDto thumbupDto);
	public boolean del(ThumbupDto thumbupDto);
	
	
}
