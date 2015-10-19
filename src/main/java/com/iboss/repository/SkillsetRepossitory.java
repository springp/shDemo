package com.iboss.repository;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iboss.entity.SkillSet;

@Repository
public class SkillsetRepossitory extends SimpleHibernateRepository<SkillSet, Long> {

	protected SkillsetRepossitory() {
		super(SkillSet.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<SkillSet> searchSkills(Long subCatId) {
		String strQuery = "FROM SkillSet skillset WHERE skillset.technologyStack.id=:subCatId";
		Query query = getSession().createQuery(strQuery);
		query.setParameter("subCatId", subCatId);
		List<SkillSet> skillSets = query.list();
		return skillSets;
	}

}