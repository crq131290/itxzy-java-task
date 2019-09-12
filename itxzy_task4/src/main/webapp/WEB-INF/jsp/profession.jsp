<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-09-08
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<html>
<head>
    <title>Title</title>
    <link href="<%=request.getContextPath()%>/css/t11.css" rel="stylesheet" type="text/css">
<body>
    <link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet" type="text/css">
</head>
<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <c:forEach items="${proTypeList}" var="proType" varStatus="proTypeStatus">
            <a class="nav-bar-a" href="">${proType.name}</a>
        </c:forEach>
    </div>



    <c:forEach items="${proTypeList}" var="proType" varStatus="proTypeStatus">
        <div class="caption">
            <h4>${proType.name}开发方向</h4>
        </div>
        <div class="row">
            <c:forEach items="${proList}" var="pro" varStatus="proStatus">
                <c:if test="${pro.type == proType.id}">
                    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                        <div class="warp-border">
                            <div class="clearfix">
                                <div class="icon-people"><img src="<%=request.getContextPath()%>/imges/687.png"></div>
                                <div class="text">
                                    <h4 class="">${pro.name}</h4>
                                    <p class="text-present">
                                       ${pro.description}
                                    </p>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">门槛
                                        <c:forEach begin="1" end="${pro.threshold}" var="v" >
                                            <img src="<%=request.getContextPath()%>/imges/xx.png">
                                        </c:forEach>
                                        <%--<c:forEach items="${pro.threshold}" var="threshold">--%>
                                            <%--<img src="<%=request.getContextPath()%>/imges/xx.png">--%>
                                        <%--</c:forEach>--%>
                                    </div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">难易程度
                                        <c:forEach begin="1" end="${pro.diff}" var="v" >
                                            <img src="<%=request.getContextPath()%>/imges/xx.png">
                                        </c:forEach>
                                        <%--<c:forEach items="${pro.diff}" var="threshold">--%>
                                            <%--<img src="<%=request.getContextPath()%>/imges/xx.png">--%>
                                        <%--</c:forEach>--%>
                                    </div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${pro.need}</span>家公司需要</div>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="leftWarp">
                                    薪资待遇
                                </div>
                                <div class="rightWarp">
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">0-1年</div>
                                        <div class="rightWarp-wages">5k-10k/月</div>
                                    </div>
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">0-1年</div>
                                        <div class="rightWarp-wages">5k-10k/月</div>
                                    </div>
                                    <div class="rightWarp-class border-bottom">
                                        <div class="rightWarp-year">0-1年</div>
                                        <div class="rightWarp-wages">5k-10k/月</div>
                                    </div>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <b class="text-b">有${pro.current}人正在学</b>
                            </div>
                            <div class="warp-class2">
                                <p class="text-p">提示:${pro.tip}</p>
                            </div>

                            <div class="flip-container">
                                <p class="flip-title">${pro.name}</p>
                                <p class="flip-text">
                                    ${pro.description}
                                </p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>

</div>
</body>
</html>
