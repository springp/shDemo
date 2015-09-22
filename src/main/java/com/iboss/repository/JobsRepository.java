package com.iboss.repository;

import java.util.List;

import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iboss.entity.Job;

@Repository
public class JobsRepository extends SimpleHibernateRepository<Job, Long> {

	protected JobsRepository() {
		super(Job.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Job> searchJobs(String keyword) {
		List<Job> result = null;
		try {

			FullTextSession searchSession = Search.getFullTextSession(getSessionFactory().getCurrentSession());
			final QueryBuilder b = searchSession.getSearchFactory().buildQueryBuilder().forEntity(Job.class).get();
			org.apache.lucene.search.Query luceneQuery = b.keyword().onField("userUUID").matching(keyword)
					.createQuery();

			org.hibernate.Query fullTextQuery = searchSession.createFullTextQuery(luceneQuery);

			result = fullTextQuery.list(); // return a list of managed objects
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
