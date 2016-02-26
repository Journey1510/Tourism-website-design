/**
* <p>Title: XinwenService.java</p>
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

import org.ecit.dao.XinwenDao;
import org.ecit.entity.Xianlu;
import org.ecit.entity.Xinwen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: XinwenService</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
@Service
public class XinwenService {
	@Autowired
	private XinwenDao xinwenDao;

	public List<Xinwen> select(Xinwen xinwen) throws SQLException {
		return xinwenDao.select(xinwen);
	}
	
	public List<Xinwen> selectAll() throws SQLException{
		return xinwenDao.selectAll();
	}
	
	public void insert(Xinwen xinwen) throws SQLException{
		xinwenDao.insert(xinwen);
	}
	
	public void delete(long id) throws SQLException{
		xinwenDao.delete(id);
	}

	/**
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param xinwen
	 * @throws SQLException 
	*/
	public void update(Xinwen xinwen) throws SQLException {
		xinwenDao.update(xinwen);
	}
}
