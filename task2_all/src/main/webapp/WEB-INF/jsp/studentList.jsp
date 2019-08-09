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
                    <td><a href="<%=request.getContextPath() %>/student/info/${student.id}">查看</a></td>
                    <td><a href="<%=request.getContextPath() %>/student/info/${student.id}">编辑</a></td>
                    <td><span onclick="deleteStudentById(${student.id})">删除</span></td>
                </tr>
            </c:forEach>

        </table>

        <div style="text-align:center;margin-top:40px">
            学生名称: <input id="name" name="name" type="text"> <br>
            学生qq: <input id="qq" name="qq" type="text"> <br>
            学习类型:<input id="skill" name="skill" type="text"> <br>
            <button onclick="insertStudent()">新增学生</button>
        </div>
    </div>
    <script src="<%=request.getContextPath() %>/js/lib/jquery.3.4.1.js"></script>
    <script>
        function deleteStudentById(id) {
            console.log(id)
            var status =  confirm("确定删除此用户吗？")
            if(!status){
                return
            }
            $.ajax("/task2/student/delete/"+id,{
                type:"DELETE",
                headers:{
                    "X-HTTP-Method-Override":"DELETE"
                },
                success:function (data) {
                    alert("删除成功")
                    window.location.href = "http://localhost:8080/task2/student/list"
                }
            })
        }
        function insertStudent() {
            $.ajax("/task2/student/add",{
                type:"POST",
                data:{
                    name:$("#name").val(),
                    qq:$("#qq").val(),
                    skill:$("#skill").val(),
                },
                success:function (data) {
                    alert("新增成功")
                    window.location.href = "http://localhost:8080/task2/student/list"
                }
            })
        }
    </script>
</body>
</html>
