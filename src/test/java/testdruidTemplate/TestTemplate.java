package testdruidTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestTemplate {

    @Test
    public void test(){
        //创建 JdbcTemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(TestDruid.getDs());

        String sql = "update dataman.test1 set id = '11' where id = '10' ";
        int update = jdbcTemplate.update(sql);  //所操作数据的条数
        System.out.println(update);

        //不需要关闭连接

    }
}
