<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.EmployeeService" %>
<%@ page import="service.EmployeeServiceImpl" %>
<%@ page import="entity.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    System.out.println(list);
%>


<div class="container text-center">
    <h3>添加工资条目页面</h3>
    <hr>
    <div class="row justify-content-center">
        <form  role="form">
            <table class="table table-condensed text-center">
                <tbody>
                <tr>
                    <th style="vertical-align: middle !important;">员工编号</th>
                    <td><select id="no" class="form-control">
                        <c:forEach var="i" items="${elist}">
                            <option value="${i.no}">${i.no}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <th style="vertical-align: middle !important;">工资日期</th>
                    <td><input type="date" id="date" class="form-control" ></td>
                </tr>
                <tr>
                    <th style="vertical-align: middle !important;">基本工资</th>
                    <td><input type="number" id="salary" class="form-control" ></td>
                </tr>
                <tr>
                    <th style="vertical-align: middle !important;">单月销售量</th>
                    <td><input type="number" id="sales" class="form-control" ></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" id="btn" value="确认添加">
                        <input type="reset" value="重置">
                    </td>
                </tr>
                </tbody>
            </table>
        </form>

    </div>
    <a href="employee_info.jsp">返回</a>
</div>
<script>
$(function () {
    $('#btn').click(function () {
        let no=$('#no').val();
        let date=$('#date').val();
        let salary=$('#salary').val();
        let sales=$('#sales').val();
        console.log('no='+no);
        console.log('date='+date);
        console.log('salary='+salary);
        console.log('sales='+sales);
        if (date==""){alert('工资日期不能为空');return;}
        if (salary==""){alert('基本工资不能为空');return;}
        if (sales==""){alert('单月销售量不能为空');return;}
        if(salary-0 <3000){alert('基本工资不能小于3000');return;}
        $.get('salary_add.do',{'no':no,'date':date,'salary':salary,'sales':sales},
        function (resp) {
            console.log('resp='+resp);
            if(resp=="1"){
                alert('添加成功');
                location.href='employee_info.jsp';
            }else if(resp=="0"){alert('添加失败')}
        },'html')

    })
})
</script>
</body>
</html>
