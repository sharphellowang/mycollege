package com.example.api.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class MapperUtils {


	/**
	 * 查询一个对象
	 *
	 * @param mapper
	 * @param example
	 * @return
	 */
	public static <T> T selectOneByExample(SelectByExampleMapper<T> mapper, Example example) {
		List<T> list = selectByExample(mapper, example, 1, 1);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * 查询列表
	 * @param mapper
	 * @param example
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> selectByExample(SelectByExampleMapper<T> mapper, Example example){
		return selectByExample(mapper, example, 0, 0);
	}

	/**
	 * 查询列表
	 * @param mapper
	 * @param example
	 * @return
	 */
	public static <T, S> List<T> selectByExample(SelectByExampleMapper<S> mapper, Example example, BeanHelper.BeanConvertor<T, S> convertor){
		return BeanHelper.copyList(selectByExample(mapper, example, 0, 0), convertor);
	}

	/**
	 * 分页获取列表
	 *
	 * @param mapper
	 * @param example
	 * @param pageIndex
	 *            页码。分页则从1起, 不分页则传0
	 * @param pageSize
	 *            每页大小, 不分页则传0
	 * @return
	 */
	public static <T> List<T> selectByExample(SelectByExampleMapper<T> mapper, Example example, int pageIndex, int pageSize) {
		if(pageIndex > 0 && pageSize > 0){
			PageHelper.startPage(pageIndex, pageSize, false);
		}

		try {
			return mapper.selectByExample(example);
		} finally {
			PageHelper.clearPage();
		}
	}

	/**
	 * 分页获取列表
	 *
	 * @param mapper
	 * @param example
	 * @param pageIndex
	 *            页码。从1起
	 * @param pageSize
	 *            每页大小
	 * @param convertor
	 *            Bean转换器
	 * @return
	 */
	public static <T, S> List<T> selectByExample(SelectByExampleMapper<S> mapper, Example example, int pageIndex, int pageSize, BeanHelper.BeanConvertor<T, S> convertor) {
		return BeanHelper.copyList(selectByExample(mapper, example, pageIndex, pageSize), convertor);
	}

	/**
	 * 分页查询
	 *
	 * @param mapper
	 * @param example
	 * @param pageIndex
	 *            页码。从1起
	 * @param pageSize
	 *            每页大小
	 * @return
	 */
	public static <T> Page<T> selectPageByExample(SelectByExampleMapper<T> mapper, Example example, int pageIndex, int pageSize) {
		Page<T> page = PageHelper.startPage(pageIndex, pageSize, true);
		try {
			mapper.selectByExample(example);
		} finally {
			PageHelper.clearPage();
		}
		return page;
	}

}

