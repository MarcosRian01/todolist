package com.projrocketseat.todolist.user.repository;

import com.projrocketseat.todolist.user.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
