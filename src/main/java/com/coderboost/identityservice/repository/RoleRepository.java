package com.coderboost.identityservice.repository;

import com.coderboost.identityservice.domain.entity.Role;
import com.coderboost.identityservice.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
