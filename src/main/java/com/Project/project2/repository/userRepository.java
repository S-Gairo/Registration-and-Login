package com.Project.project2.repository;

import com.Project.project2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
