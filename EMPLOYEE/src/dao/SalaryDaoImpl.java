package dao;

import entity.Salary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.C3P0Util;

import java.util.List;

public class SalaryDaoImpl implements SalaryDao {
    private JdbcTemplate jdbcTemplate = null;

    public SalaryDaoImpl() {
        this.jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());
    }

    @Override
    public List<Salary> query(String no) {
        String sql = "select id,employee_no,salary_date,salary,sales from t_salary where employee_no=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Salary>(Salary.class), no);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from t_salary where id =?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int delete(String no) {
        String sql="delete from t_salary where employee_no = ?";
        return jdbcTemplate.update(sql, no);
    }

    @Override
    public int add(Salary s) {
        String sql="insert into t_salary (employee_no,salary_date,salary,sales) values\n" +
                "(?,?,?,?); ";
        Object[] args={s.getEmployee_no(),s.getSalary_date(),s.getSalary(),s.getSales()};
        return jdbcTemplate.update(sql, args);
    }

    public static void main(String[] args) {
        List<Salary> list = new SalaryDaoImpl().query("TZ001");
        for (Salary s : list) {
            System.out.println(s);
        }
    }
}
