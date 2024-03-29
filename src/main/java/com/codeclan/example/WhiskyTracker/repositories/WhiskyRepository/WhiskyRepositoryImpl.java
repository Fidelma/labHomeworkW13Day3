package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesFromDistilleryByAge(Long id, int age) {
        List<Whisky> results = null;


        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "dist");
            cr.add(Restrictions.eq("dist.id", id));
            cr.add(Restrictions.eq("age", age));
            results = cr.list();

        }
            catch(HibernateException ex) {
            ex.printStackTrace();
        }
        return results;

    }

    @Transactional
    public List<Whisky> findWhiskiesFromRegion(String region){
        List<Whisky> results = null;


        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "dist");
            cr.add(Restrictions.eq("dist.region", region));
            results = cr.list();
        }

        catch(HibernateException ex) {
            ex.printStackTrace();
        }

        return results;
    }
}
