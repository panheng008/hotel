package com.hotel.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.RoomDao;
import com.hotel.model.Manage;
import com.hotel.model.Room;
import com.hotel.utils.Pager;


@Repository("roomDao")
@SuppressWarnings("unchecked")
public class RoomDaoImpl extends BaseDaoImpl<Room> implements RoomDao {

  
    @Override
    public Pager<Room> listAll() {
        String hql = "from Room ";
        return  findByAlias(hql, null);
    }

    @Override
    public Room roomDetail(int roomId) {
        String hql = "from Room bean where bean.id=:roomId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("roomId", roomId);
        return (Room) q.uniqueResult();
    }

   
    @Override
    public Pager<Room> listAllChangeRoom() {
        String hql = "from Room bean where bean.isLive=2 ";
        Query q =this.getSession().createQuery(hql);
        return  findByAlias(hql, null);
    }

	@Override
	public Pager<Room> queryRooms(int roomCatId) {
		 String hql = "from Room bean where bean.isLive=1 and bean.room_cat.id = :roomCatId";
			Map<String,Object> alias = new HashMap<String,Object>();
			alias.put("roomCatId", roomCatId);
			return findByAlias(hql, alias);
	}


    
}
