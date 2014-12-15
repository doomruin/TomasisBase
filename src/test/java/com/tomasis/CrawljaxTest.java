package com.tomasis;

import com.crawljax.browser.EmbeddedBrowser;
import com.crawljax.core.CrawljaxRunner;
import com.crawljax.core.configuration.BrowserConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import com.crawljax.browser.EmbeddedBrowser.BrowserType;
import com.crawljax.condition.NotXPathCondition;
import com.crawljax.core.CrawljaxRunner;
import com.crawljax.core.configuration.BrowserConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration.CrawljaxConfigurationBuilder;
import com.crawljax.core.configuration.Form;
import com.crawljax.core.configuration.InputSpecification;

/**

/**
 * Created by Dreamwalker on 2014/12/11.
 */
public class CrawljaxTest {
    public static void main(String[] args){

        CrawljaxConfiguration.CrawljaxConfigurationBuilder builder =
                CrawljaxConfiguration.builderFor("http://http://v.baidu.com/v?ct=301989888&rn=20&pn=0&db=0&s=25&word=%E5%B0%8F%E7%B1%B3%E7%A9%BA%E6%B0%94%E8%BF%9B%E5%8C%96%E5%99%A8&ie=utf-8");
        //builder.setBrowserConfig(new BrowserConfiguration(EmbeddedBrowser.BrowserType.CHROME, 2));
        CrawljaxRunner crawljax = new CrawljaxRunner(builder.build());
        crawljax.call();
    }


//        private static final long WAIT_TIME_AFTER_EVENT = 200;
//        private static final long WAIT_TIME_AFTER_RELOAD = 20;
//        private static final String URL = "http://demo.crawljax.com";
//
//        /**
//         * Run this method to start the crawl.
//         *
//         * @throws IOException
//         *             when the output folder cannot be created or emptied.
//         */
//        public static void main(String[] args) throws IOException {
//            CrawljaxConfigurationBuilder builder = CrawljaxConfiguration.builderFor(URL);
//            builder.crawlRules().insertRandomDataInInputForms(false);
//
//            // click these elements
//            builder.crawlRules().clickDefaultElements();
//            builder.crawlRules().click("div");
//
//            builder.setMaximumStates(10);
//            builder.setMaximumDepth(3);
//            builder.crawlRules().clickElementsInRandomOrder(true);
//
//            // Set timeouts
//            builder.crawlRules().waitAfterReloadUrl(WAIT_TIME_AFTER_RELOAD, TimeUnit.MILLISECONDS);
//            builder.crawlRules().waitAfterEvent(WAIT_TIME_AFTER_EVENT, TimeUnit.MILLISECONDS);
//
//
//            // We want to use two browsers simultaneously.
//            builder.setBrowserConfig(new BrowserConfiguration(BrowserType.FIREFOX, 1));
//
//            CrawljaxRunner crawljax = new CrawljaxRunner(builder.build());
//            crawljax.call();
//
//        }
//
//        private static InputSpecification getInputSpecification() {
//            InputSpecification input = new InputSpecification();
//            Form contactForm = new Form();
//            contactForm.field("male").setValues(true, false);
//            contactForm.field("female").setValues(false, true);
//            contactForm.field("name").setValues("Bob", "Alice", "John");
//            contactForm.field("phone").setValues("1234567890", "1234888888", "");
//            contactForm.field("mobile").setValues("123", "3214321421");
//            contactForm.field("type").setValues("Student", "Teacher");
//            contactForm.field("active").setValues(true);
//            input.setValuesInForm(contactForm).beforeClickElement("button").withText("Save");
//            return input;
//        }

}
