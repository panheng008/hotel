package com.hotel.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hotel.model.Book;
import com.hotel.model.Item;
import com.hotel.model.Item_cat;
import com.hotel.model.Room;
import com.hotel.model.Room_cat;
import com.hotel.model.User;
import com.hotel.model.UserItem;
import com.hotel.model.UserRoom;
import com.hotel.service.BookService;
import com.hotel.service.ItemCatService;
import com.hotel.service.ItemService;
import com.hotel.service.LogService;
import com.hotel.service.RoomCatService;
import com.hotel.service.RoomService;
import com.hotel.service.UserRoomService;
import com.hotel.service.UserService;
import com.hotel.service.UserItemService;
import com.hotel.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("bookAction")
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<Book>{
   private Book book;
   private Room room;
   
   public Room getRoom() {
	return room;
   }

   public void setRoom(Room room) {
	this.room = room;
   }
   private int userId;
   private int bookId;
   private int roomId;
   private int itemId;


	public int getRoomId() {
		return roomId;
    }

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    
    public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public Book getModel() {
		if(book==null) book = new Book();
		return book;
	}
	@Autowired
    private LogService  logService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomCatService  roomCatService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemSerivce;
	
	@Autowired
	private ItemCatService itemCatService;
	
	@Autowired
	private UserItemService userItemService;
	
	@Autowired
	private UserRoomService userRoomService;
	/**
     * 获取用户预订房间信息列表
     * @return
     */
    public String bookList(){
      Pager<Book> pagers = bookService.listAll();
    ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
	
    
    /**
     * 获取取消预定信息详情
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String updateBook(){
        Book book =bookService.bookDetail(bookId);
        ActionContext.getContext().put("book", book);
         return "success";
     }
    
    
    /**
     * 后台管理员取消预定
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String cancelBook(){
        Book book =bookService.bookDetail(bookId);
        //删除订单表
        bookService.delBook(bookId);
        //修改房间状态
        Room room=roomService.roomDetail(book.getRoom().getId());
        room.setIsLive(1);
        roomService.update(room);
        //修改房间类别数量
       Room_cat room_cat=roomCatService.load(room.getRoom_cat().getId());
       room_cat.setNum(room_cat.getNum()+1);
       roomCatService.update(room_cat);
        String content="取消预定";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/book_bookList.do");
        return "redirect";
        }
    
    /**
     * 获取用户已入住信息列表
     * @return
     */
    public String liveList(){
        Pager<Book> pagers = bookService.listAll();
        ActionContext.getContext().put("pagers", pagers);
      return SUCCESS;
      }
  
    
    /**
     * 获取入住详情信息列表
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String liveRoom(){
        Book book =bookService.bookDetail(bookId);
        
        
        ActionContext.getContext().put("book", book);
         return "success";
     }
    
    /**
     * 后台管理员立即入住
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String live(){
        Book book =bookService.bookDetail(bookId);
        book.setStatus(2);
        //更新预定表
        bookService.updateBook(book);
        //修改房间状态
        Room room=roomService.roomDetail(book.getRoom().getId());
        room.setIsLive(3);
        roomService.update(room);
        String content="办理入住";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/book_bookList.do");
        return "redirect";
        }
    
    /**
     * 获取更换房间信息列表
     * @return
     */
    public String changeRoomList(){
        Pager<Book> pagers = bookService.listAllLive();
      ActionContext.getContext().put("pagers", pagers);
      return SUCCESS;
      }
    
    /**
     * 获取更换房间信息详情
     * @return
     */
    public String changeRoom(){
      Book book =bookService.bookDetail(bookId);
      ActionContext.getContext().put("book", book);
      return SUCCESS;
      }
    
    
    /**
     * 获取更换房间信息修改页面
     * @return
     */
    public String roomChange(){
      Book book =bookService.bookDetail(bookId);
      List<Room_cat> roomCatList=roomCatService.list();
      ActionContext.getContext().put("roomCatList", roomCatList);
      ActionContext.getContext().put("book", book);
      return SUCCESS;
    }
    /**
     * 后台管理员更换房间
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String change(){
        Book book =bookService.bookDetail(bookId);
        book.setStatus(2);
        //更新预定表
        bookService.updateBook(book);
        //修改房间状态
        Room room=roomService.roomDetail(book.getRoom().getId());
        room.setIsLive(3);
        roomService.update(room);
        String content="办理入住";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/book_bookList.do");
        return "redirect";
        }
    
    
    
    /**
     * 前台预定房间
     * @return
     */
    public String bookRoom(){
	  HttpSession session =ServletActionContext.getRequest().getSession();
	     int userId=0;
	 	 if(session.getAttribute("userId")!=null){
	 	      userId = Integer.parseInt( session.getAttribute("userId").toString());
	 	 }else{
	 		 return "login";
	 	 }
    	  //更改房间状态变为预定
    	  Room room =roomService.load(roomId);
    	  room.setIsLive(2);
    	  roomService.update(room);
    	  //修改房间类别数量减一
    	  Room_cat room_cat=roomCatService.load(room.getRoom_cat().getId());
          room_cat.setNum(room_cat.getNum()-1);
          roomCatService.update(room_cat);
    	  //插入订单表
          Book book1=new Book();
          book1.setBookTime(new Date());
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
      	  String reachTime=sdf.format(book.getReachTime());
     	  String leaveTime=sdf.format(book.getLeaveTime());
     	 
     	  
     	 Calendar calendar2 = Calendar.getInstance();
     	 
     	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
     	calendar2.add(Calendar.DATE, 3);
     	String three_days_after = sdf2.format(calendar2.getTime());
     	int reachTimes = Integer(reachTime);
     
     	int three_days_afters =Integer(three_days_after);
     	if(three_days_afters>reachTimes){
     	   System.out.println("入住时间在当前时间三天之内");
     	}else if(three_days_afters < reachTimes){
     		 System.out.println("入住时间在当前时间三天之外");
     	}
     	
     	
     	
        	Date rTime=new Date();
        	Date lTime=new Date();
      	     try {
  				 rTime=sdf.parse(reachTime);
  				 lTime=sdf.parse(leaveTime);
  			} catch (ParseException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}    
          book1.setLeaveTime(lTime);
          book1.setReachTime(rTime);
          book1.setStatus(1);
          book1.setRoomNumber(1);
          User user=userService.load(userId);
          book1.setBookUser(user);
          book1.setRoom(room);
          bookService.add(book1);
          //插入房间和人关联的表
          UserRoom userRoom=new UserRoom();
          userRoom.setRoom(room);
          userRoom.setUser(user);
          userRoomService.add(userRoom);
          ActionContext.getContext().put("url", "/login_index.do");
          return "redirect";
      }
    	
    	
   
    private int Integer(String leaveTime) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
     * 前台购买商品
     * @return
     */
    public String bookItem(){
    	 HttpSession session =ServletActionContext.getRequest().getSession();
    	 int userId=0;
    	 if(session.getAttribute("userId")!=null){
    	      userId = Integer.parseInt( session.getAttribute("userId").toString());
    	 }else{
    		 return "login";
    	 }
       	  Item item =itemSerivce.load(itemId);
       	  //修改商品类别数量减一
       	  Item_cat item_cat=itemCatService.load(item.getItem_cat().getCid());
         	item_cat.setNum(item_cat.getNum()-1);
         	itemCatService.update(item_cat);
         	 User user=userService.load(userId);
             //插入商品和人关联的表
             UserItem userItem =new UserItem();
             userItem.setItem(item);
             userItem.setUser(user);
             userItemService.add(userItem);
             ActionContext.getContext().put("url", "/login_index.do");
             return "redirect";
    }
}
