package com.hotel.service;

import java.util.List;

import com.hotel.model.Room_cat;
import com.hotel.utils.Pager;

public interface RoomCatService {

    Pager<Room_cat> listAll();
    
    List<Room_cat> list();

    void add(Room_cat room_cat);

    Room_cat roomCatDetail(int roomCatId);

    void update(Room_cat room_cat);

    Room_cat query(int type);

    Room_cat load(int id);

    

}
