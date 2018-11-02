package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.RepairPlanFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface DevicemaintenanceMapper extends BaseMapper{

	List<RepairPlanFormMap> findDevicemaintenancePage(RepairPlanFormMap deviceFormMap);

}
