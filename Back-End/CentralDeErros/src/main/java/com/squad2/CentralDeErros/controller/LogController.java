package com.squad2.CentralDeErros.controller;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.entity.Role;
import com.squad2.CentralDeErros.entity.enumerate.Environment;
import com.squad2.CentralDeErros.entity.enumerate.Status;
import com.squad2.CentralDeErros.service.LogService;
import com.squad2.CentralDeErros.service.RoleService;
import com.squad2.CentralDeErros.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/log")
@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public class LogController {

    @Autowired
    private LogService logService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private RoleService roleService;

    @GetMapping(params = {"id"})
    public ResponseEntity<Optional<Log>> getLogById(@RequestParam("id") Long id) {
        Optional<Log> log = logService.getLogById(id);

        if(!log.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if (log.get().getUser().getId() == securityService.getUserAuthenticated().getId()) {
            try {
                return new ResponseEntity<>(logService.getLogById(id), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }


    @GetMapping()
    public ResponseEntity<List<Log>> getLogsByAuthenticatedUser(@RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                    @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                    @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                    @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                    @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.getLogs(status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(logService.getLogsByUserId(securityService.getUserAuthenticated().getId(), status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = "user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Log>> getLogsByUserAdminOnly(@RequestParam(value = "user", required = true) Long user,
                                                                @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                                @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                                @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                                @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                                @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.getLogsByUserId(user, status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"env"})
    public ResponseEntity<List<Log>> getLogsByAuthenticatedUserAndEnv(@RequestParam("env") Environment environment,
                                          @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                          @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                          @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                          @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                          @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.getLogsByEnv(environment, status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(logService.getLogsByUserIdAndEnv(securityService.getUserAuthenticated().getId(), environment, status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"env", "user"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Log>> getLogsByUserAndEnvAdminOnly(@RequestParam("env") Environment environment,
                                                                      @RequestParam("user") Long user,
                                                                      @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                                      @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                                      @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                                      @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                                      @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.getLogsByUserIdAndEnv(user, environment, status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"search"})
    public ResponseEntity<List<Log>> searchLogByEventDescriptionIgnoreCase(@RequestParam("search") String keyword,
                                                 @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                 @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                 @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.searchLogByEventDescriptionIgnoreCaseAdminOnly(keyword, status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(logService.searchLogByEventDescriptionIgnoreCase(keyword, securityService.getUserAuthenticated().getId(), status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"search", "user"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Log>> searchLogByEventDescriptionAndUserIdIgnoreCaseAdminOnly(@RequestParam("search") String keyword,
                                                                           @RequestParam("user") Long user,
                                                                           @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                                           @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                                           @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                                           @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                                           @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.searchLogByEventDescriptionIgnoreCase(keyword, user, status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
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
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.searchLogByEventDescriptionAndEnvIgnoreCaseAdmin(keyword, environment, status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(logService.searchLogByEventDescriptionAndEnvIgnoreCase(keyword, securityService.getUserAuthenticated().getId(), environment, status, page, size, sortBy, direction), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = {"search", "env", "user"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Log>> searchLogByEventDescriptionAndEnvAndUserIdIgnoreCaseAdminOnly(@RequestParam("search") String keyword,
                                                                                 @RequestParam("env") Environment environment,
                                                                                 @RequestParam("user") Long user,
                                                                                 @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") Status status,
                                                                                 @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                                                                 @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                                                                 @RequestParam(value = "sortBy", required = false, defaultValue = "ID") String sortBy,
                                                                                 @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        try {
            Set<Role> role = securityService.getUserAuthenticated().getRoles();

            if(role.contains(roleService.findByRole("ADMIN")))
                return new ResponseEntity<>(logService.searchLogByEventDescriptionAndEnvIgnoreCase(keyword, user, environment, status, page, size, sortBy, direction), HttpStatus.OK);

            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(params = "archive")
    public ResponseEntity<Log> archiveLog(@RequestParam("archive") Long logId) {
        Optional<Log> log = logService.getLogById(logId);

        if (!log.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Set<Role> role = securityService.getUserAuthenticated().getRoles();

        if (log.get().getUser().getId() == securityService.getUserAuthenticated().getId() || role.contains(roleService.findByRole("ADMIN"))) {
            try {
                log.get().setStatus(Status.ARCHIVED);
                return new ResponseEntity<>(logService.update(log.get()), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping(params = "delete")
    public ResponseEntity<Log> deleteLog(@RequestParam("delete") Long logId) {
        Optional<Log> log = logService.getLogById(logId);

        if (!log.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Set<Role> role = securityService.getUserAuthenticated().getRoles();

        if (log.get().getUser().getId() == securityService.getUserAuthenticated().getId() || role.contains(roleService.findByRole("ADMIN"))) {
            try {
                log.get().setStatus(Status.DELETED);
                return new ResponseEntity<>(logService.update(log.get()), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping(params = "restore")
    public ResponseEntity<Log> restoreLog(@RequestParam("restore") Long logId) {
        Optional<Log> log = logService.getLogById(logId);

        if (!log.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Set<Role> role = securityService.getUserAuthenticated().getRoles();

        if (log.get().getUser().getId() == securityService.getUserAuthenticated().getId() || role.contains(roleService.findByRole("ADMIN"))) {
            try {
                log.get().setStatus(Status.ACTIVE);
                return new ResponseEntity<>(logService.update(log.get()), HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}