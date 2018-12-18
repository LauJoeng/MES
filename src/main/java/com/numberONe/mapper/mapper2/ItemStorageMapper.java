package com.numberONe.mapper.mapper2;

import com.numberONe.entity.ItemStorageTBFormMap;
import com.numberONe.mapper.base.BaseMapper;

import java.util.List;

public interface ItemStorageMapper extends BaseMapper {
    List<ItemStorageTBFormMap> findAll();
}
