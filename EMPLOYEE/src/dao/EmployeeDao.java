package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    //查询所有员工
    List<Employee> queryAll() throws SQLException;
    //删除员工
    int delete(int id) throws SQLException;
    //查询员工by编号
    Employee query(String no);
    //查询员工byID
    Employee queryById(int id);
    //添加员工
    int add(Employee e);
    //修改员工信息
    int update(Employee e);
}
