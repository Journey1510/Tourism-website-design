/**
* <p>Title: PassWordUtils.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月18日
* @version 1.0
*/
package org.ecit.utils;

/**
 * <p>Title: PassWordUtils</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
public class PassWordUtils {
	/** 将用户名、密码、盐进行MD5加密之后得到加密了的密码*/
	public static String encrypt(String username,String oldPassword){
		MD5 md5=new MD5();
		String newPassword=md5.getMD5ofStr(username+oldPassword+"salt");
		return newPassword;
	}
}
