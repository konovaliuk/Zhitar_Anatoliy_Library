package com.zhitar.library.dao.userdao;

import com.zhitar.library.dao.GenericDao;
import com.zhitar.library.domain.User;

import java.util.Collection;

/**
 * Manage {@link User} entity
 */
public interface UserDao extends GenericDao<User, Integer> {

    User findByEmail(String email);

    Collection<User> findAllWithBooks();
}
