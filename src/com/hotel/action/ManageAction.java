package com.hotel.action;

import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hotel.model.Manage;
import com.hotel.model.User;
import com.hotel.service.LogService;
import com.hotel.service.ManageService;
import com.hotel.service.UserService;
import com.hotel.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("manageAction")
@Scope("prototype")
public class ManageAction extends ActionSupport implements ModelDriven<Manage>{

   private Manage manage;
   private int userId;
   private int manageId;
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getManageId() {
        return manageId;
    }

    
    public void setManageId(int manageId) {
        this.manageId = manageId;
    }

    @Override
	public Manage getModel() {
		if(manage==null) manage = new Manage();
		return manage;
	}
	
	@Autowired
	private ManageService manageService;
	
	@Autowired
	private UserService  userService;
	
	@Autowired
	private LogService logService;
	/**
	 * 登陆以后进入首页
	 * @return
	 */
	public String index(){
		Manage ma =	manageService.login(manage);
		if(ma == null){
			return "login";
		}
		HttpSession session =ServletActionContext.getRequest().getSession();
		session.setAttribute("userName", ma.getName());
		session.setAttribute("userId", ma.getId());
		session.setAttribute("type1", ma.getType());
	    return SUCCESS;  //返回成功后默认为你提交需要跳转的方法中去
	}
	
	
	/**    
     * 获取用户列表
     * @return
     */
    public String userList(){
      Pager<User> pagers = userService.listAll();
    ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
	
    /**
     * 删除用户
     * @return
     */
//    public String delUser(){
//        userService.delUse(userId);
//        String content="删除用户";
//        HttpSession session =ServletActionContext.getRequest().getSession();
//        int userId = Integer.parseInt( session.getAttribute("userId").toString());
//        //插入日志
//        logService.addLog(content,userId);
//        ActionContext.getContext().put("url", "/manage_userList.do");
//        return "redirect";
//    }
    
    /**
     * 用户详情
     * @return
     */
    public String userDetail(){
        User user =userService.userDetail(userId);
        ActionContext.getContext().put("user", user);
        return SUCCESS;
    }
    
    /**
     * 获取权限管理员列表
     * @return
     */
    public String authList(){
      Pager<Manage> pagers = manageService.listAll();
    ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
    
    /**
     * 删除管理员
     * @return
     */
    public String delManage(){
        manageService.delManage(manageId);
        String content="删除管理员";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/manage_authList.do");
        return "redirect";
    }
    
    /**
     * 用户详情
     * @return
     */
    public String authDetail(){
        Manage manage =manageService.manageDetail(manageId);
        ActionContext.getContext().put("manage", manage);
        return SUCCESS;
    }
    
    /**
     * 管理员新增页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String addAuth() {
        return "success";
    }
    
    
    /**
     * 新增管理员
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String addManage(){
       manage.setCreateTime(new Date());
       manage.setIsDelete(2);
        manageService.add(manage);
        String content="新增管理员";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/manage_authList.do");
        return "redirect";
    }
    
    /**
     * 初始化修改页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String updateManage(){
        Manage manage =manageService.manageDetail(manageId);
        ActionContext.getContext().put("manage", manage);
         return "success";
     }
    
    /**
     * 修改管理员
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String updateAuth(){
        manageService.update(manage);
        String content="修改管理员";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/manage_authList.do");
        return "redirect";
     }
}
