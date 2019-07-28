package com.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.ItemCatDao;
import com.hotel.dao.ItemDao;
import com.hotel.model.Item;
import com.hotel.model.Item_cat;
import com.hotel.model.Manage;
import com.hotel.model.Room;
import com.hotel.service.ItemCatService;
import com.hotel.service.ItemService;
import com.hotel.utils.Pager;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
   private ItemDao  itemDao;
    @Override 
    public Pager<Item> listAll() {
        // TODO Auto-generated method stub
        return itemDao.listAll();
    }
    
    @Override
    public void add(Item item) {
        // TODO Auto-generated method stub
        itemDao.add(item);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ItemService#delItem(int)
     */
    @Override
    public void delItem(int itemId) {
        // TODO Auto-generated method stub
        itemDao.delete(itemId);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ItemService#itemDetail(int)
     */
    @Override
    public Item itemDetail(int itemId) {
        // TODO Auto-generated method stub
        return itemDao.itemDetail(itemId);
    }

    @Override
    public void update(Item item) {
      Item  i= itemDao.load(item.getId());
        i.setImage(item.getImage());
        i.setItemName(item.getItemName());
        i.setRemark(item.getRemark());
        i.setItem_cat(item.getItem_cat());
        itemDao.update(i);
    }

	@Override
	public Pager<Item> queryItems(int itemCatId) {
		// TODO Auto-generated method stub
		return itemDao.queryItems(itemCatId);
	}

	@Override
	public Item load(int itemId) {
		// TODO Auto-generated method stub
		return itemDao.load(itemId);
	}


}
