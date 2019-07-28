package com.hotel.dao;

import com.hotel.base.dao.BaseDao;
import com.hotel.model.Manage;
import com.hotel.model.Room;
import com.hotel.utils.Pager;


public interface RoomDao extends BaseDao<Room>{

    Pager<Room> listAll();

    Room roomDetail(int roomId);
    
    Pager<Room> listAllChangeRoom();

	Pager<Room> queryRooms(int roomCatId);


}
