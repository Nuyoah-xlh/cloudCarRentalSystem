<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2021/9/12
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="user">
    ${user.id}--${user.name}--${user.score}--${user.password}<br/>
</c:forEach>
</body>
</html>
