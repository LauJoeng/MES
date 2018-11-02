package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.DeviceRepairFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface AuditMapper extends BaseMapper{

	List<DeviceRepairFormMap> findAuditPage(DeviceRepairFormMap devicerepairFormMap);
	
	//根据单号查询confirm_status状态是否为1
	int confirm_status(@Param("rp_number")String rp_number);
	//把confirm_status状态更新为等于2,给confirmTime更新一个最新的当前时间 ,把reporttime和confirmTime时间差插入repairtime
	int through(@Param("rp_number")String rp_number);
	//2,把confirm_status状态更新为等于0,repairnum+1,给confirmTime更新一个最新的当前时间 ,把reporttime和confirmTime时间差插入repairtime
	int back(@Param("rp_number")String rp_number);

}
