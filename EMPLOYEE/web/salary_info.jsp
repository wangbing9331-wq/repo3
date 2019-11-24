<%@ page import="entity.Salary" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    List<Salary> salary= (List<Salary>) request.getAttribute("salary");
    System.out.println(salary);
%>

<div class="container text-center">
    <h3>的工资详情如下</h3>
    <hr>
    <table class="table table-hover text-center">
        <thead>
        <tr>
            <th>序号</th>
            <th>工资日期</th>
            <th>基本工资(￥)</th>
            <th>单月销售量(￥)</th>
            <th>合计(￥)</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${salary}" varStatus="vs">
            <tr>
                <td>${vs.index+1}</td>
                <td>${i.salary_date}</td>
                <td>${i.salary}</td>
                <td>${i.sales}</td>
                <td>${i.salary+0.1*i.sales}</td>
                <td><a href="salary_delete.do?id=${i.id}&no=${i.employee_no}" id="btn">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="employee_info.jsp">返回</a>
</div>



</body>
</html>
