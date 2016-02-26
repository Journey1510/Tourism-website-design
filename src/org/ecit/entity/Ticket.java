/**
* <p>Title: Ticket.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月23日
* @version 1.0
*/
package org.ecit.entity;

import java.io.Serializable;

/**
 * <p>Title: Ticket</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月23日
 */
public class Ticket implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String text;
	private String price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket [id=").append(id).append(", name=").append(name)
				.append(", text=").append(text).append(", price=")
				.append(price).append("]");
		return builder.toString();
	}
}
