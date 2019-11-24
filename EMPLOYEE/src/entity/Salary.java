package entity;

import java.text.SimpleDateFormat;
import java.sql.Date;

public class Salary {
    private int id;
    private String employee_no;
    private Date salary_date;
    private int Salary;
    private int sales;
    private Employee employee;

    public Salary(){}

    public Salary(int id, String no, Date salary_date, int salary, int sales) {
        this.id = id;
        this.employee_no = no;
        this.salary_date = salary_date;
        Salary = salary;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", employee_no='" + employee_no + '\'' +
                ", salary_date=" + salary_date +
                ", Salary=" + Salary +
                ", sales=" + sales +
                ", employee=" + employee +
                ", post=" + employee.getPost() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public Date getSalary_date() {
        return salary_date;
    }

    public void setSalary_date(Date salary_date) {
        this.salary_date = salary_date;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date Date(){
        SimpleDateFormat sdt=new SimpleDateFormat("yyyy-MM-dd");
        Date d= Date.valueOf(sdt.format(this.salary_date));
        return d;
    }
}
