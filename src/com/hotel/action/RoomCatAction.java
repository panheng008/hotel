package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hotel.model.Manage;
import com.hotel.model.Room;
import com.hotel.model.Room_cat;
import com.hotel.service.LogService;
import com.hotel.service.RoomCatService;
import com.hotel.service.RoomService;
import com.hotel.utils.Pager;
import com.hotel.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roomCatAction")
@Scope("prototype")
public class RoomCatAction extends ActionSupport implements ModelDriven<Room_cat>{
   private Room_cat room_cat;
   private String rName2;
   private int roomCatId;

    
public String getrName2() {
    return rName2;
}

public void setrName2(String rName2) {
    this.rName2 = rName2;
}
    @Override
	public Room_cat getModel() {
		if(room_cat==null) room_cat = new Room_cat();
		return room_cat;
	}
	
	@Autowired
	private RoomCatService roomCatService;
	
	@Autowired
	private LogService logService;
	//========================图片上传
    private File file;
    
    //提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;

    
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }
    public String getFileFileName() {
        return fileFileName;
    }
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
    public String getFileContentType() {
        return fileContentType;
    }
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    //========================图片上传

    
    public int getRoomCatId() {
        return roomCatId;
    }
    
    public void setRoomCatId(int roomCatId) {
        this.roomCatId = roomCatId;
    }
    
	/**
     * 获取客房类型信息列表
     * @return
     */
    public String roomCatList(){
      Pager<Room_cat> pagers = roomCatService.listAll();
    ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
    
  
    /**
     * 初始化客房类型新增页面
     * @return
     */
    public String addRoomCat(){
       return SUCCESS;
    }
    
    /**
     * 新增类型
     * @return
     */
    public String roomAddCat()throws Exception{
        //图片上传
        String root  = "D:/my/upload";
        InputStream is = new FileInputStream(file);
        fileFileName = UUIDUtils.create()+fileFileName;
        OutputStream os = new FileOutputStream(new File(root, fileFileName));
        System.out.println("fileFileName: " + fileFileName);
        System.out.println("file: " + file.getName());
        System.out.println("file: " + file.getPath());
        byte[] buffer = new byte[500];
        int length = 0;
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        os.close();
        is.close();
        room_cat.setImage("\\upload\\"+fileFileName);
        roomCatService.add(room_cat);
        String content="新增客房类型";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
      ActionContext.getContext().put("url", "/roomCat_roomCatList.do");
      return "redirect";
    }
    
    /**
     * 初始化修改页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String updateRoomCat(){
        Room_cat  room_cat =roomCatService.roomCatDetail(roomCatId);
        ActionContext.getContext().put("room_cat", room_cat);
         return "success";
     }
    
    /**
     * 修改客房类别
     * @return
     */
    public String roomCatUpdate()throws Exception{
        if(file!=null){
          //图片上传
        String root  = "D:/my/upload";
        InputStream is = new FileInputStream(file);
        fileFileName = UUIDUtils.create()+fileFileName;
        OutputStream os = new FileOutputStream(new File(root, fileFileName));
        System.out.println("fileFileName: " + fileFileName);
        System.out.println("file: " + file.getName());
        System.out.println("file: " + file.getPath());
        byte[] buffer = new byte[500];
        int length = 0;
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        os.close();
        is.close();
        room_cat.setImage("\\upload\\"+fileFileName);
        }else{
            Room_cat  r =roomCatService.roomCatDetail(room_cat.getId());
            room_cat.setImage(r.getImage());
        }
        roomCatService.update(room_cat);
        String content="修改客房类型";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/roomCat_roomCatList.do");
      return "redirect";
    }
    
    
    
    
    
    
}
