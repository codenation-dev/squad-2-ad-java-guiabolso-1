package com.squad2.CentralDeErros.repository;

import com.squad2.CentralDeErros.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        User findById(long id);
	User findByName(String name);

}
