package com.numberONe.mapper;

import com.numberONe.entity.DeviceInspectRecordFormMap;
import com.numberONe.mapper.base.BaseMapper;

import java.util.List;

public interface DeviceInspectRecordMapper extends BaseMapper {

    List<DeviceInspectRecordFormMap> findDeviceInspectRecordPage(DeviceInspectRecordFormMap deviceInspectRecordFormMap);
}
