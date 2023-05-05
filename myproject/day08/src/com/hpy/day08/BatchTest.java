package com.hpy.day08;

import com.hpy.day08.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class BatchTest {

    @Test
    public void testBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into dept values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,"Jack"+i);
            preparedStatement.addBatch();
            if((i+1) % 1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();

        System.out.println((end-start)/1000.0);

        JDBCUtils.close(null,preparedStatement,connection);
    }
}
