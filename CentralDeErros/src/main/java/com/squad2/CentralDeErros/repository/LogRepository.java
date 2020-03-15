package com.squad2.CentralDeErros.repository;

import com.squad2.CentralDeErros.entity.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE ID_USUARIO = :userId " +
            "AND STATUS = :status",
            nativeQuery = true)
    List<Log> findAllByUserId(@Param("userId") Long userId, @Param("status") int status, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE ID_USUARIO = :userId " +
            "AND STATUS = :status " +
            "AND AMBIENTE = :ambiente",
            nativeQuery = true)
    List<Log> findAllByUserIdandAmbiente(@Param("userId") Long userId, @Param("ambiente") int ambiente, @Param("status") int status, Pageable pageable);

}
