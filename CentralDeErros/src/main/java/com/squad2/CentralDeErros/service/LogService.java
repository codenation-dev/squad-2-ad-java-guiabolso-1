package com.squad2.CentralDeErros.service;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public Log add(Log log) {
        return logRepository.save(log);
    }

    public Log update(Log log) {
        return logRepository.save(log);
    }

    public Optional<Log> findById(Long id) {
        return logRepository.findById(id);
    }

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public List<Log> findAllOrderBy(String orderBy, Sort.Direction direction) {
        switch (direction) {
            case ASC:
                return logRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
            case DESC:
                return logRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
            default:
                return logRepository.findAll(Sort.by(orderBy));
        }

    }

    public List<Log> findAllByUserId(Long userId) {
        return logRepository.findAllByUserId(userId);
    }
}
