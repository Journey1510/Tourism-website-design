/**
* <p>Title: Xinwen.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月18日
* @version 1.0
*/
package org.ecit.entity;

import java.io.Serializable;

/**
 * <p>
 * Title: Xinwen
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
public class Xinwen implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String imgurl;
	private String name;
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Xinwen [id=").append(id).append(", imgurl=")
				.append(imgurl).append(", name=").append(name)
				.append(", text=").append(text).append("]");
		return builder.toString();
	}
}
