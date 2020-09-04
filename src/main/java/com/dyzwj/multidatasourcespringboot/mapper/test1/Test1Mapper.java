package com.dyzwj.multidatasourcespringboot.mapper.test1;

import com.dyzwj.multidatasourcespringboot.pojo.Test1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


//@Mapper
public interface Test1Mapper {


    @Select("select id,name from user1 where id = #{id}")
    public Test1 finaTest1ById(@Param("id") String id);

}
