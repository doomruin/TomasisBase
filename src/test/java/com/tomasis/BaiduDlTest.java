package com.tomasis;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Created by Dreamwalker on 2014/12/11.
 */
public class BaiduDlTest {
    public static void main(String[] args) {
        try {
            final WebClient webClient = new WebClient();
            final HtmlPage page = webClient.getPage("http://www.youku.com");
            //System.out.println(page.getDocumentURI());
            System.out.println(page.getAnchors().size());
            for(HtmlAnchor h : page.getAnchors()){
                System.out.println(h.getHrefAttribute());
            }
            //HtmlElement e = page.getBody();
            //e.
            //System.out.println(e.getTagName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
