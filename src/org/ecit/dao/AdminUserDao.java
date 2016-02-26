/**
* <p>Title: AdminUserDao.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015��5��18��
* @version 1.0
*/
package org.ecit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ecit.entity.AdminUser;
import org.ecit.entity.Jindian;
import org.ecit.utils.C3P0Util;
import org.springframework.stereotype.Repository;


@Repository
public class AdminUserDao {
	
	private Connection conn;
	
	public AdminUser select(String username) throws SQLException{
		AdminUser adminUser=new AdminUser();
		conn=C3P0Util.getConnection();
		String sql="select * from tb_admin_user where username = ? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			adminUser.setId(rs.getLong("id"));
			adminUser.setUsername(rs.getString("username"));
			adminUser.setPassword(rs.getString("password"));
		}
		return adminUser;		
	}
	
	public List<AdminUser> selectAll() throws SQLException{
		List<AdminUser> lists=new ArrayList<AdminUser>();
		
		conn=C3P0Util.getConnection();
		String sql="select * from tb_admin_user";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			AdminUser adminUser=new AdminUser();
			adminUser.setId(rs.getLong("id"));
			adminUser.setUsername(rs.getString("username"));
			adminUser.setPassword(rs.getString("password"));
			lists.add(adminUser);
		}
		return lists;
	}
	
	public void insert(AdminUser adminUser) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "insert into tb_admin_user values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setLong(1, adminUser.getId());
		ps.setNull(1,  java.sql.Types.BIGINT);
		ps.setString(2, adminUser.getUsername());
		ps.setString(3, adminUser.getPassword());
		ps.execute();
	}
	
	public void delete(long id) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "delete from tb_admin_user where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
	}
}
