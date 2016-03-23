package com.acceptedboy.dao.impl;

import org.springframework.stereotype.Repository;

import com.acceptedboy.dao.UserDao;
import com.acceptedboy.dao.base.impl.BaseDaoImpl;
import com.acceptedboy.po.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}
