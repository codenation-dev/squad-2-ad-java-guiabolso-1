package com.squad2.CentralDeErros.controller;

import com.squad2.CentralDeErros.entity.Log;
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

    @GetMapping("")
    public List<Log> findAll() {
        return logService.findAll();
    }

    @GetMapping(params = {"orderBy", "direction"})
    public List<Log> findAllOrderBy(@RequestParam("orderBy") String orderBy,@RequestParam("direction") Sort.Direction direction) {
        return logService.findAllOrderBy(orderBy, direction);
    }

    @GetMapping(params = "userId")
    public List<Log> findAllByUserId(@RequestParam Long userId) {
        return logService.findAllByUserId(userId);
    }
}
