package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.DeviceConsumDetailFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface DeviceConsumDetailMapper extends BaseMapper{

	public List<DeviceConsumDetailFormMap> findConsumDetailPage(DeviceConsumDetailFormMap deviceConsumDetailFormMap);	
}
