package com.tomas.dao;

import com.tomas.download.model.User;

/**
 * Created by Dreamwalker on 2014/11/13.
 */
public interface UserDao {
    public User findById(int id);
}
