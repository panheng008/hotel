package com.hotel.service;

import com.hotel.model.Log;
import com.hotel.utils.Pager;

public interface LogService {

    void addLog(String content, int userId);

    Pager<Log> listAll();

    void delLog(int logId);

    void add(Log log);

    void update(Log log);
    
    Log logDetail(int logId);
    


}
