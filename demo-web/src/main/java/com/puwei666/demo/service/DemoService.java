package com.puwei666.demo.service;

import com.puwei666.demo.dao.DemoDao;
import com.puwei666.demo.po.DemoPo;
import com.puwei666.demo.vo.DemoResp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public DemoResp getDemo(int id) {
        return parseDemo(demoDao.getDemoPo(id));
    }

    public List<DemoResp> listDemos() {
        List<DemoResp> list = new ArrayList<>();
        demoDao.listDemoPos().forEach(d -> {
            list.add(parseDemo(d));
        });
        return list;
    }

    private DemoResp parseDemo(DemoPo demoPo) {
        if (demoPo == null) {
            return null;
        }
        DemoResp demoResp = new DemoResp();
        demoResp.setColumn1(demoPo.getColumn1());
        demoResp.setDemoColumn2(demoPo.getDemoColumn2());
        return demoResp;
    }
}
