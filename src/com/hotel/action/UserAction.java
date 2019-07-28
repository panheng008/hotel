package com.hotel.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hotel.model.Item_cat;
import com.hotel.model.Room_cat;
import com.hotel.model.Suggest;
import com.hotel.model.User;
import com.hotel.service.ItemCatService;
import com.hotel.service.RoomCatService;
import com.hotel.service.SuggestService;
import com.hotel.service.UserService;
import com.hotel.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
    
    private String aaa;
    
    @Autowired
    private RoomCatService roomCatService;
    
    @Autowired
    private ItemCatService itemCatService;
//    public String getContent() {
//        return content;
//    }
//    
//    public void setContent(String content) {
//        this.content = content;
//    }
    
    
    public String getAaa() {
        return aaa;
    }

    
    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    public User getModel() {
        if(user==null) user = new User();
        return user;
    }
        
	@Autowired
	private UserService userService;

	@Autowired
	private SuggestService suggestService;
	
	//注册
	public String register(){
		User u1 =userService.query(user.getUserName());
		if(u1 == null){
			user.setIsDelete(2);
			user.setCreateTime(new Date());
			userService.add(user);
			return "login";
		}else{
			  return "register";
		}
	}
	//登录
	public String login(){
		User u =userService.load(user);
		if(u == null){
			return "register";
		}else{
			Pager<Room_cat> pagers = roomCatService.listAll();
		    Pager<Item_cat> pager = itemCatService.listAll();
		    ActionContext.getContext().put("pager", pager);
		    ActionContext.getContext().put("pagers", pagers);
		HttpSession session =ServletActionContext.getRequest().getSession();
		session.setAttribute("userName", u.getUserName());
		session.setAttribute("userId", u.getId());
		  return "index";
		}
		
	}
	
//	public String list() throws IllegalAccessException, InvocationTargetException {
//		User tu = (User)ActionContext.getContext().getSession().get("loginUser");
//		ActionContext.getContext().put("list", userService.listAllCanSendUser(1));
//		return SUCCESS;
//	}
//	public String add() {
//		userService.add(user);
//		return "success";
//	}
	
	public String fankui(){
	    HttpSession session =ServletActionContext.getRequest().getSession();
	   Integer userId=(Integer) session.getAttribute("userId");
	    if(userId!=null){
	        User u =userService.load(userId);
            Suggest suggest=new Suggest();
            suggest.setContent(aaa);
            suggest.setUserId(u);
            suggest.setCreateTime(new Date());
            suggestService.add(suggest);
            return "index";
	    }else{
	        return "login";
	    }
	}
}  
