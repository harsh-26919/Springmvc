package com.harsh.springmvc.Dao;

import com.harsh.springmvc.Model.Aliens;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlienDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Aliens> getAliens()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Aliens> aliens = session.createQuery("from Aliens", Aliens.class).list();
        return aliens;
    }

    @Transactional
    public void addAliens(Aliens a)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(a);
    }

    @Transactional
    public Aliens getAlien(int aid)
    {
        Session session = sessionFactory.getCurrentSession();
        Aliens a = session.get(Aliens.class, aid);
        return a;
    }
}
