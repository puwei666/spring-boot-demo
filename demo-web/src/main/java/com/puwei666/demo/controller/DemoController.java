package com.puwei666.demo.controller;

import com.puwei666.demo.annotation.Access;
import com.puwei666.demo.exception.InputException;
import com.puwei666.demo.service.DemoService;
import com.puwei666.demo.vo.DemoResp;
import com.puwei666.demo.vo.ResponseMessage;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    Object hello() {
        return new ResponseMessage<>(0, "hello world !");
    }

    @GetMapping("/list_demos")
    Object access1(HttpServletRequest request, HttpServletResponse response){
        logger.info("Access1 request controller");
        List<DemoResp> demoResps = demoService.listDemos();
        return new ResponseMessage<List<DemoResp>>(0,demoResps);
    }

    @GetMapping("/get_demo")
    @Access(false)
    Object access2(Integer id ,HttpServletRequest request, HttpServletResponse response) throws InputException {
        logger.info("Access2 request controller");
        if(id==null){
            throw new InputException();
        }
        DemoResp resp = demoService.getDemo(id);
        return new ResponseMessage<DemoResp>(0,resp);
    }
}
