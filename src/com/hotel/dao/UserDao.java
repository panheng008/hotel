package com.hotel.dao;

import java.util.List;

import com.hotel.base.dao.BaseDao;
import com.hotel.model.User;
import com.hotel.utils.Pager;

public interface UserDao extends BaseDao<User>{
    public User load(User user);
	public List<User> listAllCanSendUser(int userId);
	User add(User t);
	public List<User> findFriend(String userName);
	public List<User> loadTuiJian(User you);
	public User get(int userId);

	
	 /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    Pager<User> listAll();

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param userId
     * @return
     */
    User userDetail(int userId);
    
	public User query(String userName);
}
