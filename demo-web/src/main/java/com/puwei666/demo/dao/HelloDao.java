package com.puwei666.demo.dao;


import com.puwei666.demo.po.HelloPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HelloDao {

    @Select("select * from hello_table where id=#{id}")
    @Results({
            @Result(column = "column1", property = "column1")
    })
    HelloPo get(int id);

    @Select("select * from hello_table")
    @Results({
            @Result(column = "column1", property = "column1")
    })
    List<HelloPo> list();
}
