package org.pan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import org.pan.hibernate.Student;
import org.pan.hibernate.User;

/**
 * Created by QiPan on 2016/12/6.
 */
public class UserTest {


    @Test
    public void testHellWorld(){
        //Hibernate 5 创建SessionFactory 的方式
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        // 创建 SessionFactory
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        // 获得session
        Session session = sessionFactory.openSession();
        // 开启事务
        Transaction transaction = session.beginTransaction();
        User user = new User(1001, "Pan", "人和镇");
//        Student student = new Student(1001,"ZZ", 18, "中五");
        session.save(user);
//        session.save(student);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
