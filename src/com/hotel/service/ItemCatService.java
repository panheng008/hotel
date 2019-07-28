package com.hotel.service;

import java.util.List;

import com.hotel.model.Item_cat;
import com.hotel.utils.Pager;


public interface ItemCatService {

	Pager<Item_cat> listAll();

	void delItemCat(int itemCatId);

	void add(Item_cat item_cat);

	Item_cat itemCatDetail(int itemCatId);
	
	void update(Item_cat item_cat);

    List<Item_cat> list();

    Item_cat load(int cid);




}
