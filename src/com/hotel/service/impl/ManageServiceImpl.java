package com.hotel.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.dao.ManageDao;
import com.hotel.model.Manage;
import com.hotel.service.ManageService;
import com.hotel.utils.Pager;
@Service("manageService")
public class ManageServiceImpl implements ManageService {
     @Autowired
	 private ManageDao manageDao;
	@Override
	public Manage login(Manage manage) {
		// TODO Auto-generated method stub
		Manage m = new Manage();
		 m.setName(manage.getName());
		 m.setPassWord(manage.getPassWord());
		return manageDao.login(m);
	}
	
    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ManageService#listAll()
     */
    @Override
    public Pager<Manage> listAll() {
        // TODO Auto-generated method stub
        return manageDao.listAll();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ManageService#delManage(int)
     */
    @Override
    public void delManage(int manageId) {
       Manage m =manageDao.load(manageId);
        m.setIsDelete(1);
        manageDao.update(m);
        
    }

    @Override
    public Manage manageDetail(int manageId) {
        // TODO Auto-generated method stub
        return manageDao.manageDetail(manageId);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ManageService#add(com.hotel.model.Manage)
     */
    @Override
    public void add(Manage manage) {
        // TODO Auto-generated method stub
        manageDao.add(manage);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.hotel.service.ManageService#update(com.hotel.model.Manage)
     */
    @Override
    public void update(Manage manage) {
      Manage m= manageDao.load(manage.getId());
        m.setCreateTime(new Date());
        m.setEmail(manage.getEmail());
        m.setIdCard(m.getIdCard());
        m.setIsDelete(2);
        m.setName(manage.getName());
        m.setPassWord(manage.getPassWord());
        m.setPhone(manage.getPhone());
        m.setSex(manage.getSex());
        m.setType(manage.getType());
        manageDao.update(m); 
    }

    
    @Override
    public List<Manage> list() {
        // TODO Auto-generated method stub
        return manageDao.list();
    }
	

}
