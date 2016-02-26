/**
 * <p>Title: JindianService.java</p>
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

import org.ecit.dao.JindianDao;
import org.ecit.entity.Jindian;
import org.ecit.entity.Xianlu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Title: JindianService
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
@Service
public class JindianService {
	@Autowired
	private JindianDao jindianDao;

	public List<Jindian> SelectAll() throws SQLException {
		return jindianDao.selectAll();
	}

	public List<Jindian> select(Jindian jindian) throws SQLException {
		return jindianDao.select(jindian);
	}

	public void insert(Jindian jindian) throws SQLException {
		jindianDao.insert(jindian);
	}

	public void delete(long id) throws SQLException {
		jindianDao.delete(id);
	}

	/**
	* <p>Title: update</p>
	* <p>Description: </p>
	* @param jindian
	 * @throws SQLException 
	*/
	public void update(Jindian jindian) throws SQLException {
		jindianDao.update(jindian);
	}

}
