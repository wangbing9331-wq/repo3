<%@ page import="entity.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="service.EmployeeService" %>
<%@ page import="service.EmployeeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/vue/2.6.10/vue.min.js"></script>
</head>
<body>

<%
    EmployeeService employeeService = new EmployeeServiceImpl();
    List<Employee> list = employeeService.queryAll();
    request.setAttribute("elist", list);
    System.out.println("当前所有员工"+list);
%>

<div class="container text-center">
    <h3>员工工资管理系统</h3>
    <hr>
    <div class="row justify-content-center">
        <div>
            <form action="delete.do">
                <table class="table table-hover text-center">
                    <thead>
                    <tr>
                        <th></th>
                        <th>序号</th>
                        <th>员工编号</th>
                        <th>员工姓名</th>
                        <th>性别</th>
                        <th>职称</th>
                        <th>入职时间</th>
                        <th>联系电话</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${elist}" varStatus="vs">
                        <tr>
                            <td><input type="checkbox" name="id" value="${i.id}"></td>
                            <td>${vs.index+1}</td>
                            <td><a href="salary_info.do?no=${i.no}" id="no">${i.no}</a></td>
                            <td>${i.name}</td>
                            <td>${i.gender}</td>
                            <td>${i.post}</td>
                            <td>${i.entryTime}</td>
                            <td>${i.tel}</td>
                            <td><a href="employee_update.jsp?no=${i.no}">修改信息</a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="9"><input type="submit" value="删除">
                            &emsp;&emsp;<a href="employee_add.jsp">添加新员工</a>
                            &emsp;&emsp;<a href="salary_add.jsp">添加工资条目</a></td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>

</div>
<%--<script>--%>
    <%--$(function () {--%>
        <%--$('#employee_no').click(function () {--%>
            <%--let employee_no = $('#employee_no').attr('href').split('=')[1];--%>
            <%--console.log('employee_no=' + employee_no);--%>
            <%--$.post('salary_info.jsp', {'employee_no': employee_no}, function (resp, status,xhr) {--%>
                <%--console.log(status);--%>
                <%--console.log(xhr);--%>
            <%--});--%>
            <%--return false;--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>
</body>
</html>
