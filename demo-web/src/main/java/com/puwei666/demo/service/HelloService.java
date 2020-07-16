package com.puwei666.demo.service;

import com.puwei666.demo.dao.HelloDao;
import com.puwei666.demo.po.HelloPo;
import com.puwei666.demo.vo.HelloResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    @Autowired
    private HelloDao helloDao;

    public HelloResp get(int id) {
        return parseHello(helloDao.get(id));
    }

    public List<HelloResp> list() {
        List<HelloResp> list = new ArrayList<>();
        helloDao.list().forEach(d -> {
            list.add(parseHello(d));
        });
        return list;
    }

    private HelloResp parseHello(HelloPo helloPo) {
        if (helloPo == null) {
            return null;
        }
        HelloResp helloResp = new HelloResp();
        helloResp.setColumn1(helloPo.getColumn1());
        helloResp.setColumn2(helloPo.getColumn2());
        return helloResp;
    }
}
