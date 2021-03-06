package com.iboss.repository;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.iboss.entity.Job;
import com.iboss.entity.JobContract;
import com.iboss.enums.JobStatus;
import com.iboss.exceptions.JobException;

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
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Job> listJobs(Long userId, String status) {
		List<Job> results = null;
		try {
			
			Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Job.class);
			criteria.add(Restrictions.eq("client.id", userId));
			if (!StringUtils.isEmpty(status) && !JobStatus.ALL.name().equalsIgnoreCase(status)){
				criteria.add(Restrictions.eq("jobStatus", status));
			}
			results = criteria.list();
		
		} catch (Exception e) {
			throw new JobException("Backend server error while listing JOBs", e);
		}
		return results;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<JobContract> listContracts(String userUUID, String status) {
		List<JobContract> results = null;
		try {
			
			Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(JobContract.class).createAlias("user", "u");			
			criteria.add(Restrictions.eq("u.userUUID", userUUID));
			if (!StringUtils.isEmpty(status) && !JobStatus.ALL.name().equalsIgnoreCase(status)){
				criteria.add(Restrictions.eq("job.jobStatus", status));
			}
			results = criteria.list();
		
		} catch (Exception e) {
			throw new JobException("Backend server error while listing user's JOBs", e);
		}
		return results;
	}
	
	@Transactional(readOnly = true)
	public Job findByUserUUIDAndJobUUID(String userUUID, String jobUUID) {
		Job result = null;
		try {			
			Query query = getSessionFactory().getCurrentSession().createQuery("FROM Job j WHERE j.client.userUUID = :userUUID AND j.jobUUID = :jobUUID");
			query.setParameter("userUUID", userUUID);
			query.setParameter("jobUUID", jobUUID);
			
			@SuppressWarnings("rawtypes")
			List jobs = query.list() ; 
			
			if (CollectionUtils.isNotEmpty(jobs)){
				result = (Job) jobs.get(0);
			} else {
				throw new JobException("Job does not exist.");
			}
			
		} catch (JobException e) {
			throw e;
		} catch (Exception e) {
			throw new JobException("Backend server error while fetching job details", e);
		}
		return result;
	}
}
