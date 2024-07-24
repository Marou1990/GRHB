package com.mang.grh.Repositories.Registration;

import com.mang.grh.entities.Registration.ERole;
import com.mang.grh.entities.Registration.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}