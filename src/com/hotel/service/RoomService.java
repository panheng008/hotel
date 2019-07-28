package com.hotel.service;

import com.hotel.model.Room;
import com.hotel.utils.Pager;

public interface RoomService {

    
    Pager<Room> listAll();

    void add(Room room);

    void delRoom(int roomId);

    Room roomDetail(int roomId);
    
    void update(Room room);

    Pager<Room> listAllChangeRoom();

	Pager<Room> queryRooms(int roomCatId);

	Room load(int roomId);

}
