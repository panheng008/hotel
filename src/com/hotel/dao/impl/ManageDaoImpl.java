package com.hotel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.ManageDao;
import com.hotel.model.Manage;
import com.hotel.utils.Pager;
@Repository("manageDao")
@SuppressWarnings("unchecked")
public class ManageDaoImpl extends BaseDaoImpl<Manage>  implements ManageDao{

	@Override
	public Manage login(Manage manage) {
		String hql = "from Manage bean where bean.name =:userName and bean.passWord= :passWord";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("userName", manage.getName());
		q.setParameter("passWord", manage.getPassWord());
		return (Manage)q.uniqueResult();
	}

	 @Override
	    public Pager<Manage> listAll() {
	        String hql = "from Manage  where 1=1 order by createTime desc";
	        Map<String,Object> alias = new HashMap<String,Object>();
	        return findByAlias(hql, null);
	    }

    @Override
    public Manage manageDetail(int manageId) {
        String hql = "from Manage bean where bean.id=:manageId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("manageId", manageId);
        return (Manage) q.uniqueResult();
    }
    
    @Override
    public List<Manage> list() {
        String hql = "from Manage  where 1=1 order by createTime desc";
        Map<String,Object> alias = new HashMap<String,Object>();
        return listByAlias(hql, null);
    }

}
