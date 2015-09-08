package com.iboss.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.util.Version;
import org.hibernate.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import com.iboss.entity.User;

import net.sf.ehcache.hibernate.HibernateUtil;

public class JobsRepository extends SimpleHibernateRepository<User, Long> {

	protected JobsRepository() {
		super(User.class);
	}

	/*public List<User> searchJobs() {

//		FullTextSession searchSession = Search.getFullTextSession(getSessionFactory().getCurrentSession());
//		(new String[1]
//		MultiFieldQueryParser parser=new MultiFieldQueryParser(Version.LUCENE_46, new ArrayList<String>(HibernateUtil.getSearchFields()).toArray(new String[1]),new StandardAnalyzer());
//	    try {
//	      Query q=parser.parse(query);
//	      newFrom=from;
//	      boolean more=true;
//	      while (more && results.size() < PAGE_SIZE) {
//	        more=addResults(q,fullTextSession,newFrom);
//	      }
//	    } catch (    Exception e) {
//	      e.printStackTrace();
//	    }

//		QueryParser parser = new QueryParser(Version.LUCENE_32, "contenu", new StandardAnalyzer(Version.LUCENE_32));
//
//		org.apache.lucene.search.Query luceneQuery = parser.parse("décarbonateront");
//
//		org.hibernate.Query hibQuery = searchSession.createFullTextQuery(luceneQuery, User.class);
//
//		List<User> result = hibQuery.list();
//
//		return result;
	}*/
}
