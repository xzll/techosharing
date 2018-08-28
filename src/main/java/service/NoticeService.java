package service;

import java.util.List;

import dto.NoticeDto;
import dto.UserDto;

public interface NoticeService {
	public boolean add(NoticeDto noticeDto);
	public NoticeDto getNoticeById(Long id);
	public List<NoticeDto> searchByPage(NoticeDto noticeDto);
	public boolean remove(Long id);
	//”√ªß
	public boolean readNotice();
	public NoticeDto getCurrentNotice();
}
