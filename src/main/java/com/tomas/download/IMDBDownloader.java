package com.tomas.download;

/**
 * Created by Dreamwalker on 2014/11/18.
 */
public class IMDBDownloader {
    public static void main(String[] args){
        new WikiFilmNameDLThread().start();
    }
}
