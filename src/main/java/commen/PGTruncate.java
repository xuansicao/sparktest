package commen;

import java.sql.*;

public class PGTruncate {
    private static Statement stmt = null;
    private static PreparedStatement pst = null;
    private static CallableStatement callableStatement = null;

    public static void trunData(Connection con) {

        try {
            stmt = con.createStatement();
            //清空表
            String sql1 = "truncate table dataman.test1";
            stmt.execute(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //先判断，如果stmt为null，是不能调用方法的
                if (stmt != null) {
                    stmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    //测试
    public static void trunData2(Connection con, String tablename) {
        try {
            //stmt = con.createStatement();
            //清空表
            callableStatement =con.prepareCall("truncate table " + tablename);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //先判断，如果stmt为null，是不能调用方法的
                if (callableStatement != null) {
                    callableStatement.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
