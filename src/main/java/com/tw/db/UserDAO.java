package com.tw.db;

import com.tw.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public List<User> getUserByName(String name){
//        Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        List<User> result= session.createQuery("from com.tw.model.User where first_name like :name or last_name like :name").setParameter("name","%"+name+"%").list();
//        List<User> result =new ArrayList<>(2);
//        result = session.createQuery("from users").list();
        return result.size() > 0 ? result : null ;
    }
}
