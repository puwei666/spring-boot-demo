package com.puwei666.demo.controller;

import com.puwei666.demo.annotation.Access;
import com.puwei666.demo.exception.InputException;
import com.puwei666.demo.service.HelloService;
import com.puwei666.demo.vo.HelloResp;
import com.puwei666.demo.vo.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("hello")
@Api(tags = "Hello Demo")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/display")
    @ApiOperation(value = "显示hello world")
    public Object hello(
            @ApiParam(value = "id, 任意值，也可以不填", defaultValue = "") @RequestParam(defaultValue = "") String id) {
        return new ResponseMessage<>(0, "hello world, id:"+ id);
    }

    @GetMapping("/list")
    public Object access1(HttpServletRequest request, HttpServletResponse response) {
        log.info("Access1 request controller");
        List<HelloResp> helloResps = helloService.list();
        return new ResponseMessage<List<HelloResp>>(0, helloResps);
    }

    @GetMapping("/get")
    @Access(false)
    public Object access2(Integer id, HttpServletRequest request, HttpServletResponse response) throws InputException {
        log.info("Access2 request controller");
        if (id == null) {
            throw new InputException();
        }
        HelloResp resp = helloService.get(id);
        return new ResponseMessage<HelloResp>(0, resp);
    }
}
