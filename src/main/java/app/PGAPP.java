package app;

import commen.HiveToPG;
import commen.PGTruncate;
import commen.PGUnlock;
import utills.JDBCUtil;

import java.sql.Connection;

public class PGAPP {
    public static void main(String[] args) {

        //获取57连接
        Connection con = JDBCUtil.getConnection();
        //解锁57
        //PGUnlock.trunPG(con);

        //57清空
       // PGTruncate.trunData(con);

        //写入数据
       // HiveToPG.toPG();


        //查询hive数据
        HiveToPG.toPG();
        //PGTruncate.trunData2(con,"dataman.test_lock_pid");



    }
}
