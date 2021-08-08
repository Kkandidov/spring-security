package org.astashonok.springsecurity.repository;

import java.util.Optional;
import org.astashonok.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
