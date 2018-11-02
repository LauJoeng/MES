package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.ConsumableFormMap;
import com.numberONe.entity.DeviceFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface ConsumableMapper extends BaseMapper{

	List<ConsumableFormMap> findConsumablePage(ConsumableFormMap consumableFormMap);
	int findIdByCname(@Param("cname")String cname);
	//删除
	void delete(String string, @Param("id")String id, Class<ConsumableFormMap> class1);
}
