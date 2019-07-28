package com.hotel.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="t_book")
public class Book {
    
	private int id;
	private Room room;//预定房间
	private int roomNumber;//预定房间数量 
	private Date reachTime;//到达时间
	private Date leaveTime;//离开时间
	private int status;//预定状态  1：已经预定 2：已入住
	private User bookUser;//预定人
	private Date bookTime;//预定时间
    
	@Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name="room_id")
    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public Date getReachTime() {
        return reachTime;
    }
    
    public void setReachTime(Date reachTime) {
        this.reachTime = reachTime;
    }
    
    public Date getLeaveTime() {
        return leaveTime;
    }
    
    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    @ManyToOne
    @JoinColumn(name="user_id")
    public User getBookUser() {
        return bookUser;
    }
    
    public void setBookUser(User bookUser) {
        this.bookUser = bookUser;
    }
    
    public Date getBookTime() {
        return bookTime;
    }
    
    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }
	
	
}
