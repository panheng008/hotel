package com.hotel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.dao.RoomCatDao;
import com.hotel.model.Room_cat;
import com.hotel.service.RoomCatService;
import com.hotel.utils.Pager;


@Service("roomCatService")
public class RoomCatServiceImpl implements RoomCatService {

    @Autowired
    private RoomCatDao roomCatDao;
    @Override
    public Pager<Room_cat> listAll() {
        // TODO Auto-generated method stub
        return roomCatDao.listAll();
    }
    
    @Override
    public List<Room_cat> list() {
        // TODO Auto-generated method stub
        return roomCatDao.list();
    }

    @Override
    public void add(Room_cat room_cat) {
        // TODO Auto-generated method stub
        roomCatDao.add(room_cat);
    }

    
    @Override
    public Room_cat roomCatDetail(int roomCatId) {
        // TODO Auto-generated method stub
        return roomCatDao.roomCatDetail(roomCatId);
    }

    @Override
    public void update(Room_cat room_cat) {
      /*  Room_cat  r= roomCatDao.load(room_cat.getId());
        r.setImage(room_cat.getImage());
        r.setNum(room_cat.getNum());
        r.setPrice(room_cat.getPrice());
        r.setRoomCatName(room_cat.getRoomCatName());
        r.setType(room_cat.getType());*/
        roomCatDao.update(room_cat); 
    }

    @Override
    public Room_cat query(int type) {
        // TODO Auto-generated method stub
        return roomCatDao.query(type);
    }

    @Override
    public Room_cat load(int id) {
        // TODO Auto-generated method stub
        return roomCatDao.load(id);
    }

}
