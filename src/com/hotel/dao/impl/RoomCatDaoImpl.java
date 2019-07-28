package com.hotel.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.RoomCatDao;
import com.hotel.model.Room_cat;
import com.hotel.utils.Pager;


@Repository("roomCatDao")
@SuppressWarnings("unchecked")
public class RoomCatDaoImpl extends BaseDaoImpl<Room_cat> implements RoomCatDao {

    @Override
    public Pager<Room_cat> listAll() {
        String hql = "from Room_cat ";
        return  findByAlias(hql, null);
    }

    @Override
    public List<Room_cat> list() {
        String hql = "from Room_cat ";
        return  listByAlias(hql, null);

    }

    @Override
    public Room_cat roomCatDetail(int roomCatId) {
        String hql = "from Room_cat bean where bean.id=:roomCatId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("roomCatId", roomCatId);
        return (Room_cat) q.uniqueResult();
    }

    @Override
    public Room_cat query(int type) {
        String hql = "from Room_cat bean where bean.type=:type";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("type", type);
        return (Room_cat) q.uniqueResult();
    }


    
}
