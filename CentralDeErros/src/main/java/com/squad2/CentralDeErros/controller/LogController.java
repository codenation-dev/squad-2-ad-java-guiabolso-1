package com.squad2.CentralDeErros.controller;

import com.squad2.CentralDeErros.entity.Log;
import com.squad2.CentralDeErros.entity.enumerate.Ambiente;
import com.squad2.CentralDeErros.entity.enumerate.Status;
import com.squad2.CentralDeErros.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping(params = {"userId"})
    public List<Log> findAllByUserId(@RequestParam("userId") Long userId,
                                     @RequestParam(value = "status", required = false, defaultValue = "ATIVO") Status status,
                                     @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                     @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                     @RequestParam(value = "sortBy", required = false, defaultValue = "ID_LOG") String sortBy,
                                     @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.findAllByUserId(userId, status, page, size, sortBy, direction);
    }

    @GetMapping(params = {"userId", "ambiente"})
    public List<Log> findAllByUserIdandAmbiente(@RequestParam("userId") Long userId,
                                     @RequestParam("ambiente") Ambiente ambiente,
                                     @RequestParam(value = "status", required = false, defaultValue = "ATIVO") Status status,
                                     @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                     @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                     @RequestParam(value = "sortBy", required = false, defaultValue = "ID_LOG") String sortBy,
                                     @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.findAllByUserIdandAmbiente(userId, ambiente, status, page, size, sortBy, direction);
    }
}