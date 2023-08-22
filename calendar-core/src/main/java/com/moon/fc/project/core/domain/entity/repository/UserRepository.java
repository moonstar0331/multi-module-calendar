package com.moon.fc.project.core.domain.entity.repository;

import com.moon.fc.project.core.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
