package com.hotel.dao;

import java.util.List;

import com.hotel.base.dao.BaseDao;
import com.hotel.model.Manage;
import com.hotel.utils.Pager;

public interface ManageDao extends BaseDao<Manage>{

	Manage login(Manage manage);

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    Pager<Manage> listAll();

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param manageId
     * @return
     */
    Manage manageDetail(int manageId);

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    List<Manage> list();

}
