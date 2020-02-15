package com.springboot.demo.base.service.impl;

import com.springboot.demo.base.dao.SysRoleDao;
import com.springboot.demo.base.entity.SysRole;
import com.springboot.demo.base.entity.UserInfo;
import com.springboot.demo.base.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SysRoleServiceImpl implements SysRoleService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());  
    @Autowired
    private SysRoleDao sysRoleDao;


	@Override
	public UserInfo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
/*	@Override
	public Page<SysRole> findByRole(String role, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;//sysRoleDao.findByRole(role, pageable);
	}
	@Override
	public Page<SysRole> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;//sysRoleDao.findAll(pageable);
	}*/

	@Override
     @Transactional
	public int updateState(boolean available, String uid) {
		// TODO Auto-generated method stub
		System.out.print("hhhe--------------"+uid);
		int id = Integer.parseInt(uid);
		SysRole sr = sysRoleDao.selectByPrimaryKey(id);
		sysRoleDao.delete(sr);
		return 1;
	}
	@Override
	public SysRole save(SysRole sr) {
		
		return null;//sysRoleDao.save(sr);
	}
	@Override
	public int updateRole(SysRole sr) {
		// TODO Auto-generated method stub
		String description = sr.getDescription();
		String role = sr.getRole();
		String id = sr.getId()+"";
		return sysRoleDao.updateByPrimaryKeySelective(sr);
	}
	@Override
	public SysRole findByOne(String id) {
		int uid = Integer.parseInt(id);
		return sysRoleDao.selectByPrimaryKey(uid);
	}
	@Override
	public List<SysRole> findAll() {
		// TODO Auto-generated method stub
		/*Example example = new Example(SysRole.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo(new SysRole());*/
		return sysRoleDao.selectAll();
	}
}