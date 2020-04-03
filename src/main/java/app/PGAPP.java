package app;

import commen.HiveToPG;
import commen.PGTruncate;
import commen.PGUnlock;
import utills.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class PGAPP {

    static Connection con = null;

    public static void main(String[] args) {

        test1();


    }

    //此方法编译没问题，运行有问题。jdbc事务与sparksql.jdbc有冲突。
    //把设计spark的方法 HiveToPG.toPG()去掉，运行没问题。
    public static void test1(){
        try {
            //获取57连接
            con = JDBCUtil.getConnection();
            //开启事务
            //con.setAutoCommit(false);

            //57清空
            PGTruncate.trunData(con);
            // int a = 3/0;
            //写入数据
            HiveToPG.toPG();

            //提交事务
           // con.commit();

        } catch (Exception e) {
//            //事务回滚
//            try {
//                if(con != null){
//                    con.rollback();
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            e.printStackTrace();
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //PGTruncate.trunData2(con,"dataman.test_lock_pid");
    }
}
