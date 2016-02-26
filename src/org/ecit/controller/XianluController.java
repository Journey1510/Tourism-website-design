/**
* <p>Title: XianluController.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: LTGames</p>
* @author xulei
* @date 2015年5月18日
* @version 1.0
*/
package org.ecit.controller;

import java.sql.SQLException;
import java.util.List;

import org.ecit.entity.Ticket;
import org.ecit.entity.Xianlu;
import org.ecit.service.XianluService;
import org.ecit.utils.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * <p>Title: XianluController</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
@Controller
@RequestMapping("/xianlu")
public class XianluController {
	@Autowired
	private XianluService xianluService;
	
	@RequestMapping("/select")
	@ResponseBody
	public String select(Xianlu xianlu){
		try {
			List<Xianlu> lists=xianluService.select(xianlu);
			return JSON.toJSONString(InvokeResult.success(lists));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/selectall")
	@ResponseBody
	public String selectAll(){
		try {
			List<Xianlu> lists=xianluService.selectAll();
			return JSON.toJSONString(InvokeResult.success(lists));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestParam String imgurl,@RequestParam String name,@RequestParam String text){
		Xianlu xianlu=new Xianlu();
		xianlu.setImgurl(imgurl);
		xianlu.setName(name);
		xianlu.setText(text);
		try {
			xianluService.insert(xianlu);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String delete(Xianlu xianlu){
		try {
			xianluService.update(xianlu);
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
			xianluService.delete(id);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
}
