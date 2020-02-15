package com.springboot.demo.base.service;

import com.springboot.demo.base.entity.SysPermission;
import com.springboot.demo.base.entity.SysPermissionVo;

import java.util.List;

public interface SysPermissionService {
	
	
	public SysPermission findById(int id);
	    
	public List<SysPermissionVo> findAll();
	
	
	SysPermission save(SysPermission sp);
	
	int updatePermission(SysPermission sp);
	
	
	SysPermission findByOne(String id);
	
	int delete(String id);
}