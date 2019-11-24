package dao;

import entity.Salary;

import java.util.List;

public interface SalaryDao {
    //查询员工工资by编号
    List<Salary> query(String no);
    //删除工资记录byId
    int delete(int id);
    //删除工资记录by员工编号
    int delete(String no);
    //添加工资
    int add(Salary s);
}
