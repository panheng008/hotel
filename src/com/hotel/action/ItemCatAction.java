package com.hotel.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hotel.model.Item_cat;
import com.hotel.model.Room_cat;
import com.hotel.service.ItemCatService;
import com.hotel.service.LogService;
import com.hotel.utils.Pager;
import com.hotel.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("itemCatAction")
@Scope("prototype")
public class ItemCatAction extends ActionSupport implements ModelDriven<Item_cat>{
   private Item_cat item_cat;
   private int itemCatId;

   @Autowired
   private LogService logService;
   
    public int getItemCatId() {
	return itemCatId;
}

	public void setItemCatId(int itemCatId) {
		this.itemCatId = itemCatId;
	}

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

	@Override
	public Item_cat getModel() {
		if(item_cat==null) item_cat = new Item_cat();
		return item_cat;
	}
	@Autowired
	private ItemCatService itemCatService;
	
	/**
     * 获取类别信息列表
     * @return
     */
    public String itemCatList(){
      Pager<Item_cat> pagers = itemCatService.listAll();
    ActionContext.getContext().put("pagers", pagers);
    return SUCCESS;
    }
	
    /**
     * 删除商品类别信息
     * @return
     */
    public String delItemCat(){
    	itemCatService.delItemCat(itemCatId);
        ActionContext.getContext().put("url", "/itemCat_itemCatList.do");
        return "redirect";
    }
    
    /**
     * 新增商品类别页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String addItemCat() {
        return "success";
    }
    
    public String itemCatAdd() throws Exception{
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
        item_cat.setImage("\\upload\\"+fileFileName);
        itemCatService.add(item_cat);
        String content="新增商品类型";
        HttpSession session =ServletActionContext.getRequest().getSession();
        int userId = Integer.parseInt( session.getAttribute("userId").toString());
        //插入日志
        logService.addLog(content,userId);
        ActionContext.getContext().put("url", "/itemCat_itemCatList.do");
      return "redirect";
     }
    
    /**
     * 初始化修改页面
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public String updateItemCat(){
    	Item_cat item_cat =itemCatService.itemCatDetail(itemCatId);
        ActionContext.getContext().put("item_cat", item_cat);
         return "success";
     }
    
    /**
     * 修改商品类别
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     * @throws Exception 
     */
    public String ItemCatUpdate() throws Exception{
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
          item_cat.setImage("\\upload\\"+fileFileName);
          }else{
              Item_cat  i =itemCatService.itemCatDetail(item_cat.getCid());
              item_cat.setImage(i.getImage());
          }
          itemCatService.update(item_cat);
          String content="修改商品类型";
          HttpSession session =ServletActionContext.getRequest().getSession();
          int userId = Integer.parseInt( session.getAttribute("userId").toString());
          //插入日志
          logService.addLog(content,userId);
          ActionContext.getContext().put("url", "/itemCat_itemCatList.do");
          return "redirect";
     }
    
   
}