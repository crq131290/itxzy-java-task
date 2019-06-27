<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-23
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--${student}--%>
    <c:forEach items="${list}" var="student" begin="0" end="2" varStatus="st">
        <json:object>
            <json:property name="id" value="${student.id}"></json:property>
            <json:property name="name" value="${student.name}"></json:property>
            <json:property name="age" value="${student.age}"></json:property>
            <json:property name="qq" value="${student.qq}"></json:property>
            <json:property name="st" value="${st}"></json:property>
        </json:object>
    </c:forEach>
    <%--<json:array items="${list}" var="student">--%>
        <%--<json:object>--%>
            <%--<json:property name="id" value="${student.id}"></json:property>--%>
            <%--<json:property name="name" value="${student.name}"></json:property>--%>
            <%--<json:property name="age" value="${student.age}"></json:property>--%>
            <%--<json:property name="qq" value="${student.qq}"></json:property>--%>
        <%--</json:object>--%>
    <%--</json:array>--%>
</body>
</html>
