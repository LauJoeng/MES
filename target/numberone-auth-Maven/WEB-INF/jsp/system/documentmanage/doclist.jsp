<!-- 文档管理 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/documentmanage/doclist.js"></script>
<div class="m-b-md">
    <form class="form-inline" role="form" id="searchForm"
          name="searchForm">
        <div class="form-group">
            <label class="control-label"> <span
                    class="h4 font-thin v-middle">设备编号:</span></label> <input
                class="input-medium ui-autocomplete-input" id="dnumber"
                name="DocumentFormMap.dnumber">
            &nbsp;&nbsp;&nbsp;&nbsp;<span
                class="h4 font-thin v-middle">设备名称:&nbsp;</span><input
                class="input-medium ui-autocomplete-input" id="dname"
                name="DocumentFormMap.dname">
            &nbsp;&nbsp;&nbsp;&nbsp;<span class="h4 font-thin v-middle">文档类型:&nbsp;</span><select id="filetype"
                                                                                                  style="width:150px;height:28px;"
                                                                                                  name="documentFormMap.filetype">
            <option value="" selected="selected">全部文档</option>
            <option value="采购类文档">采购类文档</option>
            <option value="操作手册类">操作手册类</option>
        </select>

        </div>

        &nbsp;&nbsp;<a href="javascript:void(0)" class="btn btn-default" id="search">查询</a>
    </form>
</div>
<header class="panel-heading">
    <div class="doc-buttons">
        <c:forEach items="${res}" var="key">
            ${key.description}
        </c:forEach>
        <form action="${pageContext.request.contextPath}/document/download.shtml" method="post" style="display: none" id="downloadform">
            <input type="hidden" name="fileName" id="fileNameInput"/>
            <input type="hidden" name="id" id="idInput"/>
            <input type="submit" value="下载">
        </form>
    </div>
</header>
<div class="table-responsive">
    <div id="paging" class="pagclass"></div>
</div>

<div class="table-responsive">
    <div id="paging2" class="pagclass"></div>
</div>

