package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Employee {
    private int id;
    private String employee_no;
    private String name;
    private String gender;
    private String post;
    private Date entryTime;
    private String tel;

    public Employee(){}

    public Employee(int id, String employee_no, String name, String gender, String post, Date entryTime, String tel) {
        this.id = id;
        this.employee_no = employee_no;
        this.name = name;
        this.gender = gender;
        this.post = post;
        this.entryTime = entryTime;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", no='" + employee_no + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", post='" + post + '\'' +
                ", entryTime=" + Date() +
                ", tel='" + tel + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return employee_no;
    }

    public void setNo(String no) {
        this.employee_no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date Date(){
        SimpleDateFormat sdt=new SimpleDateFormat("yyyy-MM-dd");
        Date d= Date.valueOf(sdt.format(this.entryTime));
        return d;
    }
}
