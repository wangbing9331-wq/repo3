package dao;

import entity.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate = null;

    public EmployeeDaoImpl() {
        this.jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());
    }

    @Override
    public List<Employee> queryAll() throws SQLException {
        String sql = "select id,no,name,gender,post,entryTime,tel from t_employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public int delete(int id) {
        String sql = "delete from t_employee where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Employee queryById(int id) {
        String sql = "select id,no,name,gender,post,entryTime,tel from t_employee where id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), id);
    }

    @Override
    public int add(Employee e) {
        String sql = "insert into t_employee(no,name,gender,post,entryTime,tel) values(?,?,?,?,?,?)";
        Object[] args = {e.getNo(), e.getName(), e.getGender(), e.getPost(), e.getEntryTime(), e.getTel()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(Employee e) {
        String sql = "update t_employee set name=?,gender=?,post=?,entryTime=?,tel=? where no=?";
        Object[] args={e.getName(),e.getGender(),e.getPost(),e.getEntryTime(),e.getTel(),e.getNo()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Employee query(String no) {
        String sql = "select id,no,name,gender,post,entryTime,tel from t_employee where no=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), no);
    }


    public static void main(String[] args) {
        try {
            List<Employee> list = new EmployeeDaoImpl().queryAll();
            for (Employee e : list) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Employee e = new EmployeeDaoImpl().query("TZ002");
        System.out.println(e);

        Employee e1 = new EmployeeDaoImpl().queryById(3);
        System.out.println(e1);

    }
}
