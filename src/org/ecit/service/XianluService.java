/**
* <p>Title: XianluService.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月18日
* @version 1.0
*/
package org.ecit.service;

import java.sql.SQLException;
import java.util.List;

import org.ecit.dao.XianluDao;
import org.ecit.entity.Ticket;
import org.ecit.entity.Xianlu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: XianluService</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
@Service
public class XianluService {
	@Autowired
	private XianluDao xianluDao;
	
	public List<Xianlu> select(Xianlu xianlu) throws SQLException {
		return xianluDao.select(xianlu);
	}
	
	public List<Xianlu> selectAll() throws SQLException{
		return xianluDao.selectAll();
	}
	
	public void insert(Xianlu xianlu) throws SQLException{
		xianluDao.insert(xianlu);
	}
	
	
	public void delete(long id) throws SQLException{
		xianluDao.delete(id);
	}

	/**
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param xianlu
	 * @throws SQLException 
	*/
	public void update(Xianlu xianlu) throws SQLException {
		xianluDao.update(xianlu);
	}
}
