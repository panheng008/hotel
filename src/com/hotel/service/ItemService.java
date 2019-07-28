package com.hotel.service;

import com.hotel.model.Item;
import com.hotel.utils.Pager;

public interface ItemService {

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    Pager<Item> listAll();

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param item
     */
    void add(Item item);

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param itemId
     */
    void delItem(int itemId);

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param itemId
     * @return
     */
    Item itemDetail(int itemId);

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param item
     */
    void update(Item item);

	Pager<Item> queryItems(int itemCatId);

	Item load(int itemId);





}
