package com.puwei666.demo.vo;


import com.puwei666.demo.annotation.CamelName;

@CamelName
public class DemoResp {
  private String column1;
  private String demoColumn2;


  public String getColumn1() {
    return column1;
  }

  public void setColumn1(String column1) {
    this.column1 = column1;
  }

  public String getDemoColumn2() {
    return demoColumn2;
  }

  public void setDemoColumn2(String demoColumn2) {
    this.demoColumn2 = demoColumn2;
  }

  @Override
  public String toString() {
    return "DemoResp{" +
        "column1='" + column1 + '\'' +
        ", demoColumn2='" + demoColumn2 + '\'' +
        '}';
  }
}
