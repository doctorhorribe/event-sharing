package com.eventsharing.business.dao;

import java.util.List;

import com.eventsharing.business.filter.UserFilter;
import com.eventsharing.entity.User;

public interface UserDao {
	
	User retrieveUser(Integer id);
	
	List<User> listUser(UserFilter filter);

}
