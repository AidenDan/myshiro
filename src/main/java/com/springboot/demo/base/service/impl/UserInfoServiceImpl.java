package com.springboot.demo.base.service.impl;

import com.springboot.demo.base.dao.UserInfoDao;
import com.springboot.demo.base.entity.UserInfo;
import com.springboot.demo.base.service.UserInfoService;
import com.springboot.demo.base.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
@Component
public class UserInfoServiceImpl implements UserInfoService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoDao userInfoDao;



    @Override
    public UserInfo findByUsername(String username) {
		Example example = new Example(UserInfo.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username", username);
        return userInfoDao.selectOneByExample(example);
    }

/*	@Override
	public Page<UserInfo> findByUserName(String username, Pageable pageable) {
		
		return null;//userInfoDao.findByUserName(username, pageable);
	}
	@Override
	public Page<UserInfo> findAll(Pageable pageable) {
		Page<UserInfo> uis = userInfoDao.findAll(pageable); 
		return null;//uis;
	}*/

	@Override
	public List<UserInfo> findAll() {
		return userInfoDao.selectAll();
	}

	@Override
	public UserInfo save(UserInfo ui) {
	  
		String pas = MD5Utils.encodePassword(ui.getPassword(), ui.getCredentialsSalt());
		ui.setPassword(pas);
		int i = userInfoDao.insertSelective(ui);
		return ui;
	}

	@Override
	public UserInfo saveUser(UserInfo ui) {
		int i = userInfoDao.insertSelective(ui);
		return ui;
	}

	@Override
	public int updateState(int state, String uid) {
		Date updateDate = new Date();
		UserInfo userInfo = new UserInfo();
		userInfo.setState(state);
		userInfo.setUid(Integer.valueOf(uid));
		return userInfoDao.updateByPrimaryKeySelective(userInfo);
	}
	
	@Override
	public void updateUserInfo(UserInfo ui) {
		userInfoDao.updateByPrimaryKeySelective(ui);
	}

	@Override
	public UserInfo findByOne(Integer uid) {
		return userInfoDao.selectByPrimaryKey(uid);
	}

	@Transactional
	@Override
	public int updatePassword(String password, Date updateDate, String uid) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(uid);
		UserInfo ui = userInfoDao.selectByPrimaryKey(id);
		String pas = MD5Utils.encodePassword(password, ui.getCredentialsSalt());
		UserInfo userInfo = new UserInfo();
		userInfo.setPassword(pas);
		userInfo.setUpdateDate(updateDate);
		userInfo.setUid(id);
		return userInfoDao.updateByPrimaryKeySelective(userInfo);
	}
	@Override
	public UserInfo saveRoleId(UserInfo ui) {
		// TODO Auto-generated method stub
		userInfoDao.insertSelective(ui);
		return ui;
	}


}