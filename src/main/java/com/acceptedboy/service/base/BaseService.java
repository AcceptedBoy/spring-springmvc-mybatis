package com.acceptedboy.service.base;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

	/**
	 * @description 添加一条记录
	 * @param t
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * @description 有选择性添加记录
	 * @param t
	 * @return
	 */
	public int insertSelective(T t);
	
	/**
	 * @description 通过主键删除记录
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(String id);
	
	/**
	 * @description 通过主键查找记录
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(String id);
	
	/**
	 * @description 通过map匹配相应记录并获取
	 * @param map
	 * @return
	 */
	public List<T> selectByParameters(Map<String, Object> map);
	
	/**
	 * @description 通过对象的主键来更新记录
	 * @param t
	 * @return
	 */
	public int updateByPrimaryKey(T t);
}
