package com.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.dao.SuggestDao;
import com.hotel.model.Suggest;
import com.hotel.service.SuggestService;

@Service("suggestService")
public class SuggestServiceImpl implements SuggestService {

    @Autowired
    private SuggestDao  suggestDao;
    @Override
    public void add(Suggest suggest) {
        // TODO Auto-generated method stub
        suggestDao.add(suggest);
    }
    
}
