package commen;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import utills.InitSpark;
import utills.JDBCUtil;

import java.sql.Connection;
import java.util.Properties;

public class HiveToPG {
    public static void toPG() {

        SparkSession spark = InitSpark.initSpark();
        String url = JDBCUtil.getUrl();
        Properties pro1 = PGproperties.getPro1();

        String empsql = "select * from dwd_sftm.dwd_cust limit 2";
        //Dataset<Row> empDF = spark.sql(empsql);
        spark.sql(empsql).show();


//        //hive写入pg
//        empDF.write().mode("append")
//                .jdbc(url,"dataman.test1",pro1);

        spark.close();

    }
}
