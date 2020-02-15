package com.springboot.demo.base.service;

import com.springboot.demo.base.entity.SysRole;
import com.springboot.demo.base.entity.UserInfo;

import java.util.List;

public interface SysRoleService {
	
	
    public UserInfo findById(int id);
    
/*	Page<SysRole> findByRole(String role, Pageable pageable);

	Page<SysRole> findAll(Pageable pageable);*/
	
	public int updateState(boolean available, String id);
	
	public int updateRole(SysRole sr);
	
	SysRole save(SysRole sr);
	    
    
    public SysRole findByOne(String id);
    
    List<SysRole> findAll();

}