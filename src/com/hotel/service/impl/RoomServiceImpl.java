package com.hotel.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.RoomDao;
import com.hotel.model.Room;
import com.hotel.service.RoomService;
import com.hotel.utils.Pager;


@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao  roomDao;
    @Override
    public Pager<Room> listAll() {
        // TODO Auto-generated method stub
        return roomDao.listAll();
    }
    
    @Override
    public void add(Room room) {
        // TODO Auto-generated method stub
        roomDao.add(room);
    }
    
    @Override
    public void delRoom(int roomId) {
        roomDao.delete(roomId);
    }

    @Override
    public Room roomDetail(int roomId) {
        // TODO Auto-generated method stub
        return roomDao.roomDetail(roomId);
    }

    @Override
    public void update(Room room) {
        Room  r= roomDao.load(room.getId());
        r.setFloor(room.getFloor());
        r.setImage(room.getImage());
        r.setIsLive(room.getIsLive());
        r.setRemark(room.getRemark());
        r.setRoom_cat(room.getRoom_cat());
        r.setRoomName(room.getRoomName());
        roomDao.update(r); 
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.RoomService#listAllChangeRoom()
     */
    @Override
    public Pager<Room> listAllChangeRoom() {
        // TODO Auto-generated method stub
        return roomDao.listAllChangeRoom();
    }

	@Override
	public Pager<Room> queryRooms(int roomCatId) {
		// TODO Auto-generated method stub
		return roomDao.queryRooms(roomCatId);
	}

	@Override
	public Room load(int roomId) {
		// TODO Auto-generated method stub
		return roomDao.load(roomId);
	}

}
