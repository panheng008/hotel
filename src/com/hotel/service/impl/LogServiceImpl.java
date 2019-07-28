package com.hotel.service.impl;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.dao.LogDao;
import com.hotel.dao.ManageDao;
import com.hotel.model.Log;
import com.hotel.model.Manage;
import com.hotel.model.Room;
import com.hotel.service.LogService;
import com.hotel.utils.Pager;

@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;
    @Autowired
    private ManageDao manageDao;


    @Override
    public void addLog(String content, int userId) {
        Manage m  =manageDao.load(userId);
        Log log =new Log();
        log.setManageUser(m);
        log.setCreateTime(new Date());
        log.setContent(content);
        logDao.add(log);
        
    }


    @Override
    public Pager<Log> listAll() {
        // TODO Auto-generated method stub
        return logDao.listAll();
    }


    @Override
    public void delLog(int logId) {
        // TODO Auto-generated method stub
        logDao.delete(logId);
    }

    @Override
    public void add(Log log) {
        log.setCreateTime(new Date());
        logDao.add(log);
    }

    @Override
    public void update(Log log) {
        Log l=logDao.load(log.getId());
        l.setContent(log.getContent());
        l.setCreateTime(new Date());
        l.setManageUser(log.getManageUser());
        logDao.update(l);
    }

    @Override
    public Log logDetail(int logId) {
        // TODO Auto-generated method stub
        return logDao.logDetail(logId);
    }

 }
