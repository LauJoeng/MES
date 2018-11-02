package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.MaintainRecordFormMap;
import com.numberONe.mapper.base.BaseMapper;

public interface MaintainRecordMapper extends BaseMapper{

	List<MaintainRecordFormMap> findMaintainRecordPage(MaintainRecordFormMap maintainRecordFormMap);
	int findIdByMaintainid(@Param("maintainid")String maintainid);
}
