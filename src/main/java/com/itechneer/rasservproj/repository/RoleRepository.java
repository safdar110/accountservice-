package com.itechneer.rasservproj.repository;

import com.itechneer.rasservproj.models.ERole;
import com.itechneer.rasservproj.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
