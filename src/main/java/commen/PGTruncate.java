package commen;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class PGTruncate {
    private static PreparedStatement pst = null;
    //private static CallableStatement callableStatement = null;

    public static void trunData(Connection con) {

        try {
            //清空表
            String sql1 = "truncate table dataman.test1";
            pst = con.prepareStatement(sql1);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pst != null){
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //测试
//    public static void trunData2(Connection con, String tablename) {
//        try {
//            //stmt = con.createStatement();
//            //清空表
//            callableStatement =con.prepareCall("truncate table " + tablename);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                //先判断，如果stmt为null，是不能调用方法的
//                if (callableStatement != null) {
//                    callableStatement.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    //查询PG数据

    public static void getPG(Connection con){

        try {
            String sql= "select id,org_name from dataman.ods_org_dep limit 2";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pst != null){
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
