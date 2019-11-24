package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.SalaryDao;
import dao.SalaryDaoImpl;
import entity.Employee;
import entity.Salary;

import java.util.List;

public class SalaryServiceImpl implements SalaryService{
    SalaryDao salaryDao=new SalaryDaoImpl();
    EmployeeDao employeeDao=new EmployeeDaoImpl();

    @Override
    public List<Salary> query(String no) {
        List<Salary> salarys=salaryDao.query(no);
        Employee employee=employeeDao.query(no);
        if(salarys!=null&&employee!=null){
            for (Salary s:salarys){
                s.setEmployee(employee);
            }
            return salarys;
        }
        return null;
    }

    @Override
    public int delete(int id) {
        try{
            return salaryDao.delete(id);
        }catch (Exception e){

        }
        return 0;
    }

    @Override
    public int add(Salary s) {
        try {
            return salaryDao.add(s);
        }catch (Exception e){

        }
        return 0;
    }

    public static void main(String[] args) {
        String no="TZ001";
        List<Salary>  s=new SalaryDaoImpl().query(no);
        System.out.println(s);
    }
}
