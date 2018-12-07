package com.linyi.Test;

import com.linyi.mapper.UserMapper;
import com.linyi.model.User;
import com.linyi.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {

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
}
