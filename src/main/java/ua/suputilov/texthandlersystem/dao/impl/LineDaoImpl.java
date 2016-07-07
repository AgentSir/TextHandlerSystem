/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.suputilov.texthandlersystem.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.suputilov.texthandlersystem.dao.LineDao;
import ua.suputilov.texthandlersystem.model.Line;

/**
 *
 * @author sergey_putilov
 */
@Repository
public class LineDaoImpl implements LineDao {

    public LineDaoImpl() {
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<Line> getTextLinesByFileId(Integer fileId) {
        try {
            Criteria criteria = getSession().createCriteria(Line.class, "this");
            criteria.add(Restrictions.eq("this.fileId", fileId));

            return criteria.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
