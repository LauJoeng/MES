package com.numberONe.mapper.mapper2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.ModuleGrossMargin;
import com.numberONe.entity.ModuleGrossMarginHis;
import com.numberONe.entity.SumModuleGrossMarginHis;
import com.numberONe.entity.MatertialBasicInfor;
import com.numberONe.entity.MatertialBasicInforHis;
import com.numberONe.mapper.base.BaseMapper;




public interface ModuleGrossMarginMapper  {

	public List<ModuleGrossMargin>selectModule(@Param("order_no")String order_no);
	public List<MatertialBasicInfor>selectModuleGrossMargin(ModuleGrossMargin moduleGrossMargin);
	
	/*public boolean updateModuleGrossMargin(ModuleGrossMargin moduleGrossMargin);
	public int insertModuleGrossMargin(ModuleGrossMargin moduleGrossMargin);
	
	public boolean  updateMatertialBasicInfor(MatertialBasicInfor matertialBasicInfor);
	public int  insertMatertialBasicInfor(MatertialBasicInfor matertialBasicInfor);
	
	public int  insertSumModuleGrossMarginHis(SumModuleGrossMarginHis sumModuleGrossMarginHis);
	public int  insertModuleGrossMarginHis(ModuleGrossMarginHis moduleGrossMarginHis);
	public int inserttMatertialBasicInforHis(MatertialBasicInforHis matertialBasicInforHis);*/

}
