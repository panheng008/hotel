/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.hotel.dao.impl
 *
 *    Filename:    BookDaoImpl.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     xuxiang
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年10月13日 下午7:51:47
 *
 *    Revision:
 *
 *    2016年10月13日 下午7:51:47
 *        - first revision
 *
 *****************************************************************/package com.hotel.dao.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.BookDao;
import com.hotel.model.Book;
import com.hotel.utils.Pager;


@Repository("bookDao")
@SuppressWarnings("unchecked")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

    @Override
    public Pager<Book> listAll() {
        String hql = "from Book bean where bean.status=1 ";
        return  findByAlias(hql, null);
    }

    @Override
    public Book bookDetail(int bookId) {
        String hql = "from Book bean where bean.id=:bookId";
        Query q =this.getSession().createQuery(hql);
        q.setParameter("bookId", bookId);
        return (Book) q.uniqueResult();
    }

    @Override
    public Pager<Book> listAllLive() {
        String hql = "from Book bean where bean.status=2 ";
        return  findByAlias(hql, null);
    }

    
}
