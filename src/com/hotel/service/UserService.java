package com.hotel.service;

import com.hotel.model.User;
import com.hotel.utils.Pager;

public interface UserService {

    User load(User user);

    User add(User user);
    
    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    public Pager<User> listAll();

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param userId
     * @return 
     */
    public User userDetail(int userId);

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param userId
     * @return
     */
    User load(int userId);

	User query(String userName);
}
