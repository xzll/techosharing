package dao;

import java.util.List;

import bean.Notice;

public interface NoticeDao {
	public int insert(Notice notice);
	public Notice selectById(Long id);
	public List<Notice> selectByPage(Notice notice);
	public int delete(Long id);
	public Notice selectCurrent();
}
