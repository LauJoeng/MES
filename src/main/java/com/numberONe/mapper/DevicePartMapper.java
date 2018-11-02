package com.numberONe.mapper;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.DevicePartFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface DevicePartMapper extends BaseMapper{

	List<DevicePartFormMap> findDevicePartPage(DevicePartFormMap devicepartFormMap);
	int findIdByfno(@Param("fno")String fno);
	//
	void delete(String string, @Param("id")String id, @Param("delop")String delop, @Param("df")SimpleDateFormat df, Class<DevicePartFormMap> class1);
}
