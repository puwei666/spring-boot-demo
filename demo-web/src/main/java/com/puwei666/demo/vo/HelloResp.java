package com.puwei666.demo.vo;

import com.puwei666.demo.annotation.CamelName;
import lombok.Data;

@Data
@CamelName
public class HelloResp {

    private String column1;

    private String column2;

    @Override
    public String toString() {
        return "HelloResp{" +
                "column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                '}';
    }

}
