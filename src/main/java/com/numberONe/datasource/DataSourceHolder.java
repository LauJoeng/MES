package com.numberONe.datasource;
/**
 * 创建DynamicDataSourceHolder用于持有当前线程中使用的数据源标识


 * @author Administrator
 *
 */
public class DataSourceHolder {
	private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    public static void setDataSources(String dataSource) {
        dataSources.set(dataSource);
    }

    public static String getDataSources() {
        return dataSources.get();
    }

}
