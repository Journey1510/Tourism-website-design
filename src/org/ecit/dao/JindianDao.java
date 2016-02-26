/**
* <p>Title: JindianDao.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月18日
* @version 1.0
*/
package org.ecit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.ecit.entity.Jindian;
import org.ecit.utils.C3P0Util;
import org.springframework.stereotype.Repository;

/**
 * <p>Title: JindianDao</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
@Repository
public class JindianDao {
	private Connection conn;
	
	public Jindian select(Long id) throws SQLException{
		Jindian jindian=new Jindian();
		conn=C3P0Util.getConnection();
		String sql="select * from tb_jindian where id = ? ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			jindian.setId(rs.getLong("id"));
			jindian.setImgurl(rs.getString("imgurl"));
			jindian.setName(rs.getString("name"));
			jindian.setText(rs.getString("text"));
		}
		return jindian;	
	}
	
	public List<Jindian> select(Jindian jindian) throws SQLException{
		
		List<Jindian> lists=new ArrayList<Jindian>();
		conn=C3P0Util.getConnection();
		StringBuffer sqlbuf=new StringBuffer("select * from tb_jindian ");
		
		if(jindian.getId()!=null){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("id = ").append(jindian.getId()).append("");
			}else{
				sqlbuf.append(" where ").append("id = ").append(jindian.getId()).append("");
			}
		}
		
		if(!StringUtils.isBlank(jindian.getImgurl())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("imgurl = '").append(jindian.getImgurl()).append("'");
			}else{
				sqlbuf.append(" where ").append("imgurl = '").append(jindian.getImgurl()).append("'");
			}
		}
		
		if(!StringUtils.isBlank(jindian.getName())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("name like '%").append(jindian.getName()).append("%'");
			}else{
				sqlbuf.append(" where ").append("name like '%").append(jindian.getName()).append("%'");
			}
		}
		if(!StringUtils.isBlank(jindian.getText())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("text like '%").append(jindian.getText()).append("%'");
			}else{
				sqlbuf.append(" where ").append("text like '%").append(jindian.getText()).append("%'");
			}
		}
		
		PreparedStatement ps=conn.prepareStatement(sqlbuf.toString());
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Jindian jindiantmp=new Jindian();
			jindiantmp.setId(rs.getLong("id"));
			jindiantmp.setImgurl(rs.getString("imgurl"));
			jindiantmp.setName(rs.getString("name"));
			jindiantmp.setText(rs.getString("text"));
			lists.add(jindiantmp);
		}
		return lists;	
	}
	
	public List<Jindian> selectAll() throws SQLException{
		List<Jindian> lists=new ArrayList<Jindian>();
		conn=C3P0Util.getConnection();
		String sql="select * from tb_jindian ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Jindian jindian=new Jindian();
			jindian.setId(rs.getLong("id"));
			jindian.setImgurl(rs.getString("imgurl"));
			jindian.setName(rs.getString("name"));
			jindian.setText(rs.getString("text"));
			lists.add(jindian);
		}
		return lists;	
	}
	
	
	public void insert(Jindian jindian) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "insert into tb_jindian values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setLong(1, jindian.getId());
		ps.setNull(1,  java.sql.Types.BIGINT);
		ps.setString(2, jindian.getImgurl());
		ps.setString(3, jindian.getName());
		ps.setString(4, jindian.getText());
		ps.execute();
	}
	
	public void update(Jindian jindian) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql="update tb_jindian set imgurl=?,name=?,text=? where id=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, jindian.getImgurl());
		ps.setString(2, jindian.getName());
		ps.setString(3, jindian.getText());
		ps.setLong(4, jindian.getId());
		ps.execute();
	}
	
	
	
	public void delete(long id) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "delete from tb_jindian where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
	}
	
	
}
