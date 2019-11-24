package service;

import entity.Employee;

import java.util.List;

public interface EmployeeService {

    //查询所有员工
    List<Employee> queryAll();

    //删除员工
    int delete(int id);

    //添加员工
    int add(Employee e);

    //修改员工
    int update(Employee e);
}
