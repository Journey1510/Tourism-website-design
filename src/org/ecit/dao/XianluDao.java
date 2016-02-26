/**
 * <p>Title: XianluDao.java</p>
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
import org.ecit.entity.Xianlu;
import org.ecit.utils.C3P0Util;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Title: XianluDao
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: LTGames
 * </p>
 * 
 * @author xulei
 * @date 2015年5月18日
 */
@Repository
public class XianluDao {
	private Connection conn;

	public Xianlu select(Long id) throws SQLException {
		Xianlu xianlu = new Xianlu();
		conn = C3P0Util.getConnection();
		String sql = "select * from tb_xianlu where id = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			xianlu.setId(rs.getLong("id"));
			xianlu.setImgurl(rs.getString("imgurl"));
			xianlu.setName(rs.getString("name"));
			xianlu.setText(rs.getString("text"));
		}
		return xianlu;
	}
	
	public List<Xianlu> select(Xianlu xianlu) throws SQLException{
		
		List<Xianlu> lists=new ArrayList<Xianlu>();
		conn=C3P0Util.getConnection();
		StringBuffer sqlbuf=new StringBuffer("select * from tb_xianlu ");
		
		if(xianlu.getId()!=null){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append(" id=").append(xianlu.getId());
			}else{
				sqlbuf.append(" where ").append(" id=").append(xianlu.getId());
			}
		}
		
		if(!StringUtils.isBlank(xianlu.getImgurl())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append(" imgurl=").append(xianlu.getImgurl());
			}else{
				sqlbuf.append(" where ").append("imgurl = '").append(xianlu.getImgurl()).append("'");
			}
		}
		
		if(!StringUtils.isBlank(xianlu.getName())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append(" name=").append(xianlu.getName());
			}else{
				sqlbuf.append(" where ").append("name like '%").append(xianlu.getName()).append("%'");
			}
		}
		if(!StringUtils.isBlank(xianlu.getText())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append(" text=").append(xianlu.getText());
			}else{
				sqlbuf.append(" where ").append("text like '%").append(xianlu.getText()).append("%'");
			}
		}
		
		PreparedStatement ps=conn.prepareStatement(sqlbuf.toString());
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Xianlu xianlutmp=new Xianlu();
			xianlutmp.setId(rs.getLong("id"));
			xianlutmp.setImgurl(rs.getString("imgurl"));
			xianlutmp.setName(rs.getString("name"));
			xianlutmp.setText(rs.getString("text"));
			lists.add(xianlutmp);
		}
		return lists;	
	}


	public List<Xianlu> selectAll() throws SQLException {
		List<Xianlu> lists = new ArrayList<Xianlu>();
		conn = C3P0Util.getConnection();
		String sql = "select * from tb_xianlu ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Xianlu xianlu = new Xianlu();
			xianlu.setId(rs.getLong("id"));
			xianlu.setImgurl(rs.getString("imgurl"));
			xianlu.setName(rs.getString("name"));
			xianlu.setText(rs.getString("text"));
			lists.add(xianlu);
		}
		return lists;
	}
	
	
	public void insert(Xianlu xianlu) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "insert into tb_xianlu values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setLong(1, xianlu.getId());
		ps.setNull(1,  java.sql.Types.BIGINT);
		ps.setString(2, xianlu.getImgurl());
		ps.setString(3, xianlu.getName());
		ps.setString(4, xianlu.getText());
		ps.execute();
	}
	
	public void delete(long id) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "delete from tb_xianlu where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
	}

	/**
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param xianlu
	 * @throws SQLException 
	*/
	public void update(Xianlu xianlu) throws SQLException {
		conn = C3P0Util.getConnection();
		String sql="update tb_xianlu set imgurl=?,name=?,text=? where id=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, xianlu.getImgurl());
		ps.setString(2, xianlu.getName());
		ps.setString(3, xianlu.getText());
		ps.setLong(4, xianlu.getId());
		ps.execute();		
	}
	
	
}