package commen;



import utills.JDBCUtil;

import java.sql.*;

public class PGUnlock {
    private static Statement stmt = null;
    private static PreparedStatement preparedStatement= null;

    public static void trunPG(Connection con) {

        try{
            stmt = con.createStatement();
            //1.清空pid表
            String trunsql = "truncate table dataman.test_lock_pid";
            stmt.execute(trunsql);
            //2.存储锁表的pid
            String pidsql =  "insert into dataman.test_lock_pid(\n" +
                    "select pid from pg_locks where relation in (\n" +
                    "select oid from dataman.test_lock_oid )\n" +
                    ")";
            stmt.executeUpdate(pidsql);
            //3.解锁
            String selsql = "select pid from dataman.test_lock_pid";
            ResultSet rs = stmt.executeQuery(selsql);

            while(rs.next()){
                String pid = rs.getString("pid");
                System.out.println("锁表pid：" + pid);
                //解锁
                String tersql = "select pg_terminate_backend(?)";
                preparedStatement = con.prepareStatement(tersql);
                preparedStatement.setString(1,pid);
                boolean execute = preparedStatement.execute();
                if(execute){
                    System.out.println("解锁成功！");
                }else{
                    System.out.println("解锁失败，请重新解锁！");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt != null){
                    stmt.close();
                }

                if( preparedStatement!= null){
                    preparedStatement.close();
                }

                if(con != null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

}
