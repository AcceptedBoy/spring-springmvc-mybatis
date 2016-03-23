package com.acceptedboy.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.acceptedboy.dao.base.BaseDao;
import com.acceptedboy.service.base.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	protected BaseDao<T> baseDao;
	
	@Override
	public int insert(T t) {
		
		return baseDao.insert(t);
	}

	@Override
	public int insertSelective(T t) {
		
		return baseDao.insertSelective(t);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public T selectByPrimaryKey(String id) {
		
		return baseDao.selectByPrimaryKey(id);
	}

	@Override
	public List<T> selectByParameters(Map<String, Object> map) {
		
		return baseDao.selectByParameters(map);
	}

	@Override
	public int updateByPrimaryKey(T t) {
		
		return baseDao.updateByPrimaryKey(t);
	}

}
