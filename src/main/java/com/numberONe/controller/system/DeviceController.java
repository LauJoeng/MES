package com.numberONe.controller.system;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.numberONe.mapper.DeviceMapper;
import com.numberONe.mapper.base.BaseMapper;
import com.numberONe.controller.index.BaseController;
import com.numberONe.entity.DeviceFormMap;
import com.numberONe.plugin.PageView;
import com.numberONe.util.Common;
import com.numberONe.util.FTPUtil;
import com.numberONe.util.JsonUtils;
import com.numberONe.util.POIUtils;

/**
 * 
 * @author numberONe 2014-11-19
 * @version 3.0v
 */
@Controller
@RequestMapping("/device/")
public class DeviceController extends BaseController {
	@Inject
	private DeviceMapper deviceMapper;
	
	@ResponseBody
	@RequestMapping("findByPage")
	public PageView findByPage( String pageNow,
			String pageSize,String column,String sort) throws Exception {
		DeviceFormMap deviceFormMap = getFormMap(DeviceFormMap.class);
		deviceFormMap=toFormMap(deviceFormMap, pageNow, pageSize,deviceFormMap.getStr("orderby"));
		deviceFormMap.put("column", column);
		deviceFormMap.put("sort", sort);
        pageView.setRecords(deviceMapper.findDevicePage(deviceFormMap));//不调用默认分页,调用自已的mapper中findDevicePage
        return pageView;
	}
	
	@RequestMapping("/export")
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "设备列表";
		DeviceFormMap deviceFormMap = findHasHMap(DeviceFormMap.class);
		//exportData = 
		// [{"colkey":"sql_info","name":"SQL语句","hide":false},
		// {"colkey":"total_time","name":"总响应时长","hide":false},
		// {"colkey":"avg_time","name":"平均响应时长","hide":false},
		// {"colkey":"record_time","name":"记录时间","hide":false},
		// {"colkey":"call_count","name":"请求次数","hide":false}
		// ]
		String exportData = deviceFormMap.getStr("exportData");// 列表头的json字符串

		List<Map<String, Object>> listMap = JsonUtils.parseJSONList(exportData);

		List<DeviceFormMap> lis = deviceMapper.findDevicePage(deviceFormMap);
		POIUtils.exportToExcel(response, listMap, lis, fileName);
	}
	
	 /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @ResponseBody
    @RequestMapping("alldeptandtype")
	public Map<String,List<String>> seldeptandtype(Model model) throws Exception {
		    List<String> typelist  = deviceMapper.seltype();
		    List<String> deptlist  = deviceMapper.seldept();
		    Map<String,List<String>> map = new HashMap<String,List<String>>();
		    map.put("typelist", typelist);
		    map.put("deptlist", deptlist);
		    return map;
	}
      
}