package com.lezhi.supermarket.web.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lezhi.supermarket.biz.service.LoginService;
import com.lezhi.supermarket.model.validation.User;


@Controller
@RequestMapping("")
public class LoginAction  extends BaseAction {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public void login(String userName,String password,HttpServletResponse response,HttpServletRequest request){
		String msg="";
		JSONObject json = new JSONObject();
		try {
				User user = null;
				if(null != user){
					 if(password.equals(user.getPassword())){
			 			msg="登录成功！";
			 			json.put("state", "0");
					 }else{
						msg="密码错误！";
						json.put("state", "2");
					 }
				}
				else{
					msg="用户不存在！";
					json.put("state", "1");
				}	
			json.put("msg", msg);
			response.setContentType("application/json");  
			response.setCharacterEncoding("UTF-8");
          	PrintWriter writer = response.getWriter();
          	writer.write(json.toString());
          	writer.flush();
          	writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/userRegister",method=RequestMethod.POST)
	public void userRegister(String id,String userName,String password,HttpServletResponse response,HttpServletRequest request){
		String msg="";
		JSONObject json = new JSONObject();
		try {
			/*********************** 用户插入 start  *************************/
//			  User user = new User();
//			  user.setId(id);
//			  user.setUserName(userName);
//			  user.setPassword(password);
//			  boolean result = loginService.insert(user);
//				if(result){
//			 			msg="注册成功！";
//			 			json.put("state", "0");
//				}else{
//					msg="注册失败！";
//					json.put("state", "1");
//				}	
			/*********************** 用户批量插入 start  *************************/
//			List<User> list = new ArrayList<User>();
//			User user1 = new User();
//		    user1.setId("8");
//		    user1.setUserName("gaox6");
//		    user1.setPassword("888");
//		    list.add(user1);
//		    User user2 = new User();
//		    user2.setId("9");
//		    user2.setUserName("gaox7");
//		    user2.setPassword("888");
//		    list.add(user2);
//		    loginService.insertOfBatch(list);
//		    msg="批量插入成功";
//		    json.put("state","0")
			/*********************** 根据主键删除 start  *************************/
//			boolean res = loginService.deleteById("9");
//			if(res){
//				msg="删除成功！";
//	 			json.put("state", "0");
//			}else{
//				msg="删除失败！";
//	 			json.put("state", "1");
//			}
			/************************ 根据主键更新 start ****************************/
//			User user2 = new User();
//		    user2.setId("8");
//		    user2.setUserName("gaox7");
//		    user2.setPassword("888");
//		    boolean res = loginService.update(user2);
//		    if(res){
//				msg="更新成功！";
//	 			json.put("state", "0");
//			}else{
//				msg="更新失败！";
//	 			json.put("state", "1");
//			}
			/************************ 根据ID查询实体 start **************************/
//			User user = loginService.findById("8");
			/************************ 获取表所有对象 start **************************/
//			List<User> list = loginService.findAll();
			/************************ 查询表总数量 start ***************************/
			Long num = loginService.findAllCount();
			json.put("msg", msg);
			response.setContentType("application/json");  
			response.setCharacterEncoding("UTF-8");
          	PrintWriter writer = response.getWriter();
          	writer.write(json.toString());
          	writer.flush();
          	writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/userDelete",method=RequestMethod.POST)
	public void userDelete(String id,HttpServletResponse response,HttpServletRequest request){
		String msg="";
		JSONObject json = new JSONObject();
		try {
			  boolean result = false;
				if(result){
			 			msg="删除成功！";
			 			json.put("state", "0");
				}else{
					msg="删除失败！";
					json.put("state", "1");
				}	
			json.put("msg", msg);
			response.setContentType("application/json");  
			response.setCharacterEncoding("UTF-8");
          	PrintWriter writer = response.getWriter();
          	writer.write(json.toString());
          	writer.flush();
          	writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/login" )
	public ModelAndView login(String userId,HttpServletRequest request)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login");
		return mv;
	}

}
