package com.iboss.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class SimpleHibernateRepository<T, PK extends Serializable> {

	private Class<T> entity;

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public SimpleHibernateRepository() {
		this.entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected SimpleHibernateRepository(Class<T> entity) {
		this.entity = entity;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected SessionFactory getSessionFactory() {
		if (sessionFactory == null)
			throw new IllegalStateException("SessionFactory has not been set on DAO before usage");
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//	@SuppressWarnings("unchecked")
//	public T getByKey(PK key) {
//		return (T) getSession().get(entity, key);
//	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T findById(PK id) {
		return (T) getSessionFactory().getCurrentSession().get(entity, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return getSessionFactory().getCurrentSession().createCriteria(entity).list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public PK save(T entity) {
		return (PK) getSessionFactory().getCurrentSession().save(entity);
	}

	@Transactional(readOnly = false)
	public void saveAll(Iterable<T> entities) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entities);
	}

	@Transactional(readOnly = false)
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Transactional(readOnly = false)
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Transactional(readOnly = false)
	public void deleteAll(Iterable<T> entities) {
		getSessionFactory().getCurrentSession().delete(entities);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T findByProperty(Object key, Object value) {
		List<T> results = null;
		T result = null;
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(entity);
		criteria.add(Restrictions.eq("" + key, value));
		results = criteria.list();
		if (!results.isEmpty()) {
			if (results.size() == 1) {
				result = results.get(0);
			}
		}
		return result;
	}
}
