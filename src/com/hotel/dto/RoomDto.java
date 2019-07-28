package com.hotel.dto;

import java.util.Date;

import com.hotel.model.Room;


public class RoomDto extends Room {

     private String rName;
     
    
    public String getrName() {
        return rName;
    }

    
    public void setrName(String rName) {
        this.rName = rName;
    }


     
     
}
