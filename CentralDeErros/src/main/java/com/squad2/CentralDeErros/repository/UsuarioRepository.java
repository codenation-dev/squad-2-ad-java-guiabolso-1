package com.squad2.CentralDeErros.repository;

import com.squad2.CentralDeErros.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {

}
