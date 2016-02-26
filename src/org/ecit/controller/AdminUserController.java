
package org.ecit.controller;

import java.sql.SQLException;
import java.util.List;

import org.ecit.entity.AdminUser;
import org.ecit.entity.Jindian;
import org.ecit.exception.PasswordException;
import org.ecit.exception.UserNameException;
import org.ecit.service.AdminUserService;
import org.ecit.utils.InvokeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;



@Controller
@RequestMapping("/admin")
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello(@RequestParam String username){
		AdminUser adminUser=new AdminUser();
		adminUser.setId((long) 1);
		adminUser.setPassword("123456");
		adminUser.setUsername(username);
		return JSON.toJSONString(InvokeResult.success(adminUser));
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam String username,@RequestParam String password){
		try {
			if(adminUserService.login(username, password)){
				return JSON.toJSONString(InvokeResult.success());
			}else{
				return JSON.toJSONString(InvokeResult.failure("Login error"));
			}
		} catch (SQLException | UserNameException | PasswordException e) {
			return JSON.toJSONString(InvokeResult.failure(e.getMessage()));
		}
		//return JSON.toJSONString(InvokeResult.failure("error"));
	}
	
	@RequestMapping("/selectall")
	@ResponseBody
	public String selectAll(){
		try {
			List<AdminUser> lists=adminUserService.SelectAll();
			//System.out.println(lists);
			return JSON.toJSONString(InvokeResult.success(lists));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestParam String username,@RequestParam String password){
		try {
			AdminUser adminUser=new AdminUser();
			adminUser.setUsername(username);
			adminUser.setPassword(password);
			adminUserService.insert(adminUser);
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
			adminUserService.delete(id);
			return JSON.toJSONString(InvokeResult.success());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(InvokeResult.failure(""));
	}
	
}
