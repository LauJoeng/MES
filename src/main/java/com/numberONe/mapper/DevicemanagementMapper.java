package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.DeviceFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface DevicemanagementMapper extends BaseMapper{

	public List<DeviceFormMap> findDevicePage(DeviceFormMap deviceFormMap);

	//工序
	public List<String> processName();
	//设备类别
	public List<String> seletype();
	//生产车间
	public List<String> workshop();
	//设备类型
	public List<String> seldept();
	//删除
	public void delete(String string, @Param("id")String id, Class<DeviceFormMap> class1);
	
}
