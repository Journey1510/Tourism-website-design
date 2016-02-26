/**
* <p>Title: XinwenDao.java</p>
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
import org.ecit.entity.Xianlu;
import org.ecit.entity.Xinwen;
import org.ecit.utils.C3P0Util;
import org.springframework.stereotype.Repository;

/**
 * <p>Title: XinwenDao</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
@Repository
public class XinwenDao {
	private Connection conn;

	public Xinwen select(Long id) throws SQLException {
		Xinwen xinwen = new Xinwen();
		conn = C3P0Util.getConnection();
		String sql = "select * from tb_xinwen where id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			xinwen.setId(rs.getLong("id"));
			xinwen.setImgurl(rs.getString("imgurl"));
			xinwen.setName(rs.getString("name"));
			xinwen.setText(rs.getString("text"));
		}
		return xinwen;
	}
	
	public List<Xinwen> select(Xinwen xinwen) throws SQLException{
		
		List<Xinwen> lists=new ArrayList<Xinwen>();
		conn=C3P0Util.getConnection();
		StringBuffer sqlbuf=new StringBuffer("select * from tb_xinwen ");
		
		if(xinwen.getId()!=null){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("id = ").append(xinwen.getId()).append("");
			}else{
				sqlbuf.append(" where ").append("id = ").append(xinwen.getId()).append("");
			}
		}
		
		if(!StringUtils.isBlank(xinwen.getImgurl())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("imgurl = '").append(xinwen.getImgurl()).append("'");
			}else{
				sqlbuf.append(" where ").append("imgurl = '").append(xinwen.getImgurl()).append("'");
			}
		}
		
		if(!StringUtils.isBlank(xinwen.getName())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("name like '%").append(xinwen.getName()).append("%'");
			}else{
				sqlbuf.append(" where ").append("name like '%").append(xinwen.getName()).append("%'");
			}
		}
		if(!StringUtils.isBlank(xinwen.getText())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("text like '%").append(xinwen.getText()).append("%'");
			}else{
				sqlbuf.append(" where ").append("text like '%").append(xinwen.getText()).append("%'");
			}
		}
		
		PreparedStatement ps=conn.prepareStatement(sqlbuf.toString());
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Xinwen xinwentmp=new Xinwen();
			xinwentmp.setId(rs.getLong("id"));
			xinwentmp.setImgurl(rs.getString("imgurl"));
			xinwentmp.setName(rs.getString("name"));
			xinwentmp.setText(rs.getString("text"));
			lists.add(xinwentmp);
		}
		return lists;	
	}



	public List<Xinwen> selectAll() throws SQLException {
		List<Xinwen> lists = new ArrayList<Xinwen>();
		conn = C3P0Util.getConnection();
		String sql = "select * from tb_xinwen ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Xinwen xinwen = new Xinwen();
			xinwen.setId(rs.getLong("id"));
			xinwen.setImgurl(rs.getString("imgurl"));
			xinwen.setName(rs.getString("name"));
			xinwen.setText(rs.getString("text"));
			lists.add(xinwen);
		}
		return lists;
	}
	
	public void insert(Xinwen xinwen) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "insert into tb_xinwen values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setLong(1, xinwen.getId());
		ps.setNull(1,  java.sql.Types.BIGINT);
		ps.setString(2, xinwen.getImgurl());
		ps.setString(3, xinwen.getName());
		ps.setString(4, xinwen.getText());
		ps.execute();
	}
	
	
	public void delete(long id) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "delete from tb_xinwen where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
	}

	/**
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param xinwen
	 * @throws SQLException 
	*/
	public void update(Xinwen xinwen) throws SQLException {
		conn = C3P0Util.getConnection();
		String sql="update tb_xinwen set imgurl=?,name=?,text=? where id=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, xinwen.getImgurl());
		ps.setString(2, xinwen.getName());
		ps.setString(3, xinwen.getText());
		ps.setLong(4, xinwen.getId());
		ps.execute();		
	}
}
