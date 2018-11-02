package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.SystemBasicFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface SystemBasicMapper extends BaseMapper{

	public List<String> selecttype();

	public List<String> selectinfo();
	
}
