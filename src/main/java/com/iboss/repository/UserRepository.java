package com.iboss.repository;

import org.springframework.stereotype.Repository;

import com.iboss.entity.User;

@Repository
public class UserRepository extends SimpleHibernateRepository<User, Long> {

	protected UserRepository() {
		super(User.class);
	}
}
