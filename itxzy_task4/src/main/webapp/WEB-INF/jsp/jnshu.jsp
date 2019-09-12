<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/4/7
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<!DOCTYPE html>
<html>
<head>
    <title>技能树</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/bootstrap.css">
    <link href="<%=request.getContextPath()%>/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />
</body>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script  src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</html>
