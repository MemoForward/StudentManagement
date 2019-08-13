<%--
  Created by IntelliJ IDEA.
  User: handsomestar
  Date: 2019/8/10
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>学生添加界面</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/cxyStyle.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

    <style type="text/css">
        td,th{
            padding: 10px;
        }
    </style>
</head>
<body>
<div class="editID">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">添加学生</h3>
        </div>
        <div class="panel-body">

            <form method="post" action="${pageContext.request.contextPath}/studentServlet.do?method=addStudent" role="form">
                <table class="editTable">
                    <tr>
                        <td>学号：</td>
                        <td><input type="text" name="snum" id="snum"
                                   placeholder="请在这里输入学号"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="sname" id="sname" placeholder="请在这里输入名字">
                        </td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="sage" id="sage" placeholder="请在这里输入年龄"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" class="radio radio-inline" name="sgender" value="男"> 男
                            <input type="radio" class="radio radio-inline" name="sgender" value="女"> 女
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期：</td>
                        <td><input type="date" name="birthday" id="birthday"
                                   placeholder="请在这里输入出生日期"></td>
                    </tr>
                    <tr class="submitTR">
                        <td  align="center" width="80%">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                        <td align="center">
                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/indexServlet.do" role="button">返 回</a>
                        </td>
                    </tr>

                </table>
            </form>
        </div>
    </div>

</div>

</body>
</html>

