package com.linyi.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.linyi.mapper.UserMapper;
import com.linyi.model.User;
import com.linyi.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AppTest {

    @Test
    public  void  test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
    }
    @Test
    public void  test2(){
        StringBuilder stringBuilder=new StringBuilder();
        // stringBuilder append 无法拼接 null
        //stringBuilder.append(null);
    }
    @Test
    public void test3(){
      List<User> list=  MyBatisUtil.getSqlSession().getMapper(UserMapper.class).selectAll();
    }
    @Test
    public void  test4(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("springContext.xml");
        System.out.println(applicationContext.getBean(DruidDataSource.class));
    }
    @Test
    public void  test5(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("springContext.xml");
        System.out.println(applicationContext.getBean("userMapper",UserMapper.class));
    }
}
