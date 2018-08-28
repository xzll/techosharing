package service;


import java.util.List;

import bean.User;
import dto.UserDto;

public interface UserService {
	/**
	 * 添加用户
	 * @param userDto 
	 * @return ture false 
	 */
	public boolean add(UserDto userDto);
	/**
	 * 登录验证
	 * @param userDto 
	 * @return true 
	 * 			false 
	 */
	public boolean validate(UserDto userDto);
	
	/**
	 * 用户名是否存在
	 * @param userDto
	 * @return
	 */
	public boolean isUsernameExist(UserDto userDto);
	/**
	 * 邮箱是否已被注册
	 * @param userDto
	 * @return
	 */
	public boolean isEmailExist(String email);
	/**
	 * 检查邮箱格式
	 * @param email
	 * @return true false
	 */
	public boolean checkEmail(String email);
	
	/**
	 * 发送验证码
	 * @param email
	 * @return
	 */
	public boolean sendCodeByEmail(String email);
	/**
	 * 用户签到
	 * @param id
	 * @return 
	 */
	public User signIn();
	/**
	 * 当前用户更新信息
	 * @param user
	 * @return
	 */
	public User update(User user);
	/**
	 * 当前用户更新用户信息？
	 * @param userDto
	 * @return
	 */
	public User updateInfo(UserDto userDto);
	/**
	 * 根据id获得用户信息？
	 * @param user
	 * @return
	 */
	public UserDto showInfo(User user);
	/**
	 * 上传头像
	 * @param userDto
	 * @return
	 */
	public Boolean loadHeadImg(UserDto userDto);
	/**
	 * 退出登录
	 * @return
	 */
	public boolean logout();
	/**
	 * 用户列表
	 * @param userDto
	 * @return
	 */
	public List<UserDto> searchByPage(UserDto userDto);
	/**
	 * 直接修改用户
	 * @param userDto
	 * @return
	 */
	public boolean modify(UserDto userDto);
	/**
	 * 获得用户信息
	 * @param id
	 * @return
	 */
	public UserDto getById(Long id);
	/**
	 * 添加用户？
	 * @param userDto
	 * @return
	 */
	public boolean addUser(UserDto userDto);
	/**
	 * 删除用户？
	 * @param id
	 * @return
	 */
	public boolean remove(Long id);

}
