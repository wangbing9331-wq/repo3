package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0Util {
    private static DataSource ds=new ComboPooledDataSource();

    public static DataSource getDataSource(){
        return ds;
    }

    public static void main(String[] args) {
        System.out.println(getDataSource());
    }
}
