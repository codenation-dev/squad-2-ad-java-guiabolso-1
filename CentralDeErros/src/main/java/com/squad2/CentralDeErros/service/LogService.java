package com.squad2.CentralDeErros.service;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.entity.enumerate.Environment;
import com.squad2.CentralDeErros.entity.enumerate.Status;
import com.squad2.CentralDeErros.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public Optional<Log> getLogById(Long id) {
        return logRepository.findById(id);
    }

    public List<Log> getLogByUserId(Long userId, Status status, Short page, Short size, String sortBy, Sort.Direction direction) {
        return logRepository.getLogByUserId(userId, status.ordinal(), PageRequest.of(page, size, Sort.by(direction, sortBy)));
    }

    public List<Log> getLogByUserIdAndEnv(Long userId, Environment environment, Status status, Short page, Short size, String sortBy, Sort.Direction direction) {
        return logRepository.getLogByUserIdAndEnv(userId, environment.ordinal(), status.ordinal(), PageRequest.of(page, size, Sort.by(direction, sortBy)));
    }

    public List<Log> searchLogByEventDescriptionIgnoreCase(String keyword, Status status, Short page, Short size, String sortBy, Sort.Direction direction) {
        return logRepository.searchLogByEventDescriptionIgnoreCase(keyword, status.ordinal(), PageRequest.of(page, size, Sort.by(direction, sortBy)));
    }

    public List<Log> searchLogByEventDescriptionAndEnvIgnoreCase(String keyword, Environment environment, Status status, Short page, Short size, String sortBy, Sort.Direction direction) {
        return logRepository.searchLogByEventDescriptionAndEnvIgnoreCase(keyword, environment.ordinal(), status.ordinal(), PageRequest.of(page, size, Sort.by(direction, sortBy)));
    }
}