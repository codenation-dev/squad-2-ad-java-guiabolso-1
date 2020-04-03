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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Optional<Log>> getLogById(@RequestParam("id") Long id) {
        try {
            return new ResponseEntity<>(logService.getLogById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Log>> getLogByUserId(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                    @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                    @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                    @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                    @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            return new ResponseEntity<>(logService.getLogByUserId(securityService.getUserAuthenticated().getId(), status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"env"})
    public ResponseEntity<List<Log>> getLogByUserIdAndEnv(@RequestParam("env") Environment environment,
                                          @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                          @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                          @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                          @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                          @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            return new ResponseEntity<>(logService.getLogByUserIdAndEnv(securityService.getUserAuthenticated().getId(), environment, status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"search"})
    public ResponseEntity<List<Log>> searchLogByEventDescription(@RequestParam("search") String keyword,
                                                 @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                 @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                 @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            return new ResponseEntity<>(logService.searchLogByEventDescriptionIgnoreCase(keyword, securityService.getUserAuthenticated().getId(), status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"search", "env"})
    public ResponseEntity<List<Log>> searchLogByEventDescriptionAndEnvIgnoreCase(@RequestParam("search") String keyword,
                                                                 @RequestParam("env") Environment environment,
                                                                 @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                                 @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                                 @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            return new ResponseEntity<>(logService.searchLogByEventDescriptionAndEnvIgnoreCase(keyword, securityService.getUserAuthenticated().getId(), environment, status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = "archive")
    public ResponseEntity<Log> archiveLog(@RequestParam("archive") Long logId) {
        Log log = logService.getLogById(logId).get();

        if (log != null && log.getUser().getId() == securityService.getUserAuthenticated().getId()) {
            try {
                log.setStatus(Status.ARCHIVED);
                return new ResponseEntity<>(logService.update(log), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return null;
    }

    @GetMapping(params = "delete")
    public ResponseEntity<Log> deleteLog(@RequestParam("delete") Long logId) {
        Log log = logService.getLogById(logId).get();

        if (log != null && log.getUser().getId() == securityService.getUserAuthenticated().getId()) {
            try {
                log.setStatus(Status.DELETED);
                return new ResponseEntity<>(logService.update(log), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return null;
    }

    @GetMapping(params = "restore")
    public ResponseEntity<Log> restoreLog(@RequestParam("restore") Long logId) {
        Log log = logService.getLogById(logId).get();

        if (log != null && log.getUser().getId() == securityService.getUserAuthenticated().getId()) {
            try {
                log.setStatus(Status.ACTIVE);
                return new ResponseEntity<>(logService.update(log), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return null;
    }

    @GetMapping("/list")
    public List<Log> getLogs() {
        return logService.getLogsByUserId(securityService.getUserAuthenticated().getId());
    }

    @GetMapping("/teste")
    public ResponseEntity<User> getLogTeste() {
        try {
            return new ResponseEntity<>(securityService.getUserAuthenticated(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}