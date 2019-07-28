package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hotel.model.Item;
import com.hotel.model.Item_cat;
import com.hotel.model.Room;
import com.hotel.service.ItemCatService;
import com.hotel.service.ItemService;
import com.hotel.service.LogService;
import com.hotel.utils.Pager;
import com.hotel.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("itemAction")
@Scope("prototype")
public class ItemAction extends ActionSupport implements ModelDriven<Item>{
    private Item item;
    
    private int itemId;
    
    private int itemCatId;
    
    

    public int getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(int itemCatId) {
		this.itemCatId = itemCatId;
	}

	public int getItemId() {
        return itemId;
    }
    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    @Override
     public Item getModel() {
         if(item==null) item = new Item();
         return item;
     }
     
     @Autowired
     private ItemCatService itemCatService;
     
     @Autowired
     private ItemService itemService;
     
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
     /**
      * 获取商品信息列表
      * @return
      * @throws InvocationTargetException 
      * @throws IllegalAccessException 
      */
     public String itemList() {
       Pager<Item> pagers = itemService.listAll();
       ActionContext.getContext().put("pagers", pagers);
     return SUCCESS;
     }
     
     /**
      * 初始化商品新增页面
      * @return
      */
     public String addItem(){
        List<Item_cat> itemCatList=itemCatService.list();
        ActionContext.getContext().put("itemCatList", itemCatList);
        return SUCCESS;
     }
     
     
     /**
      * 新增商品
      * @return
      */
     public String itemAdd()throws Exception{
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
         item.setImage("\\upload\\"+fileFileName);
         itemService.add(item);
       
       Item_cat item_cat=itemCatService.load(item.getItem_cat().getCid());
       item_cat.setNum(item_cat.getNum()+1);
       itemCatService.update(item_cat);
       String content="新增商品";
       HttpSession session =ServletActionContext.getRequest().getSession();
       int userId = Integer.parseInt( session.getAttribute("userId").toString());
       //插入日志
       logService.addLog(content,userId);
       ActionContext.getContext().put("url", "/item_itemList.do");
       return "redirect";
     }
     
     
     /**
      * 删除商品
      * @return
      */
     public String delItem(){
         Item item =itemService.itemDetail(itemId);
         itemService.delItem(itemId);
         Item_cat  item_cat=itemCatService.load(item.getItem_cat().getCid());
         item_cat.setNum(item_cat.getNum()-1);
         itemCatService.update(item_cat);
         String content="删除商品";
         HttpSession session =ServletActionContext.getRequest().getSession();
         int userId = Integer.parseInt( session.getAttribute("userId").toString());
         //插入日志
         logService.addLog(content,userId);
         ActionContext.getContext().put("url", "/item_itemList.do");
         return "redirect";
     }
     
     /**
      * 初始化修改页面
      * @Description (TODO这里用一句话描述这个方法的作用)
      * @return
      */
     public String updateItem(){
        Item  item =itemService.itemDetail(itemId);
        List<Item_cat> itemCatList=itemCatService.list();
        ActionContext.getContext().put("itemCatList", itemCatList);
        ActionContext.getContext().put("item", item);
          return "success";
      }
     
     /**
      * 修改商品
      * @return
      */
     public String itemUpdate()throws Exception{
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
         item.setImage("\\upload\\"+fileFileName);
         }else{
             Item  i =itemService.itemDetail(item.getId());
             item.setImage(i.getImage());
         }
         itemService.update(item);
         String content="修改商品";
         HttpSession session =ServletActionContext.getRequest().getSession();
         int userId = Integer.parseInt( session.getAttribute("userId").toString());
         //插入日志
         logService.addLog(content,userId);
         ActionContext.getContext().put("url", "/item_itemList.do");
        return "redirect";
     }
     
     
     //前端页面点击商品的页面
     public String itemIndex(){
      Pager<Item> pagers = itemService.queryItems(itemCatId);
      ActionContext.getContext().put("pagers", pagers);
 	 return SUCCESS;
     }
}
