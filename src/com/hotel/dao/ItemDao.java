package com.hotel.dao;

import com.hotel.base.dao.BaseDao;
import com.hotel.model.Item;
import com.hotel.model.Room;
import com.hotel.utils.Pager;

public interface ItemDao extends BaseDao<Item>{

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    Pager<Item> listAll();

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param itemId
     * @return
     */
    Item itemDetail(int itemId);

	Pager<Item> queryItems(int itemCatId);


	
}
