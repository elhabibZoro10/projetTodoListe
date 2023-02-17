package com.todo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todo.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByEmail(String email);
}
