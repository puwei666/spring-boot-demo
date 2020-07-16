package com.puwei666.demo.controller;

import com.puwei666.demo.annotation.Access;
import com.puwei666.demo.exception.InputException;
import com.puwei666.demo.service.HelloService;
import com.puwei666.demo.vo.HelloResp;
import com.puwei666.demo.vo.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    Object hello() {
        return new ResponseMessage<>(0, "hello world !");
    }

    @GetMapping("/list")
    Object access1(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Access1 request controller");
        List<HelloResp> helloResps = helloService.list();
        return new ResponseMessage<List<HelloResp>>(0, helloResps);
    }

    @GetMapping("/get")
    @Access(false)
    Object access2(Integer id, HttpServletRequest request, HttpServletResponse response) throws InputException {
        logger.info("Access2 request controller");
        if (id == null) {
            throw new InputException();
        }
        HelloResp resp = helloService.get(id);
        return new ResponseMessage<HelloResp>(0, resp);
    }
}
