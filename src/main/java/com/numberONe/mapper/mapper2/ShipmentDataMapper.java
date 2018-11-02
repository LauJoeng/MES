package com.numberONe.mapper.mapper2;

import java.util.List;
import java.util.Map;


import com.numberONe.entity.ShipmentStatistics;
import com.numberONe.mapper.base.BaseMapper;



public interface ShipmentDataMapper extends BaseMapper {

	public List<ShipmentStatistics>selectShipmentModule(Map map);
	public List<ShipmentStatistics>selectShipmentBattery(Map map);
}
