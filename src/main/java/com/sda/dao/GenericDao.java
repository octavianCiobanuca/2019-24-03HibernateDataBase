package com.sda.dao;

import com.sda.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sun.java2d.loops.TransformBlit;

public class GenericDao<T> {
    public void createEntity(T entity){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();
        session.close();
    }
    public T getEntityById(Class<T> cls, Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        T entity = session.get(cls, id);

        transaction.commit();
        return entity;
    }
}
