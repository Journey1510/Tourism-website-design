/**
* <p>Title: TicketDao.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月23日
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
import org.ecit.entity.Ticket;
import org.ecit.utils.C3P0Util;
import org.springframework.stereotype.Repository;

/**
 * <p>Title: TicketDao</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月23日
 */
@Repository
public class TicketDao {
	private Connection conn;
	
	public List<Ticket> selectAll() throws SQLException{
		List<Ticket> lists=new ArrayList<Ticket>();
		conn=C3P0Util.getConnection();
		String sql="select * from tb_ticket ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Ticket ticket=new Ticket();
			ticket.setId(rs.getLong("id"));
			ticket.setName(rs.getString("name"));
			ticket.setText(rs.getString("text"));
			ticket.setPrice(rs.getString("price"));
			lists.add(ticket);
		}
		return lists;	
	}
	
	public List<Ticket> select(Ticket ticket) throws SQLException{
		
		List<Ticket> lists=new ArrayList<Ticket>();
		conn=C3P0Util.getConnection();
		StringBuffer sqlbuf=new StringBuffer("select * from tb_ticket ");

		if(ticket.getId()!=null){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append(" id = ").append(ticket.getId()).append("");
			}else{
				sqlbuf.append(" where ").append("id = ").append(ticket.getId()).append("");
			}
		}
		
		if(!StringUtils.isBlank(ticket.getName())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("name like '%").append(ticket.getName()).append("%'");
			}else{
				sqlbuf.append(" where ").append("name like '%").append(ticket.getName()).append("%'");
			}
		}
		if(!StringUtils.isBlank(ticket.getText())){
			if(sqlbuf.indexOf("where")!=-1){
				sqlbuf.append(" and ").append("text like '%").append(ticket.getText()).append("%'");
			}else{
				sqlbuf.append(" where ").append("text like '%").append(ticket.getText()).append("%'");
			}
		}
		
		PreparedStatement ps=conn.prepareStatement(sqlbuf.toString());
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Ticket tickettmp=new Ticket();
			tickettmp.setId(rs.getLong("id"));
			tickettmp.setName(rs.getString("name"));
			tickettmp.setText(rs.getString("text"));
			tickettmp.setPrice(rs.getString("price"));
			lists.add(tickettmp);
		}
		return lists;	
	}
	
	
	public void insert(Ticket ticket) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "insert into tb_ticket values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ps.setLong(1, jindian.getId());
		ps.setNull(1,  java.sql.Types.BIGINT);
		ps.setString(2, ticket.getName());
		ps.setString(3, ticket.getText());
		ps.setString(4, ticket.getPrice());
		ps.execute();
	}
	
	public void delete(long id) throws SQLException{
		conn = C3P0Util.getConnection();
		String sql = "delete from tb_ticket where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ps.execute();
	}

	/**
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param ticket
	 * @throws SQLException 
	*/
	public void update(Ticket ticket) throws SQLException {
		conn = C3P0Util.getConnection();
		String sql="update tb_ticket set name=?,text=?,price=? where id=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ticket.getName());
		ps.setString(2, ticket.getText());
		ps.setString(3, ticket.getPrice());
		ps.setLong(4, ticket.getId());
		ps.execute();
	}
}
