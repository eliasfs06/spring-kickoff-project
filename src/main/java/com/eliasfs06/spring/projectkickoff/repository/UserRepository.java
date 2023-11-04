package com.eliasfs06.spring.projectkickoff.repository;

import com.eliasfs06.spring.projectkickoff.model.User;

public interface UserRepository extends GenericRepository<User> {
    User findByUsername(String username);
}
