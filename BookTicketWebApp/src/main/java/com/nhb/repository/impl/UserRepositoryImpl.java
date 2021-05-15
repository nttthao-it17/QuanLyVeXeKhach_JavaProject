/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.repository.impl;

import com.nhb.pojo.User;
import com.nhb.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author T430s
 */
@Repository
@Transactional 
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public List<User> getUsers(String username) {
        List<User> users;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = builder.createQuery(User.class);

        Root<User> root = cr.from(User.class);

        CriteriaQuery<User> query = cr.select(root);
        if (!username.isEmpty())
            query.where(builder.equal(root.get("username"), username));

        users = session.createQuery(query).getResultList();
        
        return users;
    }

    //Lấy thông tin user từ username và mật khẩu
    @Override
    public User login(String username, String password) {
        User userRes;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = builder.createQuery(User.class);

        Root<User> root = cr.from(User.class);
        CriteriaQuery<User> query = cr.select(root);
        if (!username.isEmpty() && !password.isEmpty()){
            Predicate[] predicates = new Predicate[2];
            predicates[0] = builder.equal(root.get("username"), username);
            predicates[1] = builder.equal(root.get("password"), password);
            query.where(predicates);
        }

        userRes = session.createQuery(query).getResultStream().findFirst().orElse(null);
        
        return userRes;
    }

    @Override
    public User getUserById(int id) {
        User user;
        
        Session session = sessionFactory.getCurrentSession();
        user = session.get(User.class, id);
        
        return user;
    }
    
    
    
}
