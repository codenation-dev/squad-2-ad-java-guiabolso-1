package com.squad2.CentralDeErros.service;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LogService {

    @Autowired
    LogRepository logRepository;

    public Log add(Log log) {
        return logRepository.save(log);
    }

    public Log update(Log log) {
        return logRepository.save(log);
    }

    public Optional<Log> findById(Long id) {
        return logRepository.findById(id);
    }
}
