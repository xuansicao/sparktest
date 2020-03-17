package utills;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    //PG 57服务器
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driver = null;
    private static String url3 = null;

    //PG 108服务器
    private static String url2 = null;
    private static String user2 = null;
    private static String password2 = null;
    private static Connection con = null;

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDriver() {
        return driver;
    }

    public static String getUrl3() {
        return url3;
    }

    public static String getUrl2() {
        return url2;
    }

    public static String getUser2() {
        return user2;
    }

    public static String getPassword2() {
        return password2;
    }

    public static Connection getCon() {
        return con;
    }

    static {

        try {
            Properties properties = new Properties();
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URL resource = classLoader.getResource("JDBCInfo_properties");
            String path = resource.getPath();
            properties.load(new FileInputStream(path));

            //57
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            url3 = properties.getProperty("url3");

            url2 = properties.getProperty("url2");
            user2 = properties.getProperty("user2");
            password2 = properties.getProperty("password2");

            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    获取连接
     */

    //57
    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

//    //108 康师傅
//    public static Connection getConnection2() {
//        try {
//            con = DriverManager.getConnection(url2, user2, password2);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }


}
