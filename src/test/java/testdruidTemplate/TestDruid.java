package testdruidTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

public class TestDruid {
    private static DataSource ds ;
    private static Connection connection ;
    private static PreparedStatement pst;
    private static ResultSet resultSet ;

    public static DataSource getDs() {
        return ds;
    }

    static {

        try {
            //1.加载配置文件
            Properties properties = new Properties();
            properties.load(TestDruid.class.getClassLoader().getResourceAsStream("druid.properties"));

            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试
    @Test
    public void test() {
        //获取连接
        try {
            connection = ds.getConnection();
            String sql = "select * from dataman.ods_org_dep limit 2";
            //获取PreparedStatement对象
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(resultSet,pst,connection);
        }
    }


    //获取连接
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }

    //释放资源
    public static void closeConnection(ResultSet rs, Statement stm, Connection con)  {
        try {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close(); //归还连接
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
