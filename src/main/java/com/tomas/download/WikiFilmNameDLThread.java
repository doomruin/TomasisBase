package com.tomas.download;

import com.tomas.config.MyConst;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Dreamwalker on 2014/11/18.
 */
public class WikiFilmNameDLThread extends Thread{
    @Override
    public void run() {
        super.run();
        while(true) {
            try {

                Document doc = Jsoup.connect("http://en.wikipedia.org/w/index.php?title=Category:2014_films").get();
                Elements es =doc.select("table tr td li a");
                System.out.println(es.isEmpty());
                for(Element e: es){
                    System.out.println(e.html());
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //inserts();
    }
}
