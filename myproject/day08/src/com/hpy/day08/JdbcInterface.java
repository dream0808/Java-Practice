package com.hpy.day08;

public interface JdbcInterface {

     Object getConnection();

     public void crud();

     public void closeConnection();
}
