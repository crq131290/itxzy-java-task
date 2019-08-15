<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-09
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align:center;margin-top:40px">
        学生名称: <input id="id" readonly name="id" value="${student.id}" type="text"> <br>
        学生名称: <input id="name" name="name" value="${student.name}" type="text"> <br>
        学生qq: <input id="qq" name="qq" value="${student.qq}" type="text"> <br>
        学习类型:<input id="skill" name="skill" value="${student.skill}" type="text"> <br>
        <button onclick="updateStudent()">编辑学生</button>
    </div>
</body>

<script src="<%=request.getContextPath() %>/js/lib/jquery.3.4.1.js"></script>
<script>
    function updateStudent() {
        var id = $("#id").val()
        console.log($("#name").val())
        console.log($("#qq").val())
        console.log($("#skill").val())
        var params = {
            name:null,//$("#name").val()
            qq:$("#qq").val(),
            skill:$("#skill").val(),
        }
        $.ajax("/task2/task/student/"+id,{
            type:"PUT",
            data:JSON.stringify(params),
            contentType:'application/json;charset=utf-8',
            headers:{
                "X-HTTP-Method-Override":"PUT"
            },
            success:function (data) {
                alert("更新成功")
                window.location.href = "../student/list/1/10"
            }
        })
    }
</script>
</html>
