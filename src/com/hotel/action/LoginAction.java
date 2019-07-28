package com.hotel.action;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hotel.model.Item_cat;
import com.hotel.model.Room_cat;
import com.hotel.service.ItemCatService;
import com.hotel.service.RoomCatService;
import com.hotel.utils.Pager;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction {
    
    @Autowired
    private RoomCatService roomCatService;
    
    @Autowired
    private ItemCatService itemCatService;
	//首页
	public String index() {
	    Pager<Room_cat> pagers = roomCatService.listAll();
	    Pager<Item_cat> pager = itemCatService.listAll();
	    ActionContext.getContext().put("pager", pager);
	    ActionContext.getContext().put("pagers", pagers);
        return "success";
	}
	//登陆页面
	public String login() {
		return "success";
	}
   //注册页面
	public String register() {
		return "success";
	}
	   //退出
		public String tuichu() {
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("userName");
			session.remove("userId");
			return "login";
		}
}
