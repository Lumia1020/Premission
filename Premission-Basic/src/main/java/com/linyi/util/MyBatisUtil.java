package com.linyi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static String PATH = "mybatis-config.xml";

    static {
        try {
            initSqlSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initSqlSessionFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader(Thread.currentThread().getContextClassLoader(), PATH);
        if (sqlSessionFactory == null) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSession getSqlSession(boolean isAuto) {
        return sqlSessionFactory.openSession(isAuto);
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null)
            sqlSession.close();
    }
}
