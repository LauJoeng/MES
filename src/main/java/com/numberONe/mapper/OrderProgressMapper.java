package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.numberONe.entity.MateriaModeForMap;
import com.numberONe.entity.processData.*;

import com.numberONe.entity.OrderProgress;
import com.numberONe.entity.ProcessCyFormMap;
import com.numberONe.entity.ProcessELFormMap;






/**
 * ���ݣ�������ţ�������룩��ѯ
 * @author Administrator
 *
 */
public interface OrderProgressMapper {
	List<OrderProgress> getOrderProgressInfo(@Param("orderno")String orderno,@Param("module_code")String module_code);
	/*List<OrderProgress> getOrderProgressInfo(String orderno,String module_code);*/
	List<ProcessCyFormMap>selectProcessCy(@Param("equipCode")String equipCode,@Param("begintime")String begintime,@Param("endtime")String endtime);
	List<ProcessELFormMap>selectProcessEL1(@Param("order_no")String order_no,@Param("begintime")String begintime,@Param("endtime")String endtime);
	List<ProcessELFormMap>selectProcessEL3(@Param("order_no")String order_no,@Param("begintime")String begintime,@Param("endtime")String endtime);

	
	List<MateriaModeForMap>selectMaterialMode(@Param("module_code")String module_code,@Param("order_no")String order_no);

	//组件详细信息查询
	List<ComponentDetails>selectComponentDetails(@Param("module_code")String module_code,@Param("order_no")String order_no);
	
	//删除数据查询
	List<CellDataHis>selectProcessHis_Cell(@Param("module_code")String module_code);
	List<CyDataHis>selectProcessHis_Cy(@Param("module_code")String module_code);
	List<El1DataHis>selectProcessHis_El1(@Param("module_code")String module_code);
	List<FqcDataHis>selectProcessHis_Fqc(@Param("module_code")String module_code);
	List<FrameDataHis>selectProcessHis_Frame(@Param("module_code")String module_code);	
	List<FtDataHis>selectProcessHis_Ft(@Param("module_code")String module_code);
	List<LayingDataHis>selectProcessHis_Laying(@Param("module_code")String module_code);
	List<PkgInfoDataHis>selectProcessHis_Pkg(@Param("module_code")String module_code);
	List<El3DataHis>selectProcessHis_El3(@Param("module_code")String module_code);
	List<Cuttingdatahis>selectProcessHis_Cutting(@Param("module_code")String module_code);
}
