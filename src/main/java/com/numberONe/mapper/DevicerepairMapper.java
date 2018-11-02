package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.numberONe.entity.DeviceRepairFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface DevicerepairMapper extends BaseMapper{
	//报修列表数据
	List<DeviceRepairFormMap> findDevicePage(DeviceRepairFormMap devicerepairFormMap);
	//状态为0的所有设备的编号
	DeviceRepairFormMap selectDnumber(@Param("dnumber")String dnumber);
	
	//待维修列表数据
	List<DeviceRepairFormMap> findWaitRepairPage(DeviceRepairFormMap devicerepairFormMap);
	//维修记录数据
	List<DeviceRepairFormMap> findRpRecordPage(DeviceRepairFormMap devicerepairFormMap);
	//报修单号
	String rp_number();
	//删除
	void delete(String string, @Param("id")String id, Class<DeviceRepairFormMap> class1);


}
