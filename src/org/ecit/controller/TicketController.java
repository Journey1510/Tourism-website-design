/**
* <p>Title: TicketController.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月23日
* @version 1.0
*/
package org.ecit.controller;

import java.sql.SQLException;
import java.util.List;

import org.ecit.entity.Jindian;
import org.ecit.entity.Ticket;
import org.ecit.service.TicketService;
import org.ecit.utils.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * <p>Title: TicketController</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月23日
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	
	@RequestMapping("/selectall")
	@ResponseBody
	public String selectAll(){
		try {
			List<Ticket> lists=ticketService.SelectAll();
			//System.out.println(lists);
			return JSON.toJSONString(InvokeResult.success(lists));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public String select(Ticket ticket){
		try {
			List<Ticket> lists=ticketService.select(ticket);
			return JSON.toJSONString(InvokeResult.success(lists));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestParam String name,@RequestParam String text,@RequestParam String price){
		try {
			Ticket ticket=new Ticket();
			ticket.setName(name);
			ticket.setText(text);
			ticket.setPrice(price);
			ticketService.insert(ticket);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String delete(Ticket ticket){
		try {
			ticketService.update(ticket);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam long id){
		try {
			ticketService.delete(id);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	

}
