package com.hotel.action;



import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hotel.model.Log;
import com.hotel.model.Manage;
import com.hotel.service.LogService;
import com.hotel.service.ManageService;
import com.hotel.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("logAction")
@Scope("prototype")
public class LogAction extends ActionSupport implements ModelDriven<Log>{

    private Log log;
    
    private int logId;
    
    @Override
	public Log getModel() {
		if(log==null) log = new Log();
		return log;
	}
	
    @Autowired
    private LogService  logService;
    
    @Autowired
    private ManageService manageService;
    

    public int getLogId() {
        return logId;
    }

    
    public void setLogId(int logId) {
        this.logId = logId;
    }

    /**
     * 获取日志列表
     * @return
     */
    public String logList(){
      Pager<Log> pagers = logService.listAll();
     ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
    
    /**
     * 日志初始化新增页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String addLog() {
        List<Manage> manageList=manageService.list();
        ActionContext.getContext().put("manageList", manageList);
        return "success";
    }
    
    /**
     * 新增日志
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String logAdd(){
        logService.add(log);
        String content="新增日志";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/log_logList.do");
        return "redirect";
    }
    
    /**
     * 删除日志
     * @return
     */
    public String delLog(){
        logService.delLog(logId);
        String content="删除日志";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/log_logList.do");
        return "redirect";
    }
    
    /**
     * 初始化修改页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String updateLog(){
        Log log =logService.logDetail(logId);
        List<Manage> manageList=manageService.list();
        ActionContext.getContext().put("manageList", manageList);
        ActionContext.getContext().put("log", log);
         return "success";
     }
    
    /**
     * 修改日志
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String logUpdate(){
        logService.update(log);
        String content="修改日志";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/log_logList.do");
        return "redirect";
     }
}
