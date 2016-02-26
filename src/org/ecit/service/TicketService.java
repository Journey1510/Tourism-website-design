/**
* <p>Title: TicketService.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月23日
* @version 1.0
*/
package org.ecit.service;

import java.sql.SQLException;
import java.util.List;

import org.ecit.dao.JindianDao;
import org.ecit.dao.TicketDao;
import org.ecit.entity.Jindian;
import org.ecit.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: TicketService</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月23日
 */
@Service
public class TicketService {
	@Autowired
	private TicketDao ticketDao;
	
	public List<Ticket> SelectAll() throws SQLException{
		return ticketDao.selectAll();
	}
	public List<Ticket> select(Ticket ticket) throws SQLException {
		return ticketDao.select(ticket);
	}
	
	public void insert(Ticket ticket) throws SQLException{
		ticketDao.insert(ticket);
	}
	
	
	public void delete(long id) throws SQLException{
		ticketDao.delete(id);
	}
	/**
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param ticket
	 * @throws SQLException 
	*/
	public void update(Ticket ticket) throws SQLException {
		ticketDao.update(ticket);
	}
}
