package com.ems.repository;

import com.ems.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole,Integer> {

    UserRole findByName(String name);
}
