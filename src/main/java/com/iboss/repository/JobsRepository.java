package com.iboss.repository;

import java.util.List;

import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iboss.entity.User;

@Repository
public class JobsRepository extends SimpleHibernateRepository<User, Long> {

	protected JobsRepository() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<User> searchJobs(String keyword) {
		List<User> result = null;
		try {
			
			FullTextSession searchSession = Search.getFullTextSession(getSessionFactory().getCurrentSession());
			final QueryBuilder b = searchSession.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
			org.apache.lucene.search.Query luceneQuery = b.keyword().onField("userUUID").matching(keyword).createQuery();

			org.hibernate.Query fullTextQuery = searchSession.createFullTextQuery(luceneQuery);

			result = fullTextQuery.list(); // return a list of managed objects
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
