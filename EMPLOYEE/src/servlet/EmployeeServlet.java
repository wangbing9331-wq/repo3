package servlet;

import entity.Employee;
import entity.Salary;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.SalaryService;
import service.SalaryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = "*.do")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter();

        String url = request.getRequestURI();
        System.out.println("url:" + url);
        String methodName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".")); //
        System.out.println("methodName:" + methodName);
        Method method = null;
        try {
            //使用反射机制获取本类中声明的方法
            method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行 许可
            method.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException("调用方法出错");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    //查询所有员工
    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--queryAll方法--");
//        EmployeeService employeeService=new EmployeeServiceImpl();
//        List<Employee> list=employeeService.queryAll();
//        request.setAttribute("list", list);
        request.getRequestDispatcher("employee_info.jsp").forward(request, response);
    }

    //删除员工by 员工id
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--delete方法--");
        String id = request.getParameter("id");
        System.out.println("要删除的员工id：" + id);
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.delete(Integer.parseInt(id));
        response.sendRedirect("employee_info.jsp");
    }

    //查看指定员工的工资记录 by 员工编号
    public void salary_info(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--servlet_info方法--");
        String no = request.getParameter("no");
        System.out.println("要查看工资的员工编号：" + no);
        SalaryService salaryService = new SalaryServiceImpl();
        List<Salary> salary = salaryService.query(no);
        System.out.println(salary);

        request.setAttribute("salary", salary);
        request.getRequestDispatcher("salary_info.jsp").forward(request, response);
    }

    //删除工资记录 by  工资id
    public void salary_delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--salary_delete方法--");
        String id = request.getParameter("id");
        System.out.println("要删除的工资id：" + id);
        SalaryService salaryService = new SalaryServiceImpl();
        salaryService.delete(Integer.parseInt(id));
        salary_info(request, response);
    }

    //添加员工
    public void employee_add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--employee_add方法--");
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String post = request.getParameter("post");
        String entry = request.getParameter("date");
        String tel = request.getParameter("tel");
        System.out.println(no);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(post);
        System.out.println(entry);
        System.out.println(tel);
        Employee e = new Employee(0,no,name,gender,post,
                Date.valueOf(entry),tel);
        System.out.println("添加的员工："+e);
        EmployeeService employeeService = new EmployeeServiceImpl();
        int row = employeeService.add(e);
        if (row == 1) {
            response.getWriter().print("1");
        } else {
            response.getWriter().print("0");
        }
    }

    //添加工资记录
    public void salary_add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--salary_add方法--");
        String no = request.getParameter("no");
        String date = request.getParameter("date");
        String salary = request.getParameter("salary");
        String sales = request.getParameter("sales");
        System.out.println("no=" + no);
        System.out.println("date=" + date);
        System.out.println("salary=" + salary);
        System.out.println("sales=" + sales);
        Salary s = new Salary(0, no, Date.valueOf(date), Integer.valueOf(salary), Integer.valueOf(sales));
        SalaryService salaryService = new SalaryServiceImpl();
        int r=salaryService.add(s);
        if(r==1){
            response.getWriter().print("1");
        }else{
            response.getWriter().print("0");
        }
    }

    //修改员工信息
    public void employee_update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--employee_update方法--");
        String no=request.getParameter("no");
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String post=request.getParameter("post");
        String date=request.getParameter("date");
        String tel=request.getParameter("tel");
        Employee e=new Employee(0,no,name,gender,post,Date.valueOf(date),tel);
        System.out.println("修改员工信息"+e);
        EmployeeService employeeService=new EmployeeServiceImpl();
        int r=employeeService.update(e);
        if(r==1){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }
}
