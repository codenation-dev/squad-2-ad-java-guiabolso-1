package com.squad2.CentralDeErros.controller;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.entity.enumerate.Environment;
import com.squad2.CentralDeErros.entity.enumerate.Status;
import com.squad2.CentralDeErros.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping(params = {"id"})
    public Optional<Log> getLogById(@RequestParam("id") Long id) {
        return logService.getLogById(id);
    }

    @GetMapping(params = {"user"})
    public List<Log> getLogByUserId(@RequestParam("user") Long userId,
                                    @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                    @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                    @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                    @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                    @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.getLogByUserId(userId, status, page, size, sortBy, direction);
    }

    @GetMapping(params = {"user", "env"})
    public List<Log> getLogByUserIdAndEnv(@RequestParam("user") Long userId,
                                          @RequestParam("env") Environment environment,
                                          @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                          @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                          @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                          @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                          @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.getLogByUserIdAndEnv(userId, environment, status, page, size, sortBy, direction);
    }

    @GetMapping(params = {"search"})
    public List<Log> searchLogByEventDescription(@RequestParam("search") String keyword,
                                                 @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                 @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                 @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.searchLogByEventDescriptionIgnoreCase(keyword, status, page, size, sortBy, direction);
    }
}