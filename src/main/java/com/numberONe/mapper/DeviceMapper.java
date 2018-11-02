package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.DeviceFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface DeviceMapper extends BaseMapper{

	public List<DeviceFormMap> findDevicePage(DeviceFormMap deviceFormMap);	
	public List<String> seltype();
	public List<String> seldept();
}
