package service;


import entity.Salary;

import java.util.List;

public interface SalaryService {

    //查询员工工资by编号
    List<Salary> query(String no);
    //删除员工工资byId
    int delete(int id);
    //增加工资记录
    int add(Salary s);
}
