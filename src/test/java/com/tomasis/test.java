package com.tomasis;

import com.tomas.config.MyConst;
import com.tomas.dao.DoubanDao;
import com.tomas.dao.UserDao;
import com.tomas.download.model.DoubanMovie;
import com.tomas.download.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileReader;
import java.io.Reader;

/**
 * Created by Dreamwalker on 2014/11/13.
 */
public class test {
    /**
     * myBatis数据库连接测试
     *
     * @author db2admin
     *
     */
        /**
         * 获得MyBatis SqlSessionFactory
         * SqlSessionFactory负责创建SqlSession，一旦创建成功，就可以用SqlSession实例来执行映射语句，commit，rollback，close等方法。
         * @return
         */
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
            DoubanMovie dbm = new DoubanMovie();
            dbm.setDoubanId("11123423");
            dbm.setImageUrl("wwww.wwwwwwwwww.com//shadkfhksh");
            dbm.setInfo("123");
            dbm.setRate(5.6);
            dbm.setSummary("22222222");
            dbm.setReviewCount(20000);
            dbm.setTitle("haha");
            dbm.setOriginalTitle("enen");
            doubanDao.create(dbm);
            sqlSession.commit();

            //DoubanMovie dbm1 = doubanDao.findById(1);
           // System.out.println(dbm1.getInfo());
            sqlSession.close();

        }

}
