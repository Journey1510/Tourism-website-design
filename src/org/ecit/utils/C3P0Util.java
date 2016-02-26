package org.ecit.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 数据库工具类
 * @author liang
 *
 */
public class C3P0Util {
	static ComboPooledDataSource cpds=null;
	static{
		//这里有个优点，写好配置文件，想换数据库，简单
		//cpds = new ComboPooledDataSource("oracle");//这是oracle数据库
		cpds = new ComboPooledDataSource("mysql");//这是mysql数据库 （跳转到c3p0-config.xml文件中的配置）
	}
	/**
	 * 获得数据库连接
	 * @return   Connection
	 */
	public static Connection getConnection(){
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 数据库关闭操作
	 * @param conn  
	 * @param st    
	 * @param pst
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement pst,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
