package com.hotel.dao;

import com.hotel.base.dao.BaseDao;
import com.hotel.model.Log;
import com.hotel.utils.Pager;


public interface LogDao extends BaseDao<Log>{

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @return
     */
    Pager<Log> listAll();

    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param logId
     * @return
     */
    Log logDetail(int logId);



}
