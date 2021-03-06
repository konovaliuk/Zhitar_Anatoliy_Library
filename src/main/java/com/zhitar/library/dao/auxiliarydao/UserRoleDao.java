package com.zhitar.library.dao.auxiliarydao;

import com.zhitar.library.domain.UserRole;

import java.util.List;

/**
 * Manage auxiliary {@link UserRole} object that
 * represent intermediate table for user and role
 */
public interface UserRoleDao {

    UserRole save(UserRole userRole);

    List<UserRole> save(List<UserRole> userRoleList);

    List<UserRole> findByRoleId(Integer roleId);

    List<UserRole> findByUserId(Integer bookId);
}
