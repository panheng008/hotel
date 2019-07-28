package com.hotel.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.UserItemDao;
import com.hotel.model.UserItem;
import com.hotel.service.UserItemService;

@Service("userItemService")
public class UserItemServiceImpl implements UserItemService {
     @Autowired
     private UserItemDao userItemDao;

	@Override
	public void add(UserItem userItem) {
		// TODO Auto-generated method stub
		userItemDao.add(userItem);
	}






}
