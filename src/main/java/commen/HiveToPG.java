package commen;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.Test;
import utills.InitSpark;
import utills.JDBCUtil;
import java.util.Properties;

public class HiveToPG {
    static Properties pro = null;

    @Test
    public static void toPG() {
        SparkSession spark = InitSpark.initSpark();
        String url = JDBCUtil.getUrl();
        pro = JDBCUtil.getProperties();
        System.out.println(pro);

        String depsql = "select * from ods_sftm_new.ods_org_dep limit 5";
        Dataset<Row> empDF = spark.sql(depsql);
        //spark.sql(depsql).show();
        //hive写入pg
        empDF.write().mode("append").jdbc(url,"dataman.test1",pro);


        spark.close();

    }





}
