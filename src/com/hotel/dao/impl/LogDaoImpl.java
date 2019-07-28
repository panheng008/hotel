package com.hotel.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.LogDao;
import com.hotel.model.Log;
import com.hotel.model.Manage;
import com.hotel.utils.Pager;

@Repository("logDao")
@SuppressWarnings("unchecked")
public class LogDaoImpl extends BaseDaoImpl<Log> implements LogDao {

    @Override
    public Pager<Log> listAll() {
        String hql = "from Log  where 1=1 order by createTime desc";
        Map<String,Object> alias = new HashMap<String,Object>();
        return findByAlias(hql, null);
    }

    @Override
    public Log logDetail(int logId) {
        String hql = "from Log bean where bean.id=:logId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("logId", logId);
        return (Log) q.uniqueResult();
    }

  


    
}
