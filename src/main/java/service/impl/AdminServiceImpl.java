package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminDao;
import dto.AdminDto;
import service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Override
	public boolean validate(AdminDto adminDto) {
		return adminDao.select(adminDto)!=null;
	}

}
