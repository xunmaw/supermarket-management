<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">

    </script>
</head>
<body>
<div class="page-bar">
    <ul class="page-num-ul clearfix">
        <li>共${pageinfo.total}条记录&nbsp;&nbsp; ${pageinfo.pageNum }/${pageinfo.pages }页</li>
        <div>
            <c:if test="${param.currentPageNo > 1}">
                <a href="${pageContext.request.contextPath}/bill.do?pn=1&method=query">首页</a>
                <a href="${pageContext.request.contextPath}/bill.do?pn=${pageinfo.getPrePage()}&method=query">上一页</a>
            </c:if>
            <c:if test="${param.currentPageNo < param.totalPageCount }">
                <a href="${pageContext.request.contextPath}/bill.do?pn=${pageinfo.getNextPage()}&method=query">下一页</a>
                <a href="${pageContext.request.contextPath}/bill.do?pn=${pageinfo.pages}&method=query">最后一页</a>
            </c:if>
        </div>

        &nbsp;&nbsp;
    </ul>
    <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(${pageinfo.pages},document.getElementById("inputPage").value,"/bill.do?method=query")'>GO</button>
	</span>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/rollpage2.js"></script>
</html>



