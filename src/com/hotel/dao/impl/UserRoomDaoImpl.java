package com.hotel.dao.impl;

import org.springframework.stereotype.Repository;

import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.UserRoomDao;
import com.hotel.model.UserRoom;


@Repository("userRoomDao")
@SuppressWarnings("unchecked")
public class UserRoomDaoImpl extends BaseDaoImpl<UserRoom>  implements UserRoomDao{


    
}
