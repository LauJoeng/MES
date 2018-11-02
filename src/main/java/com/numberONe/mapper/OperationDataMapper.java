package com.numberONe.mapper;

import java.util.List;
import java.util.Map;

import com.numberONe.entity.OpModuleOperation;
import com.numberONe.entity.OperationDataFormMap;
import com.numberONe.mapper.base.BaseMapper;



public interface OperationDataMapper extends BaseMapper {
	
	public List<String> selectProcessName();
	public List<OperationDataFormMap>selectDataPage(OperationDataFormMap operationDataFormMap);
	public List<OpModuleOperation>selectOpModuleData(Map map);

}
