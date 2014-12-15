package com.tomasis;

import com.tomas.config.MyConst;
import com.tomas.dao.DoubanDao;
import com.tomas.download.model.DoubanMovie;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreamwalker on 2014/11/18.
 */
public class DoubanIdInsertTest {
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = MyConst.CONFIG_URI;

        try {
            Reader reader = new FileReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        SqlSession sqlSession = getSessionFactory().openSession();
//            UserDao userMapper = sqlSession.getMapper(UserDao.class);
//            User user = userMapper.findById(1);
//            System.out.println(user.getName());
        DoubanDao doubanDao = sqlSession.getMapper(DoubanDao.class);
       List<String> ss =new ArrayList<String>();
        ss.add("1234567890");
        ss.add("1234567890");ss.add("1234567890");
        ss.add("1234567890");
        ss.add("1234567890");
        doubanDao.insertDoubanId(ss);
        sqlSession.commit();


        sqlSession.close();

    }
}
