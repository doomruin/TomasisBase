package com.tomas.download;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by Dreamwalker on 2014/11/11.
 */
public class DoubanDownLoader {
    public static void main(String[] args) {
     DoubanIdDLThead dbdl = new DoubanIdDLThead(2014);
        dbdl.start();
    }

}
