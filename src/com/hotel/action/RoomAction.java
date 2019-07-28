package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hotel.dto.RoomDto;
import com.hotel.model.Book;
import com.hotel.model.Manage;
import com.hotel.model.Room;
import com.hotel.model.Room_cat;
import com.hotel.model.User;
import com.hotel.model.UserRoom;
import com.hotel.service.BookService;
import com.hotel.service.LogService;
import com.hotel.service.RoomCatService;
import com.hotel.service.RoomService;
import com.hotel.service.UserRoomService;
import com.hotel.service.UserService;
import com.hotel.utils.Pager;
import com.hotel.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("roomAction")
@Scope("prototype")
public class RoomAction extends ActionSupport implements ModelDriven<Room>{
   private Room room;
   
   private int roomId;
   
   private int roomCatId;

    @Override
	public Room getModel() {
		if(room==null) room = new Room();
		return room;
	}
	
	@Autowired
	private RoomService roomService;
	
	   
    @Autowired
    private RoomCatService roomCatService;
    
    @Autowired
    private LogService logService;
    
    @Autowired
    private BookService bookService;
    
	@Autowired
	private UserRoomService userRoomService;
	
	@Autowired
	private UserService userService;
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
	
    
	/**
     * 获取客房信息列表
     * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
     */
    public String roomList() throws IllegalAccessException, InvocationTargetException{
      Pager<Room> pagers = roomService.listAll();
//      List<RoomDto> rds = new ArrayList<RoomDto>();
//      for(Room r:pagers.getDatas()){
//          RoomDto rd = new RoomDto();
//          BeanUtils.copyProperties(rd, r);
//          //通过类型差名字
//         r.getRoom_cat().getrName();
//      }
    ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
	
    
    
    public int getRoomCatId() {
		return roomCatId;
	}
	public void setRoomCatId(int roomCatId) {
		this.roomCatId = roomCatId;
	}
	public int getRoomId() {
        return roomId;
    }
    
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    /**
     * 初始化客房新增页面
     * @return
     */
    public String addRoom(){
       List<Room_cat> roomCatList=roomCatService.list();
       ActionContext.getContext().put("roomCatList", roomCatList);
       return SUCCESS;
    }
    
    /**
     * 新增客房
     * @return
     */
    public String roomAdd()throws Exception{
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
        room.setImage("\\upload\\"+fileFileName);
      roomService.add(room);
      
      Room_cat  room_cat1=roomCatService.load(room.getRoom_cat().getId());
      room_cat1.setNum(room_cat1.getNum()+1);
     roomCatService.update(room_cat1);
      String content="新增客房";
      HttpSession session =ServletActionContext.getRequest().getSession();
      int userId = Integer.parseInt( session.getAttribute("userId").toString());
      //插入日志
      logService.addLog(content,userId);
      ActionContext.getContext().put("url", "/room_roomList.do");
      return "redirect";
    }
    
    
    /**
     * 删除客房
     * @return
     */
    public String delRoom(){
        Room  room =roomService.roomDetail(roomId);
        roomService.delRoom(roomId);
        Room_cat  room_cat1=roomCatService.load(room.getRoom_cat().getId());
        room_cat1.setNum(room_cat1.getNum()-1);
        roomCatService.update(room_cat1);
        String content="删除客房";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/room_roomList.do");
        return "redirect";
    }
    
    /**
     * 初始化修改页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String updateRoom(){
        Room  room =roomService.roomDetail(roomId);
        List<Room_cat> roomCatList=roomCatService.list();
        ActionContext.getContext().put("roomCatList", roomCatList);
        ActionContext.getContext().put("room", room);
         return "success";
     }
    
    /**
     * 修改客房
     * @return
     */
    public String roomUpdate()throws Exception{
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
        room.setImage("\\upload\\"+fileFileName);
        }else{
            Room  r =roomService.roomDetail(room.getId());
            room.setImage(r.getImage());
        }
        roomService.update(room);
        String content="修改客房";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
      ActionContext.getContext().put("url", "/room_roomList.do");
      return "redirect";
    }
    
    
    /**
     * 获取客房前的信息列表
     * @return
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    public String changeRoomList() {
      Pager<Room> pagers = roomService.listAllChangeRoom();
     ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
    
    
    //前端页面点击立即预定跳的页面
    public String roomIndex(){
     Pager<Room> pagers = roomService.queryRooms(roomCatId);
     ActionContext.getContext().put("pagers", pagers);
	 return SUCCESS;
    }
    
    
}
