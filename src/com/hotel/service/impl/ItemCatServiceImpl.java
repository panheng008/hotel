package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.ItemCatDao;
import com.hotel.model.Item_cat;
import com.hotel.model.Manage;
import com.hotel.service.ItemCatService;
import com.hotel.utils.Pager;

@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ItemCatDao itemCatDao;
	
	@Override
	public Pager<Item_cat> listAll() {
		// TODO Auto-generated method stub
		return itemCatDao.listAll();
	}

	@Override
	public void delItemCat(int itemCatId) {
		//Item_cat i=itemCatDao.load(itemCatId);
	      itemCatDao.delete(itemCatId);
	}

	@Override
	public void add(Item_cat item_cat) {
		// TODO Auto-generated method stub
		itemCatDao.add(item_cat);
	}


	@Override
	public void update(Item_cat item_cat) {
		Item_cat i=itemCatDao.load(item_cat.getCid());
		i.setCname(item_cat.getCname());
		itemCatDao.update(i);
	}

	@Override
	public Item_cat itemCatDetail(int itemCatId) {
		// TODO Auto-generated method stub
		return itemCatDao.itemCatDetail(itemCatId);
	}

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ItemCatService#list()
     */
    @Override
    public List<Item_cat> list() {
        // TODO Auto-generated method stub
        return itemCatDao.list();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ItemCatService#load(int)
     */
    @Override
    public Item_cat load(int cid) {
        // TODO Auto-generated method stub
       return itemCatDao.load(cid);
    }

}
