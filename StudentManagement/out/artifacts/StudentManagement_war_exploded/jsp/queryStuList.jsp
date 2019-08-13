<%--
  Created by IntelliJ IDEA.
  User: handsomestar
  Date: 2019/8/10
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>学生界面</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/cxyStyle.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

    <style type="text/css">
        th,td
        {
            text-align:center;
            /*vertical-align:middle;*/
        }
    </style>

    <script type="text/javascript">
        function doDelete(sid) {
            var flag = confirm("确定要删除吗？");
            if(flag){
                window.location.href="studentServlet.do?method=deleteStudent&sid=" + sid;
            }
        }

    </script>


</head>

<div class="title"><h1>查询学生列表</h1></div>
<body>
<div class="tableID">
    <table class="table table-hover">

        <thead>
        <tr>
            <th colspan="7">
                <form class="form-inline" method="post" action ="${pageContext.request.contextPath}/studentServlet.do?method=queryStudentByStuNum">
                    <div class="form-group">
                        <label for="exampleInputName2">学号</label>
                        <input type="text" class="form-control" name = "stuNum" id="exampleInputName2" placeholder="可模糊查询">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </th>
        </tr>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>出生日期</th>
            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${stuList}" var="s">
            <tr>
                <th>${s.snum}</th>
                <th>${s.sname}</th>
                <th>${s.sgender}</th>
                <th>${s.sage}</th>
                <th>${s.birthday}</th>
<%--                用两种方法实现跳转--%>
                <th><a href="${pageContext.request.contextPath}/studentServlet.do?method=editStudent&sid=${s.sid}">编辑</a></th>
                <!-- 这里doDelete传参一定要加引号-->
                <th><a href="javascript:void(0)" onclick="doDelete('${s.sid}')">删除</a></th>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot >
        <tr>
            <th colspan="7">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/indexServlet.do" role="button">返 回</a>
            </th>
        </tr>
        </tfoot>
    </table>

</div>

</body>
</html>


