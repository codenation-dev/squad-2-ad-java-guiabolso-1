package com.squad2.CentralDeErros.repository;

import com.squad2.CentralDeErros.entity.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE USER_ID = :userId " +
            "AND STATUS = :status",
            nativeQuery = true)
    List<Log> getLogByUserId(@Param("userId") Long userId, @Param("status") int status, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE USER_ID = :userId " +
            "AND STATUS = :status " +
            "AND ENVIRONMENT = :environment",
            nativeQuery = true)
    List<Log> getLogByUserIdAndEnv(@Param("userId") Long userId, @Param("environment") int environment, @Param("status") int status, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE LOWER(EVENT_DESCRIPTION) LIKE '%' || LOWER(:keyword) || '%' " +
            "AND STATUS = :status " +
            "AND USER_ID = :userId",
            nativeQuery = true)
    List<Log> searchLogByEventDescriptionIgnoreCase(@Param("keyword") String keyword, @Param("userId") Long userId, @Param("status") int status, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE LOWER(EVENT_DESCRIPTION) LIKE '%' || LOWER(:keyword) || '%' " +
            "AND USER_ID = :userId" +
            "AND STATUS = :status " +
            "AND ENVIRONMENT = :environment",
            nativeQuery = true)
    List<Log> searchLogByEventDescriptionAndEnvIgnoreCase(@Param("keyword") String keyword, @Param("userId") Long userId, @Param("environment") int environment, @Param("status") int status, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM LOG " +
            "WHERE USER_ID = :userId ",
            nativeQuery = true)
    List<Log> getLogByUserId(@Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE LOG " +
            "SET STATUS = 1 " +
            "WHERE ID = :logId " +
            "AND USER_ID = :userId",
            nativeQuery = true)
    void archiveLog(@Param("logId") Long logId, @Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE LOG " +
            "SET STATUS = 2 " +
            "WHERE ID = :logId " +
            "AND USER_ID = :userId",
            nativeQuery = true)
    void deleteLog(@Param("logId") Long logId, @Param("userId") Long userId);

    @Modifying
    @Query(value = "UPDATE LOG " +
            "SET STATUS = 0 " +
            "WHERE ID = :logId " +
            "AND USER_ID = :userId",
            nativeQuery = true)
    void restoreLog(@Param("logId") Long logId, @Param("userId") Long userId);
}
