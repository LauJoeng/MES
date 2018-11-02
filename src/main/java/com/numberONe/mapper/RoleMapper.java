package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.RoleFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface RoleMapper extends BaseMapper{
	public List<RoleFormMap> seletUserRole(RoleFormMap map);
	
	public void deleteById(RoleFormMap map);
}
