package com.eventsharing.business.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.eventsharing.business.dao.UserDao;
import com.eventsharing.business.filter.UserFilter;
import com.eventsharing.entity.User;

@Stateless
public class UserDaoImpl implements UserDao {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@Override
	public User retrieveUser(Integer id) {
		User user = this.em.find(User.class, id);
		return user;
	}

	@Override
	public List<User> listUser(UserFilter filter) {
		String query = "select u from User u where 1 = 1 ";
		
		String firstName = filter.getFirstName();
		if (firstName != null) {
			query += " and e.firstName like :firstName";
		}

		String lastName = filter.getLastName();
		if (lastName != null) {
			query += " and e.lastName like :lastName";
		}
		
		String login = filter.getLogin();
		if (login != null) {
			query += " and e.login like :login";
		}
		
		String email = filter.getEmail();
		if (email != null) {
			query += " and e.email like :email";
		}
		
		TypedQuery typedQuery = this.em.createQuery(query, User.class);
		
		if (firstName != null) {
			typedQuery.setParameter("firstName", "%" + filter.getFirstName() + "%");
		}
		if (lastName != null) {
			typedQuery.setParameter("lastName", "%" + filter.getLastName() + "%");
		}
		if (login != null) {
			typedQuery.setParameter("login", "%" + filter.getLogin() + "%");
		}
		if (email != null) {
			typedQuery.setParameter("email", "%" + filter.getEmail() + "%");
		}
		return typedQuery.getResultList();
	}

}
