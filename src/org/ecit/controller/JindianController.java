/**
* <p>Title: JindianController.java</p>
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

import org.ecit.entity.Jindian;
import org.ecit.service.JindianService;
import org.ecit.utils.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * <p>Title: JindianController</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
@Controller
@RequestMapping("/jindian")
public class JindianController {
	@Autowired
	private JindianService jindianService;
	
	@RequestMapping("/selectall")
	@ResponseBody
	public String selectAll(){
		try {
			List<Jindian> lists=jindianService.SelectAll();
			//System.out.println(lists);
			return JSON.toJSONString(InvokeResult.success(lists));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public String select(Jindian jindian){
		try {
			List<Jindian> lists=jindianService.select(jindian);
			//System.out.println(lists);
			return JSON.toJSONString(InvokeResult.success(lists));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestParam String imgurl,@RequestParam String name,@RequestParam String text){
		try {
			Jindian jindian=new Jindian();
			jindian.setImgurl(imgurl);
			jindian.setName(name);
			jindian.setText(text);
			jindianService.insert(jindian);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String insert(Jindian jindian){
		try {
			jindianService.update(jindian);
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
			jindianService.delete(id);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
}
