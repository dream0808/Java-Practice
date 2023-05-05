package com.hpy.day03.exer;

import java.util.Iterator;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 15:32
 * @description: TODO
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001",new User(1001,40,"周杰伦"));
        userDAO.save("1002",new User(1002,56,"卢本伟"));
        userDAO.save("1003",new User(1003,34,"西科姆"));

        List<User> list = userDAO.list();
        Iterator<User> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
