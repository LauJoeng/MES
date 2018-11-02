package com.numberONe.mapper.mapper2;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.OrderSumMoney;

public interface OrderSumMoneyMapper {
	public List<OrderSumMoney> orderSumMoney(@Param("starttime")String starttime,@Param("endtime")String endtime);
}
