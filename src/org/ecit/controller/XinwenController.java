/**
* <p>Title: XinwenController.java</p>
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

import org.ecit.entity.Xianlu;
import org.ecit.entity.Xinwen;
import org.ecit.service.XinwenService;
import org.ecit.utils.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * <p>Title: XinwenController</p>
 * <p>Description: </p>
 * <p>Company: LTGames</p>
 * @author     xulei
 * @date       2015年5月18日
 */
@Controller
@RequestMapping("/xinwen")
public class XinwenController {
	@Autowired
	private XinwenService  xinwenService;
	
	@RequestMapping("/select")
	@ResponseBody
	public String select(Xinwen xinwen){
		try {
			List<Xinwen> lists=xinwenService.select(xinwen);
			return JSON.toJSONString(InvokeResult.success(lists));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/selectall")
	@ResponseBody
	private String selectAll(){
		try {
			List<Xinwen> lists=xinwenService.selectAll();
			return JSON.toJSONString(InvokeResult.success(lists));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestParam String imgurl,@RequestParam String name,@RequestParam String text){
		Xinwen xinwen=new Xinwen();
		xinwen.setImgurl(imgurl);
		xinwen.setName(name);
		xinwen.setText(text);
		try {
			xinwenService.insert(xinwen);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String delete(Xinwen xinwen){
		try {
			xinwenService.update(xinwen);
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
			xinwenService.delete(id);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
}
