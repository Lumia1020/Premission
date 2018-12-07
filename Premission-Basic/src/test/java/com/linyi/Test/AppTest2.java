package com.linyi.Test;

import com.linyi.controller.UserController;
import com.linyi.mapper.PermissionMapper;
import com.linyi.mapper.RoleMapper;
import com.linyi.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest2 {
    @Test
    public void test1(){
        new UserController().test1();
    }

    @Test
    public void test2(){
         ApplicationContext applicationContext=new ClassPathXmlApplicationContext("springContext.xml");
         UserMapper userMapper= applicationContext.getBean(UserMapper.class);
         userMapper.selectAll();
        //System.out.println(applicationContext.getBean(RoleMapper.class));
        //System.out.println(applicationContext.getBean(PermissionMapper.class));
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("springContext.xml");
        applicationContext.getBean(SqlSession.class);
    }
}
