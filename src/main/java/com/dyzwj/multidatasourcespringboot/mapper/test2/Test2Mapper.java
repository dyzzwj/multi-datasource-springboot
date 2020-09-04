package com.dyzwj.multidatasourcespringboot.mapper.test2;

import com.dyzwj.multidatasourcespringboot.pojo.Test2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Test2Mapper {

    @Select("select id,name from user2 where id = #{id}")
    public Test2 findTest2ById(@Param("id") String id);
}
