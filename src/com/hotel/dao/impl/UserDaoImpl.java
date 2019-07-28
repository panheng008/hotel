package com.hotel.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.UserDao;
import com.hotel.model.User;
import com.hotel.utils.Pager;

@Repository("userDao")
@SuppressWarnings("unchecked")
public  class UserDaoImpl  extends BaseDaoImpl<User>  implements UserDao{
	
	@Override
	public User load(User user) {
		String hql = "from User bean where bean.userName =:userName and bean.passWord= :passWord and isDelete = 2";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("userName", user.getUserName());
		q.setParameter("passWord", user.getPassWord());
		return (User)q.uniqueResult();
	}
	
	@Override
    public List<User> listAllCanSendUser(int userId) {
        String hql = "from User";
        Query q =this.getSession().createQuery(hql);
        return q.list();
    }

	@Override
	public List<User> findFriend(String userName) {
		String hql = "from User bean where bean.userName =:userName";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("userName", userName);
		return q.list();
	}

//	public List<User> loadTuiJian(User you) {
//		String hql = "from User bean where (bean.userName =:userName) or (bean.address =:address) or (bean.interest =:interest)  or (bean.age =:age) and bean.id != :id and bean.isDelete = 2";
//		Query q =this.getSession().createQuery(hql);
//		q.setParameter("userName", you.getUserName());
//		q.setParameter("address", you.getAddress());
//		q.setParameter("interest", you.getInterest());
//		q.setParameter("age", you.getAge());
//		q.setParameter("id", you.getId());
//		return q.list();
//	}

	@Override
	public User get(int userId) {
		// TODO Auto-generated method stub
		return (User) this.getSession().get(User.class, userId);
	}

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.dao.UserDao#loadTuiJian(com.hotel.model.User)
     */
    @Override
    public List<User> loadTuiJian(User you) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.dao.UserDao#listAll()
     */
    @Override
    public Pager<User> listAll() {
        String hql = "from User where 1=1 order by createTime desc";
        Map<String,Object> alias = new HashMap<String,Object>();
        return findByAlias(hql, null);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.dao.UserDao#userDetail(int)
     */
    @Override
    public User userDetail(int userId) {
//        String hql = "from User bean where bean.id=:userId";
//        Map<String,Object> alias = new HashMap<String,Object>();
//        return  list(hql, null);
        String hql = "from User bean where bean.id=:userId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("userId", userId);
        return (User) q.uniqueResult();
    }

	@Override
	public User query(String userName) {
		String hql = "from User bean where bean.userName =:userName";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("userName", userName);
		return (User)q.uniqueResult();
	}
		
}
