/**
 * 
 */
package com.semika.autoac.persist.impl.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.semika.autoac.persist.api.common.GenericDAO;

/**
 * @author root
 *
 */
public class GenericHibernateDAO<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID>{

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
	        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
	                                .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
	        return persistentClass;
	}
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getHibernateTemplate().loadAll(getPersistentClass()); 
	}

	@SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example =  Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id, boolean lock) {
		T entity;
        if (lock) {
        	entity = (T) getHibernateTemplate().load(getPersistentClass(), id, LockMode.UPGRADE);
        } else {
        	entity = (T) getHibernateTemplate().load(getPersistentClass(), id);
        }
        return entity;
	}

	@Override
	public T makePersistent(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public void makeTransient(T entity) {
		getHibernateTemplate().delete(entity);
	}

}
