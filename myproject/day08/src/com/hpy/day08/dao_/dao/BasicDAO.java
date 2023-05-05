package com.hpy.day08.dao_.dao;

import com.hpy.day08.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public class BasicDAO<T> {

   private QueryRunner qr = new QueryRunner();

   public int update(String sql,Object... params){
       Connection connection = JDBCUtilsByDruid.getConnection();
       try {
           return  qr.update(connection, sql, params);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }finally {
           JDBCUtilsByDruid.close(null,null,connection);
       }

   }
   public List<T> queryMulti(String sql,Class<T> clazz,Object... params){
       Connection connection = JDBCUtilsByDruid.getConnection();
     //  ArrayList<T> list;
       try {
            return qr.query(connection, sql, new BeanListHandler<>(clazz), params);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
     //  return list;
   }

   public T querySingle(String sql,Class<T> clazz,Object... params){
       Connection connection = JDBCUtilsByDruid.getConnection();
       try {
         return  qr.query(connection,sql,new BeanHandler<T>(clazz),params);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

   public Object queryScalar(String sql,Object... params){
       Connection connection = JDBCUtilsByDruid.getConnection();
       try {
          return qr.query(connection,sql,new ScalarHandler<>(),params);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }
}
