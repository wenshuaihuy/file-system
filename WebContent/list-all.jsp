<%--
  Created by IntelliJ IDEA.
  User: WSHu
  Date: 2020/12/17
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>查看所有文件数据</title>
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div style="width: 90%; text-align: right">
    <table align="right">
        <tr>
            <td>
                根据日期查询文件信息
            </td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/findByDate">
                    <input readonly type="text" name="date1" id=date1
                           onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'date2\');}'})"/>
                    至 <input readonly type="text" name="date2" id=date2
                             onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'date1\');}'})"/>

                    <input type="submit" value="查询">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                根据文件名查询文件信息
            </td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/findByFileName">
                    <input type="text" name="fileName" id=fileName/>
                    <input type="submit" value="查询">
                </form>
            </td>
        </tr>
        <tr>
            <td>


            <button style="size: 40px">
                <a style="text-decoration: none;color: black" href="${pageContext.request.contextPath}/list">返回主界面</a>
            </button>
            </td>
        </tr>
    </table>
</div>

<table align="center" border="1" cellpadding="0" cellspacing="0" width="80%">

    <tr align="center">
        <td colspan="4" style="height: 50px;font-weight: bold">
            所有文件展示
        </td>

    </tr>
    <tr align="center">
        <th>编号</th>
        <th>文件名称</th>
        <th>创建时间</th>
        <th>更多操作</th>
        <c:if test="${not empty list}">
        <c:forEach items="${list}" var="l" varStatus="vs">
    <tr align="center">
        <td>${vs.count}</td>
        <td style="display: none">${l.id}</td>
        <td>${l.name}</td>
        <td>${l.time}</td>
        <td>
            <a href="${pageContext.request.contextPath}/downloadFile?filename=${l.name}">下载</a>
            <a href="${pageContext.request.contextPath}/delFile?id=${l.id}&filename=${l.name}">删除</a>
        </td>
    </tr>
    </c:forEach>
    </c:if>
    </tr>
</table>

<script>
    // let date1 = document.getElementById('date1');
    // let timeStamp1 = new Date(date1.value).getTime();
    //
    // console.log(timeStamp1)
    // let date2 = document.getElementById('date2');
    // let timeStamp2 = new Date(date2.value).getTime();
</script>
</body>
</html>
