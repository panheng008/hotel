package com.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.UserDao;
import com.hotel.model.User;
import com.hotel.service.UserService;
import com.hotel.utils.Pager;

@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userdao;
    
    @Override
    public User load(User user) {
        return userdao.load(user);
    }

    @Override
    public User add(User user) {
        // TODO Auto-generated method stub
        return userdao.add(user);
    }
	
    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.UserService#listAll()
     */
    @Override
    public Pager<User> listAll() {
        // TODO Auto-generated method stub
        return userdao.listAll();
    }


    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.UserService#userDetail(int)
     */
    @Override
    public User userDetail(int userId) {
        // TODO Auto-generated method stub
        return userdao.userDetail(userId);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.UserService#load(int)
     */
    @Override
    public User load(int userId) {
        // TODO Auto-generated method stub
        return userdao.load(userId);
    }

	@Override
	public User query(String userName) {
		// TODO Auto-generated method stub
		return userdao.query(userName);
	}
}
