package com.itecheasy.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.itecheasy.common.PageList;


public class BeanUtils {
	
	public static <T, E> void copyProperties(T source, E target,String[] ignoreParams) {
		copy(source, target, ignoreParams);
	}
	
	public static <T, E> void copyProperties(T source, E target) {
		copy(source, target, null);
	}
	public static <T, E> E copyProperties(T source, Class<E> type) {
		if(source == null)
			return null;
		E target;
		try {
			target = type.newInstance();
			copyProperties(source,target,null);
			return target;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static <T, E> E copyProperties(T source, Class<E> type,String[] ignoreParams) {
		E target;
		try {
			target = type.newInstance();
			copyProperties(source,target,ignoreParams);
			return target;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	private static <T, E> E copy(T source, E target, String[] ignoreParams) {
		if (source == null || target == null)
			return null;
		try {
			// E target = type.newInstance();
			Method[] getMethods = source.getClass().getDeclaredMethods();
			Method[] setMethods = target.getClass().getDeclaredMethods();
			String mName = null;
			String fieldName = null;
			for (Method m : getMethods) {
				mName = m.getName();
				if (mName.startsWith("get")) {
					fieldName = mName.substring(3);
				} else if (mName.startsWith("is")) {
					fieldName = mName.substring(2);
				} else {
					continue;
				}
				boolean isIgnore = false;
				if(ignoreParams != null)
					for(String fn : ignoreParams){
						if(fn.equalsIgnoreCase(fieldName)){
							isIgnore = true;
							break;
						}
					}
				if(isIgnore)
					continue;
				Object o = m.invoke(source, new Object[] {});
				String setMethodName = "set" + fieldName;
				for (Method sm : setMethods) {
					if (sm.getName().equalsIgnoreCase(setMethodName)) {
						Class<?> paramType = sm.getParameterTypes()[0];
						if (paramType.isPrimitive() && o == null) {
							if (paramType.getName().equals("boolean"))
								o = Boolean.FALSE;
							else
								o = Byte.valueOf("0");
						}
						sm.invoke(target, new Object[] { o });
						break;
					}
				}
			}
			return target;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static <T,E> List<E> copyList(List<T> source, Class<E> type) {
		if(source == null || type == null)
			return null;
		List<E> result = new ArrayList<E>();
		E temp = null;
		for (T o : source) {
			temp = BeanUtils.copyProperties(o, type);
			result.add(temp);
		}
		return result;
	}
	
	public static <T,E> List<E> copyList(List<T> source, Class<E> type, String[] ignoreParams) {
		if(source == null || type == null)
			return null;
		List<E> result = new ArrayList<E>();
		E temp = null;
		for (T o : source) {
			temp = BeanUtils.copyProperties(o, type,ignoreParams);
			result.add(temp);
		}
		return result;
	}
	
	public static <T, E> PageList<E> copyPageList(PageList<T> source,
			Class<E> targetType) {
		return copyPageList(source, targetType, null);
	}

	public static <T, E> PageList<E> copyPageList(PageList<T> source,
			Class<E> targetType, String[] ignoreParams) {
		if (source == null || targetType == null)
			return null;
		PageList<E> result = new PageList<E>();
		List<E> list = new ArrayList<E>();
		E temp = null;
		for (T o : source.getData()) {
			temp = BeanUtils.copyProperties(o, targetType, ignoreParams);
			list.add(temp);
		}
		result.setData(list);
		result.setPage(source.getPage());
		return result;
	}
}
