package com.dyzwj.multidatasourcespringboot.service;

import com.dyzwj.multidatasourcespringboot.mapper.test1.Test1Mapper;
import com.dyzwj.multidatasourcespringboot.mapper.test2.Test2Mapper;
import com.dyzwj.multidatasourcespringboot.pojo.Test1;
import com.dyzwj.multidatasourcespringboot.pojo.Test2;
import org.springframework.beans.factory.annotation.Autowired;

public class TestService {

    @Autowired
    private Test1Mapper test1Mapper;

    @Autowired
    private Test2Mapper test2Mapper;

    public Test1 findTest1ById(String id){
        return test1Mapper.finaTest1ById(id);
    }

    public Test2 findTest2ById(String id){
        return test2Mapper.findTest2ById(id);
    }
}

