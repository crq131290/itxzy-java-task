<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-09
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="true"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>StudentList</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/lib/bootstrap.3.3.7.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/studentlist.css" />
</head>
<body>
    <div class="student-list text-center">
        <h3>${statusCH}</h3>
        <h3>${statusEN}</h3>
        <hr>
        <table>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>qq</td>
                <td>Skill</td>
                <td>查看</td>
                <td>编辑</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${studentList}" var="student" varStatus="st">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.qq}</td>
                    <td>${student.skill}</td>
                    <td><a href="<%=request.getContextPath() %>/task/student/${student.id}">查看</a></td>
                    <td><a href="<%=request.getContextPath() %>/task/student/${student.id}">编辑</a></td>
                    <td><span onclick="deleteStudentById(${student.id})">删除</span></td>
                </tr>
            </c:forEach>

        </table>

        <div>
            <button onclick="prePage(${page.currentPage})">上一页</button>
            <button onclick="nextPage(${page.currentPage},${page.total})">下一页</button>
            当前页:<input class="w-30-p" id="current" onchange="changeCurrentPage(${page.total})" type="text" value="${page.currentPage}">
            每页个数:<input class="w-30-p" id="pagesize" onchange="changePageSize(${page.currentPage})" type="text" value="${page.pageSize}">
            总页数:${page.total}
            总记录:${page.totalRecords}
        </div>


        <ul class="add-student" style="text-align:center;margin-top:40px">
            <li>
                学生名称: <input id="name" name="name" type="text">
            </li>
            <li>
                学生qq: <input id="qq" name="qq" type="text">
            </li>
            <li>
                学习类型:<input id="skill" name="skill" type="text">
            </li>
        </ul>
        <button class="bg-orange color-fff" onclick="insertStudent()">新增学生</button>
    </div>
    <script src="<%=request.getContextPath() %>/js/lib/jquery.3.4.1.js"></script>
    <script>
        function deleteStudentById(id) {
            console.log(id)
            var status =  confirm("确定删除此用户吗？")
            if(!status){
                return
            }
            $.ajax("/task2/student/"+id,{
                type:"DELETE",
                headers:{
                    "X-HTTP-Method-Override":"DELETE"
                },
                success:function (data) {
                    alert("删除成功")
                    window.location.href = "../student/list/1/10"
                }
            })
        }
        function insertStudent() {
            $.ajax("/task2/task/student",{
                type:"POST",
                data:{
                    name:null,
                    qq:$("#qq").val(),
                    skill:$("#skill").val(),
                },
                success:function (data) {
                    alert("新增成功")
                    window.location.href = "../student/list/1/10"
                }
            })
        }
        function prePage(current) {
            var pagesize = $("#pagesize").val()
            var url = "../"+(current-1)+"/"+pagesize
            if(current<=1){
                alert("这是第一页，没有上一页了")
                return
            }
            $.ajax(url,{
                type:"GET",
                success:function (data) {
                    alert("上一页")
                    window.location.href = url
                }
            })
        }
        function nextPage(current,total) {
            var pagesize = $("#pagesize").val()
            if(current+1>total){
                alert("这是最后一页了，没有下一页了")
                return
            }
            var url = "../"+(current+1)+"/"+pagesize
            $.ajax(url,{
                type:"GET",
                success:function (data) {
                    alert("下一页")
                    window.location.href = url
                }
            })
        }

        function changePageSize() {
            var pagesize = $("#pagesize").val()
            if(pagesize<1){
                alert("pageSize不能小于1")
                $("#pagesize").val(3)
                return
            }
            var url = "../1/"+pagesize
            $.ajax(url,{
                type:"GET",
                success:function (data) {
                    alert("pagesize 改变了")
                    window.location.href = url
                }
            })
        }

        function changeCurrentPage(total) {
            var pagesize = $("#pagesize").val()
            var current = $("#current").val()
            if(current>total || current<1){
                alert("没有第"+current+"页")
                $("#current").val(1)
                return
            }
            var url = "../"+current+"/"+pagesize
            $.ajax(url,{
                type:"GET",
                success:function (data) {
                    alert("第"+current+"页")
                    window.location.href = url
                }
            })
        }
    </script>
</body>
</html>
