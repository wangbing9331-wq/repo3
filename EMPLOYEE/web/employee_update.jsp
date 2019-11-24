<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12
  Time: 17:23
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
    String no=request.getParameter("no");
    System.out.println("要修改的员工编号："+no);
    request.setAttribute("no", no);
%>

<div class="container text-center">
    <h3>修改员工信息页面</h3>
    <hr>
    <div class="row justify-content-center">
        <form role="form">
            <table class="table table-condensed text-center">
                <tbody>
                <tr>
                    <th style="vertical-align: middle !important;">员工编号</th>
                    <td><input type="text" id="no" disabled="disabled" value="${no}" class="form-control"></td>
                    <th style="vertical-align: middle !important;">员工姓名</th>
                    <td><input type="text" id="name" class="form-control"></td>
                </tr>
                <tr>
                    <th style="vertical-align: middle !important;">员工性别</th>
                    <td> 男 <input type="radio" name="gender" value="男" checked>
                        女 <input type="radio" name="gender" value="女">
                    </td>
                    <th style="vertical-align: middle !important;">员工职称</th>
                    <td><select id="post" class="form-control">
                        <option value="">--请选择--</option>
                        <option value="初级销售员">初级销售员</option>
                        <option value="中级销售员">中级销售员</option>
                        <option value="高级销售员">高级销售员</option>
                        <option value="部门经理">部门经理</option>
                    </select></td>
                </tr>
                <tr>
                    <th style="vertical-align: middle !important;">入职时间</th>
                    <td><input type="date" id="date" class="form-control"></td>
                    <th style="vertical-align: middle !important;">联系电话</th>
                    <td><input type="number" id="tel" class="form-control"></td>
                </tr>
                </tbody>
            </table>
            <input type="button" id="btn" value="确认修改">
        </form>
    </div>
    <a href="employee_info.jsp">返回</a>
</div>


<script>
$(function () {
    $('#btn').click(function () {
        let no=$('#no').val();
        let name=$('#name').val();
        let gender=$('input[name="gender"]:checked').val();
        let post=$('#post').val();
        let date=$('#date').val();
        let tel=$('#tel').val();
        console.log("no="+no);
        console.log("name="+name);
        console.log("gender="+gender);
        console.log("post="+post);
        console.log("date="+date);
        console.log("tel="+tel);
        if(name==""){alert('员工姓名不能为空');return;}
        if(post==""){alert('员工职称不能为空');return;}
        if(date==""){alert('入职时间不能为空');return;}
        if(tel==""){alert('联系电话不能为空');return;}
        $.get('employee_update.do',{'no':no,'name':name,'gender':gender
        ,'post':post,'date':date,'tel':tel},function (resp) {
            console.log('resp='+resp);
            if(resp=="true"){alert('修改成功');}
            else if(resp=="false"){alert('修改失败')}
            // location.href="employee_info.jsp";
        },'html')

    })
})
</script>
</body>
</html>
