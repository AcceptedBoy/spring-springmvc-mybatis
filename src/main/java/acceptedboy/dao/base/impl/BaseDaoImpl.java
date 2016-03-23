package com.acceptedboy.dao.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import com.acceptedboy.dao.base.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource(name="sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate;

	private Class<T> entityClass;
	
	private static final String INSERT = "insert";
	private static final String INSERTSELECTIVE = "insertSelective";
	private static final String DELETEBYPARAMETERS = "deleteByPrimaryKey";
	private static final String SELECTBYPRIMARYKEY = "selectByPrimaryKey";
	private static final String SELECTBYPARAMETERS = "selectByParameters";
	private static final String UPDATEBYPRIMARYKEY = "updateByPrimaryKey";

	@Override
	public int insert(T t) {
		
		return sqlSessionTemplate.insert(getStatement(INSERT), t);
	}

	@Override
	public int insertSelective(T t) {
		
		return sqlSessionTemplate.insert(getStatement(INSERTSELECTIVE), t);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		
		return sqlSessionTemplate.delete(getStatement(DELETEBYPARAMETERS), id);
	}

	@Override
	public T selectByPrimaryKey(String id) {
		
		return sqlSessionTemplate.selectOne(getStatement(SELECTBYPRIMARYKEY), id);
	}

	@Override
	public List<T> selectByParameters(Map<String, Object> map) {
		
		return sqlSessionTemplate.selectList(getStatement(SELECTBYPARAMETERS), map);
	}

	@Override
	public int updateByPrimaryKey(T t) {
		
		return sqlSessionTemplate.update(getStatement(UPDATEBYPRIMARYKEY), t);
	}

	/**
	 * @description 获取类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		if (this.entityClass == null) {
			this.entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return this.entityClass;
	}
	
	protected String getNamespace() {

		return this.getClass().getInterfaces()[0].toString().split(" ")[1]
				.toString();
	}
	
	protected String getStatement(String methodName) {
		
		return getNamespace() + "." + methodName;
	}
}
