package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> getWhiskyByYear(int year) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public List<Whisky> getWhiskyByRegion(String region) {
        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "d");
            cr.add(Restrictions.eq("d.region", region));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
