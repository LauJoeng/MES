package com.numberONe.mapper;

import com.numberONe.entity.DeviceWaitInspect;
import com.numberONe.entity.DeviceWaitInspectFormMap;
import com.numberONe.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceWaitInspectMapper extends BaseMapper {
    public List<DeviceWaitInspectFormMap>selectByPlanIdAndCycle(@Param("planId") Integer planId, @Param("cycle") Integer cycle);
    public void insertOneRecord(DeviceWaitInspectFormMap deviceWaitInspect);

    List<DeviceWaitInspectFormMap> findDeviceWaitInspectPage(DeviceWaitInspectFormMap deviceWaitInspectFormMap);

    void updateRecord(DeviceWaitInspectFormMap deviceWaitInspectFormMap);
}
