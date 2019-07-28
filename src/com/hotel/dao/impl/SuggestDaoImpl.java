package com.hotel.dao.impl;
import org.springframework.stereotype.Repository;

import com.hotel.base.dao.impl.BaseDaoImpl;
import com.hotel.dao.SuggestDao;
import com.hotel.model.Suggest;

@Repository("suggestDao")
@SuppressWarnings("unchecked")
public  class SuggestDaoImpl  extends BaseDaoImpl<Suggest>  implements SuggestDao{
	
		
}
