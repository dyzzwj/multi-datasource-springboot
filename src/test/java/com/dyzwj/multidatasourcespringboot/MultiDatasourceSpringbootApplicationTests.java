package com.dyzwj.multidatasourcespringboot;

import com.dyzwj.multidatasourcespringboot.mapper.test1.Test1Mapper;
import com.dyzwj.multidatasourcespringboot.mapper.test2.Test2Mapper;
import com.dyzwj.multidatasourcespringboot.pojo.Test1;
import com.dyzwj.multidatasourcespringboot.pojo.Test2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDatasourceSpringbootApplicationTests {

    @Autowired
    private Test1Mapper test1Mapper;

    @Autowired
    private Test2Mapper test2Mapper;


    @Qualifier("test1DataSource")
    @Autowired
    private DataSource dataSource;


    @Test
    public void contextLoads() {


        Test1 test1 = test1Mapper.finaTest1ById("1");
        Test2 test2 = test2Mapper.findTest2ById("1");
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(dataSource);
    }

}
