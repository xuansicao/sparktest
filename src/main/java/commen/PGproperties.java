package commen;

import utills.JDBCUtil;

import java.util.Properties;

public class PGproperties {
    private static Properties pro =null;
    //57
    public static Properties getPro1() {
         pro = new Properties();
        pro.put("user", JDBCUtil.getUser());
        pro.put("password",JDBCUtil.getPassword());
        pro.put("driver",JDBCUtil.getDriver());
        return pro;
    }
    //108
    public static Properties getPro2() {
        pro = new Properties();
        pro.put("user2", JDBCUtil.getUser2());
        pro.put("password2",JDBCUtil.getPassword2());
        pro.put("driver",JDBCUtil.getDriver());
        return pro;
    }

}
