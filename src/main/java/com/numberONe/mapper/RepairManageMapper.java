package com.numberONe.mapper;

import java.util.List;

import com.numberONe.entity.RepairPlanFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface RepairManageMapper extends BaseMapper{

	public List<RepairPlanFormMap> findRepairPlanPage(RepairPlanFormMap repairPlanFormMap);
	
}
