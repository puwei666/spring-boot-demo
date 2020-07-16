package com.puwei666.demo.vo;


import com.puwei666.demo.annotation.CamelName;

@CamelName
public class HelloResp {
    private String column1;
    private String column2;


    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Override
    public String toString() {
        return "HelloResp{" +
                "column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                '}';
    }
}
