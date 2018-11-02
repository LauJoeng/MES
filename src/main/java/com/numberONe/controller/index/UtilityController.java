package com.numberONe.controller.index;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.numberONe.plugin.PageView;

public class UtilityController extends BaseController {
	
	public   PageView burstView(String pageNow,String pageSize,List<?> t) {
		pageView=getPageView(pageNow,pageSize,"order_no");
		Integer startpage=(pageView.getPageNow()-1)*pageView.getPageSize();
		Integer endpage=pageView.getPageSize()+ (pageView.getPageNow()-1)*pageView.getPageSize();
		if(endpage>=t.size()) {
			endpage=t.size();
		}
		pageView.setQueryResult(t.size(), t.subList(startpage,endpage));
		return pageView;
	}
	//将对象转换成MAP
	public static Map<String, Object> ConvertObjToMap(Object obj) {  
        Map<String, Object> reMap = new HashMap<String, Object>();  
        if (obj == null)  
            return null;  
        Field[] fields = obj.getClass().getDeclaredFields();  
        try {  
            for (int i = 0; i < fields.length; i++) {  
                try {  
                    Field f = obj.getClass().getDeclaredField(  
                            fields[i].getName());  
                    f.setAccessible(true);
                    Object o = f.get(obj);  
                    reMap.put(fields[i].getName(), o);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        } catch (SecurityException e) {  
            e.printStackTrace();  
        }  
        return reMap;  
    } 

}
