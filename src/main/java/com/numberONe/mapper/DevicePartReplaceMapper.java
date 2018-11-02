package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.DeviceRepairDetailFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface DevicePartReplaceMapper extends BaseMapper{

	public List<DeviceRepairDetailFormMap> findPartReplacePage(DeviceRepairDetailFormMap deviceRepairDetailFormMap);	
}
