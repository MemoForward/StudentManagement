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

    <div class="title"><h1>学生列表</h1></div>
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

                <c:forEach items="${pageList.pageList}" var="s">
                    <tr>
                        <th>${s.snum}</th>
                        <th>${s.sname}</th>
                        <th>${s.sgender}</th>
                        <th>${s.sage}</th>
                        <th>${s.birthday}</th>
                        <th><a href="${pageContext.request.contextPath}/studentServlet.do?method=editStudent&sid=${s.sid}">编辑</a></th>
                        <!-- 这里doDelete传参一定要加引号-->
                        <th><a href="javascript:void(0)" onclick="doDelete('${s.sid}')">删除</a></th>
                    </tr>
                </c:forEach>
                <tr>
                    <th colspan="3" style="text-align: right">
                        <div style="margin: 25px 0;">
                            共<span style="color: blue; ">${pageList.totalDataNum}</span>条数据,当前在第<span style="color: darkred">${pageList.currentPageNum}</span>页
                        </div>
                    </th>
<%--                    页码--%>
                    <th colspan="4" style="text-align:left; margin-left: 10px">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <c:if test="${pageList.currentPageNum gt 1}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/studentServlet.do?method=findStudentByPage&currentPageNum=${pageList.currentPageNum - 1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${pageList.currentPageNum eq 1}">
                                    <li class="disabled">
                                        <a href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:forEach begin="1" end="${pageList.totalPageNum}" var="page">
                                    <c:if test="${page == pageList.currentPageNum}">
                                        <li class="active"><a href="#">${page}</a></li>
                                    </c:if>
                                    <c:if test="${page != pageList.currentPageNum}">
                                        <li><a href="${pageContext.request.contextPath}/studentServlet.do?method=findStudentByPage&currentPageNum=${page}">${page}</a></li>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${pageList.currentPageNum lt pageList.totalPageNum}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/studentServlet.do?method=findStudentByPage&currentPageNum=${pageList.currentPageNum + 1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${pageList.currentPageNum eq pageList.totalPageNum}">
                                    <li class="disabled">
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </th>

                </tr>

            </tbody>

            <tfoot >
                <tr>
                    <th colspan="7"><a href="${pageContext.request.contextPath}/jsp/addStudent.jsp">添加学生</a></th>
                </tr>
            </tfoot>
        </table>

    </div>

</body>
</html>

