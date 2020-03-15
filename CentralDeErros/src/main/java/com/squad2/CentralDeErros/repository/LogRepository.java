package com.squad2.CentralDeErros.repository;

import com.squad2.CentralDeErros.entity.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Override
    List<Log> findAll(Sort sort);

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE ID_USUARIO_ID_USUARIO = :userId " +
            "AND STATUS = :status",
            nativeQuery = true)
    List<Log> findAllByUserId(@Param("userId") Long userId, @Param("status") Short status, Pageable pageable);

}
