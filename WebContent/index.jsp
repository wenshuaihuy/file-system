<%--
  Created by IntelliJ IDEA.
  User: WSHu
  Date: 2020/12/16
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>流量显示</title>
    <script src="js/jquery-2.1.0.min.js"></script>
</head>
<body>
<%--<h2><a href="${pageContext.request.contextPath}/list">查看流量</a></h2>--%>

<script>
    // window.location.reload(true);
    window.location.href='${pageContext.request.contextPath}/list';
</script>

</body>
</html>
