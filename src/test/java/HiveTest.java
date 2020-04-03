import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class HiveTest {
    public static void main(String[] args) {
        //  切换集群用户
        System.setProperty("HADOOP_USER_NAME", "hadoop");
        System.setProperty("user.name", "hadoop");

        //  spark 初始化
        SparkSession spark = SparkSession
                .builder()
                .appName("SparkToPG")
                .master("local[4]")
                .config("spark.sql.warehouse.dir", "/warehouse/tablespace/managed/hive")
                .config("hive.metastore.uris", "thrift://namenode.gaialab.ai:9083")
                .config("spark.debug.maxToStringFields","300")
                .config("hive.execution.engine","mr")
                .enableHiveSupport()
                .getOrCreate();
       //   /warehouse/tablespace/managed/hive/ols.db/student

        String sql = "select name,class, row_number() over(partition by class order by score) as rank from ols.student having class = \"语文\" and rank = 1 ";
        String sq = "select name from ols.student where class = \"语文\" and score in(\n" +
                "select max(score) from ols.student group by class)";

        String s2 = "update ols.student set score = 81 where name = \"李四\" and class = \"数学\" ";
        String s = "select max(score) from ols.student group by class";

        String s3 = "select name,class,score,row_number() over(partition by class order by score desc) as rank from ols.student having class = \"语文\" and rank = 1";

//        Dataset<Row> df1 = spark.sql(s);
//        df1.show();
        Dataset<Row> df = spark.sql(s3);
        df.show();



        spark.close();

    }
}
