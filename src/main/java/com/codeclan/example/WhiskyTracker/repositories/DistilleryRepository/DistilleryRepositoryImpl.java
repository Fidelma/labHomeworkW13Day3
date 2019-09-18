package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

//    @Autowired
//    EntityManager entityManager;
//
//    @Transactional
//    public List<Whisky> findWhiskiesFromDistilleryByAge(Long id, int age) {
//        List<Whisky> results = null;
//
//
//        try {
//            Session session = entityManager.unwrap(Session.class);
//            Criteria cr = session.createCriteria(Distillery.class);
//            cr.createAlias("whiskies", "whiskyAlias");
//            Criterion first = Restrictions.or(Restrictions.eq("whiskyAlias.getAge", age ));
//            Criterion second = Restrictions.or(Restrictions.eq("getId", id));
//            cr.add(Restrictions.and(first, second));
////
////            cr.add(Restrictions.eq("whiskyAlias.getAge", age));
////            cr.add(Restrictions.eq("id", id));
//            results = cr.list();
//
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        }
//        return results;
//    }
}
