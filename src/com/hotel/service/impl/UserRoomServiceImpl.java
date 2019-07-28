package com.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.UserRoomDao;
import com.hotel.model.UserRoom;
import com.hotel.service.UserRoomService;

@Service("userRoomService")
public class UserRoomServiceImpl implements UserRoomService {
     @Autowired
     private UserRoomDao userRoomDao;

	@Override
	public void add(UserRoom userRoom) {
		// TODO Auto-generated method stub
		userRoomDao.add(userRoom);
	}





}
