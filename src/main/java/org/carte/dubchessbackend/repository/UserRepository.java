package org.carte.dubchessbackend.repository;

import org.carte.dubchessbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
