import org.junit.Test;

import java.sql.*;

@JDBCAnnotaion(url = "jdbc:postgresql://192.168.0.57:5432/TAPlanning_KNoodle?prepareThreshold=0",
        user = "postgres",
        password = "postgis",
        driver = "org.postgresql.Driver")

public class AnnotationTest {

    @Test
    public void test1() {
        //1.获取注解信息
        boolean annotationPresent = AnnotationTest.class.isAnnotationPresent(JDBCAnnotaion.class);
        if(annotationPresent){
            //获取注解对象
            JDBCAnnotaion annotation = AnnotationTest.class.getAnnotation(JDBCAnnotaion.class);
            //获取注解对象属性
            String url = annotation.url();
            String user = annotation.user();
            String password = annotation.password();
            String driver = annotation.driver();

            //2.连接数据库
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                //3.查询数据
                String sql = "select * from dataman.ods_org_dep limit 1";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    System.out.println(resultSet.getString("id"));
                    System.out.println(resultSet.getString("org_code"));
                    System.out.println(resultSet.getString("org_name"));
                }

                if(connection != null){
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
