package com.squad2.CentralDeErros.repository;

import com.squad2.CentralDeErros.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
