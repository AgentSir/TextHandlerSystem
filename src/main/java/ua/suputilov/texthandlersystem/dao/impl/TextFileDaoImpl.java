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
import org.hibernate.type.IntegerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.suputilov.texthandlersystem.dao.TextFileDao;
import ua.suputilov.texthandlersystem.model.TextFile;

/**
 *
 * @author sergey_putilov
 */
@Repository
public class TextFileDaoImpl implements TextFileDao {

    public TextFileDaoImpl() {
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<TextFile> getAllTextFiles() {
        return getSession().createQuery("from TextFile").list();
    }

    @Override
    @Transactional
    public List<TextFile> getTextFilesByMinCountLineCriteria(Integer minCountLines) {
        try {
            Criteria crit = getSession().createCriteria(TextFile.class, "this_");
            crit.createAlias("this_.lines", "lines", Criteria.LEFT_JOIN);
            crit.add(Restrictions.sqlRestriction("this_.file_statement_id in "
                    + "(Select l.file_statement_id from "
                    + "(select fsb.file_statement_id, count(fsb.file_statement_breakdown_id) as countLines "
                    + "from file_statement_breakdown fsb group by fsb.file_statement_id) l "
                    + "where countLines >= ?)", minCountLines, new IntegerType()));
            crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            return crit.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    @Transactional
    public void saveTextFile(TextFile textFile) {
        getSession().save(textFile);
    }
}
