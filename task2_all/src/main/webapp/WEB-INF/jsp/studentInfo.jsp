<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-08-09
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .student-info table{
            border:1px solid #afd9ee;
            border-radius: 3px;
        }
        .student-info table td{
            padding:15px;
            text-align: center;
        }
        .student-info table td:first-child{
            border-right:1px solid #afd9ee;
        }

        .student-info table tr:first-child{
            background: #31b0d5;
            color:#fff;
        }
    </style>
</head>
<body>
<div class="student-info text-center">
    <table>
        <tr>
            <td>名称</td>
            <td>信息</td>
        </tr>
        <tr>
            <td>学生id：</td>
            <td>${student.id}</td>
        </tr>
        <tr>
            <td>学生名称：</td>
            <td>${student.name}</td>
        </tr>
        <tr>
            <td>学生qq：</td>
            <td>${student.qq}</td>
        </tr>
        <tr>
            <td>学生skill：</td>
            <td>${student.skill}</td>
        </tr>
    </table>
</div>
</body>
</html>
