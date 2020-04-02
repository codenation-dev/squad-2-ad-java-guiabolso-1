package com.squad2.CentralDeErros.controller;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.entity.User;
import com.squad2.CentralDeErros.entity.enumerate.Environment;
import com.squad2.CentralDeErros.entity.enumerate.Status;
import com.squad2.CentralDeErros.service.LogService;
import com.squad2.CentralDeErros.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/log")
//@Secured("USER")
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private SecurityService securityService;

    @GetMapping(params = {"id"})
    public Optional<Log> getLogById(@RequestParam("id") Long id) {
        return logService.getLogById(id);
    }

    @GetMapping()
    public List<Log> getLogByUserId(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                    @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                    @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                    @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                    @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.getLogByUserId(securityService.getUserAuthenticated().getId(), status, page, size, sortBy, direction);
    }

    @GetMapping(params = {"env"})
    public List<Log> getLogByUserIdAndEnv(@RequestParam("env") Environment environment,
                                          @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                          @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                          @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                          @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                          @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.getLogByUserIdAndEnv(securityService.getUserAuthenticated().getId(), environment, status, page, size, sortBy, direction);
    }

    @GetMapping(params = {"search"})
    public List<Log> searchLogByEventDescription(@RequestParam("search") String keyword,
                                                 @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                 @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                 @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.searchLogByEventDescriptionIgnoreCase(keyword, securityService.getUserAuthenticated().getId(), status, page, size, sortBy, direction);
    }

    @GetMapping(params = {"search", "env"})
    public List<Log> searchLogByEventDescriptionAndEnvIgnoreCase(@RequestParam("search") String keyword,
                                                                 @RequestParam("env") Environment environment,
                                                                 @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                                 @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                                 @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.searchLogByEventDescriptionAndEnvIgnoreCase(keyword, securityService.getUserAuthenticated().getId(), environment, status, page, size, sortBy, direction);
    }

    @PostMapping(params = "arc")
    void archiveLog(@RequestParam("arc") Long logId) {
        logService.archiveLog(logId, securityService.getUserAuthenticated().getId());
    }

    @PostMapping(params = "del")
    void deleteLog(@RequestParam("del") Long logId) {
        logService.deleteLog(logId, securityService.getUserAuthenticated().getId());
    }

    @PostMapping(params = "res")
    void restoreLog(@RequestParam("res") Long logId) {
        logService.restoreLog(logId, securityService.getUserAuthenticated().getId());
    }

    @GetMapping("/list")
    public List<Log> getLogs() {
        return logService.getLogsByUserId(securityService.getUserAuthenticated().getId());
    }

    @GetMapping("/teste")
    public ResponseEntity<User> getLogTeste() {
        try {
            return new ResponseEntity<>(securityService.getUserAuthenticated(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}