/**
* <p>Title: AdminUserService.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015��5��18��
* @version 1.0
*/
package org.ecit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ecit.dao.AdminUserDao;
import org.ecit.entity.AdminUser;
import org.ecit.entity.Jindian;
import org.ecit.exception.PasswordException;
import org.ecit.exception.UserNameException;
import org.ecit.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminUserService {
	@Autowired
	private AdminUserDao adminUserDao;
	
	public boolean login(String username,String password) throws SQLException, UserNameException, PasswordException{
		
		if(StringUtils.isBlank(username)){
			throw new UserNameException("username is null");
		}
		if(StringUtils.isBlank(password)){
			throw new PasswordException("password is null");
		}
		AdminUser adminUser=adminUserDao.select(username);
		//MD5 md5=new MD5();
		if(adminUser!=null&& password.equals(adminUser.getPassword())){
			return true;
		}
		return false;
	}
	
	public List<AdminUser> SelectAll() throws SQLException{
		return adminUserDao.selectAll();
	}
	
	public void insert(AdminUser adminUser) throws SQLException{
		adminUserDao.insert(adminUser);
	}
	
	
	public void delete(long id) throws SQLException{
		adminUserDao.delete(id);
	}
}
