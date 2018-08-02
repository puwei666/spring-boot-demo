package com.puwei666.demo.dao;


import com.puwei666.demo.po.DemoPo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DemoDao {

  @Select("select * from demo_table where id=#{id}")
  @Results({
      @Result(column = "demo_column1",property = "column1")
  })
  DemoPo getDemoPo(int id);

  @Select("select * from demo_table")
  @Results({
      @Result(column = "demo_column1",property = "column1")
  })
  List<DemoPo> listDemoPos();
}
