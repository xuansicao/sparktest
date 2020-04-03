package utills;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    //PG 57服务器
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static String driver = null;
    static Properties properties = null;
    static Connection con =null;

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getDriver() {
        return driver;
    }

    static {

        try {
            properties = new Properties();
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URL resource = classLoader.getResource("JDBCInfo.properties");
            String path = resource.getPath();
            properties.load(new FileInputStream(path));

            url = properties.getProperty("url");
            driver = properties.getProperty("driver");


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
            con = DriverManager.getConnection(url,properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    //关闭连接
    public static void closeConnection( Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
