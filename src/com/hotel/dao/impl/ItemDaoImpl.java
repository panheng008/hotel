package com.hotel.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.ItemDao;
import com.hotel.model.Item;
import com.hotel.model.Room;
import com.hotel.utils.Pager;

@Repository("itemDao")
@SuppressWarnings("unchecked")
public class ItemDaoImpl  extends BaseDaoImpl<Item> implements ItemDao {

    
    @Override
    public Pager<Item> listAll() {
        String hql = "from Item ";
        return  findByAlias(hql, null);
    }

    @Override
    public Item itemDetail(int itemId) {
        String hql = "from Item bean where bean.id=:itemId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("itemId", itemId);
        return (Item) q.uniqueResult();
    }

	@Override
	public Pager<Item> queryItems(int itemCatId) {
		 String hql = "from Item bean where bean.item_cat.cid=:itemCatId";
		 Map<String,Object> alias = new HashMap<String,Object>();
			alias.put("itemCatId", itemCatId);
			return findByAlias(hql, alias);
	        
	}



	
}
