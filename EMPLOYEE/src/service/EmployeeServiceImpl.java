package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.SalaryDao;
import dao.SalaryDaoImpl;
import entity.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Employee> queryAll() {
        try {
            return employeeDao.queryAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int id) {
        Employee e = employeeDao.queryById(id);
        if (e != null) {
            String no = e.getNo();
            System.out.println("要删除的员工编号：" + no);
            try {
                int res1 = employeeDao.delete(id);
                SalaryDao salaryDao = new SalaryDaoImpl();
                int res2 = salaryDao.delete(no);
                if (res1 != 0 ) {
                    return 1;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int add(Employee e1) {
        try {
            return employeeDao.add(e1);
        }catch (Exception e){
            System.out.println("员工编号不能重复");
        }
        return 0;
    }

    @Override
    public int update(Employee e) {
        try{
            return employeeDao.update(e);
        }catch (Exception e1) {
            e1.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
//        int r=new EmployeeServiceImpl().delete(1);
        Employee e=new Employee(0,"www","ydon","男","部门经理", Date.valueOf("2019-10-01"),"123");
        int r=new EmployeeServiceImpl().add(e);
        System.out.println(r);
    }
}
