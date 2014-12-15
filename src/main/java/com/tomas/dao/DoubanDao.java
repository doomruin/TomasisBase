package com.tomas.dao;

import com.tomas.download.model.DoubanMovie;

import java.util.List;

/**
 * Created by Dreamwalker on 2014/11/14.
 */
public interface DoubanDao {
    public void create(DoubanMovie dbm);
    public void insertDoubanId(List<String> doubanIds);
    public DoubanMovie findById(int id);
}
