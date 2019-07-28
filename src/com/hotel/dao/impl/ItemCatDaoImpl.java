package com.hotel.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.ItemCatDao;
import com.hotel.model.Item_cat;
import com.hotel.model.Manage;
import com.hotel.utils.Pager;

@Repository("itemCatDao")
@SuppressWarnings("unchecked")
public class ItemCatDaoImpl  extends BaseDaoImpl<Item_cat> implements ItemCatDao {

	@Override
	public Pager<Item_cat> listAll() {
		String hql = "from Item_cat ";
        return  findByAlias(hql, null);
	}

	@Override
	public Item_cat itemCatDetail(int itemCatId) {
	 String hql = "from Item_cat bean where bean.cid=:itemCatId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("itemCatId", itemCatId);
        return (Item_cat) q.uniqueResult();
	}

    @Override
    public List<Item_cat> list() {
        String hql = "from Item_cat ";
        return  listByAlias(hql, null);
    }


	
}
