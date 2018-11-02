package com.numberONe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.numberONe.entity.Document;
import com.numberONe.entity.DocumentFormMap;
import com.numberONe.mapper.base.BaseMapper;


public interface DocumentMapper extends BaseMapper{

	public List<DocumentFormMap> findDocumentPage(DocumentFormMap documentFormMap);
	//添加文档上传记录
	public int addDocEntity(Document document);
	public String selectFileUrlById(@Param("id")int id);
}
