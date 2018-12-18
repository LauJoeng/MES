package com.numberONe.mapper.mapper2;

import com.numberONe.entity.ItemStorage;
import com.numberONe.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeviceStorageMapper extends BaseMapper {
    public List<ItemStorage> itemStorageSelect(@Param("pageSize")Integer pageSize,
                                               @Param("pageIndex") Integer pageIndex,
                                               @Param("numIs")String numIs,
                                               @Param("itemid")String itemid,
                                               @Param("pState")String pState,
                                               @Param("itemBatch")String itemBatch,
                                               @Param("provID")String provID,
                                               @Param("wareHouse")String wareHouse,
                                               @Param("luHao")String luHao);
    public Integer selectCount();
//    public List<ItemStorage> itemStorageSelect(Map<String,String>map,@Param("pageSize") Integer pageSize,@Param("pageIndex") Integer pageIndex);
}
