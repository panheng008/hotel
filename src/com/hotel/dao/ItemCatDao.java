package com.hotel.dao;

import java.util.List;

import com.hotel.base.dao.BaseDao;
import com.hotel.model.Item_cat;
import com.hotel.utils.Pager;

public interface ItemCatDao extends BaseDao<Item_cat>{

	Pager<Item_cat> listAll();

	Item_cat load(int itemCatId);

	Item_cat itemCatDetail(int itemCatId);

    List<Item_cat> list();

	
}
