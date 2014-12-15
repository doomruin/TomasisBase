package com.tomas.download;

import com.tomas.config.MyConst;
import com.tomas.dao.DoubanDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreamwalker on 2014/11/18.
 * 按年代搜索电影，只需填入需要的年份
 */

public class DoubanIdDLThead extends Thread{
    private int year;
    private int start=0;
    private List<String> list = new ArrayList<String>();

    public DoubanIdDLThead(int year){
        this.year=year;
    }
    @Override
    public void run() {
        super.run();
        //http://movie.douban.com/tag/1965?start=20&type=T
        while(true) {
            try {
                Document doc = Jsoup.connect(MyConst.DBM_LIST_URL + year + "?start="+start)
                                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
                                .get();
                //Document doc = Jsoup.connect("http://en.wikipedia.org/w/index.php?title=Category:2014_films").get();
                //System.out.println(doc.html());
                Elements es =doc.getElementsByClass("nbg");
                if(es.isEmpty()){
                    System.out.println("year:  "+year+" end ");
                    System.out.println(list.size());
                    break;
                }
                for(Element e : es){
                    String s = e.attr("href");
                    System.out.println(s);
                    //http://movie.douban.com/subject/21318488/
                    //获取豆瓣ID//e.attr("href").substring(32,s.length()-1)
                    list.add(e.attr("href").substring(32,s.length()-1));

                }
                start+=20;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //////////////////////////////
        //////////////////////////////
        inserts();
        //////////////////////////////
        //////////////////////////////
    }
    //插入数据
    private void inserts(){
        SqlSession sqlSession = getSessionFactory().openSession();
        DoubanDao doubanDao = sqlSession.getMapper(DoubanDao.class);
        doubanDao.insertDoubanId(list);
        sqlSession.commit();
        sqlSession.close();
    }


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
}
