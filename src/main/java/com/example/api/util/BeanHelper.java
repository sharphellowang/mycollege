package com.example.api.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean操作类
 */
public class BeanHelper {

	public static <T> T copyProperties(Object source, Class<T> targetClazz, String... ignoreProperties) {
		if (source == null) {
			return null;
		}
		T target = BeanUtils.instantiateClass(targetClazz);
		BeanUtils.copyProperties(source, target, ignoreProperties);
		return target;
	}

	public static <T> T copyProperties(Object source, T target, String... ignoreProperties) {
		if (source == null) {
			return null;
		}
		BeanUtils.copyProperties(source, target, ignoreProperties);
		return target;
	}

	public static <T, S> List<T> copyList(List<S> sourceList, Class<T> targetClazz, String... ignoreProperties) {
		if (sourceList == null) {
			return null;
		}
		List<T> list = new ArrayList<T>(sourceList.size());
		if (sourceList.isEmpty()) {
			return list;
		}
		T item;
		for (Object source : sourceList) {
			item = BeanUtils.instantiateClass(targetClazz);
			BeanUtils.copyProperties(source, item, ignoreProperties);
			list.add(item);
		}
		return list;
	}

	public static <T, S> List<T> copyList(List<S> sourceList, BeanConvertor<T, S> convertor) {
		if (sourceList == null) {
			return null;
		}
		List<T> list = new ArrayList<T>(sourceList.size());
		if (sourceList.isEmpty()) {
			return list;
		}
		for (S source : sourceList) {
			list.add(convertor.toBean(source));
		}
		return list;
	}

	/**
	 * @param <T>
	 *            target class
	 * @param <S>
	 *            source class
	 */
	public interface BeanConvertor<T, S> {
		T toBean(S source);
	}
}
