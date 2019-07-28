package com.hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_room_cat")
public class Room_cat {
   
	private int id; 
	private String roomCatName;//类型名称
	private String image;//首页图片
	private double price;//价格
	private int type;//1代表 单人房 2 双人房
	private int num;//剩余数
	
	
	@Id
	@GeneratedValue
	 public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
	
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public int getNum() {
        return num;
    }
    
    public void setNum(int num) {
        this.num = num;
    }

    
    public String getRoomCatName() {
        return roomCatName;
    }

    
    public void setRoomCatName(String roomCatName) {
        this.roomCatName = roomCatName;
    }
   
	
	
	}
