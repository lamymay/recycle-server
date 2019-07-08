package com.arc.recycle.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：t_sys_menu控制层
 *
 * @author yechao
 * @date 2018-10-18 16:37:18
 */
@Slf4j
@RestController
@RequestMapping(path = "/test")
public class TestController {


    @GetMapping("/code")
    public ResponseEntity code() {
        Map<String, Object> map = new HashMap<String, Object>();
        ResponseEntity responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/code2")
    public ResponseEntity code2() {
        ResponseEntity responseEntity = new ResponseEntity<Object>("abc", HttpStatus.OK);
        return responseEntity;
    }

}
