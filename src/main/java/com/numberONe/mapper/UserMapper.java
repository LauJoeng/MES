package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.UserFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface UserMapper extends BaseMapper{

	public List<UserFormMap> findUserPage(UserFormMap userFormMap);
	public List<String> findRpMan();
	
}
