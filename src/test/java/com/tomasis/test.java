package com.tomasis;

import com.tomas.dao.UserDao;
import com.tomas.download.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            String resource = "E:/workspace/TomasisBase/src/main/resources/configuration.xml";

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
            String resource = "E:/workspace/TomasisBase/src/main/resources/configuration.xml";// path of the mybatis configuration file.
            File file = new File(resource);
            System.out.println(file.exists());
            SqlSession sqlSession = getSessionFactory().openSession();
            UserDao userMapper = sqlSession.getMapper(UserDao.class);
            User user = userMapper.findById(1);
            System.out.println(user.getName());

        }

}
