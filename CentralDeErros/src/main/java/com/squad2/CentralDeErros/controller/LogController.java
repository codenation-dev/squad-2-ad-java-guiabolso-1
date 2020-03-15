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

    @GetMapping(params = {"orderBy", "direction"})
    public List<Log> findAllOrderBy(@RequestParam("orderBy") String orderBy, @RequestParam("direction") Sort.Direction direction) {
        return logService.findAllOrderBy(orderBy, direction);
    }

    @GetMapping(params = {"userId", "page", "size", "sortBy", "direction"})
    public List<Log> findAllByUserId(@RequestParam("userId") Long userId,
                                     @RequestParam(value = "page", required = false, defaultValue = "0") Short page,
                                     @RequestParam(value = "size", required = false, defaultValue = "10") Short size,
                                     @RequestParam(value = "sortBy", required = false, defaultValue = "ID_LOG") String sortBy,
                                     @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        return logService.findAllByUserId(userId, page, size, sortBy, direction);
    }
}
