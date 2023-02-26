package com.xkcoding.json.support;

import com.xkcoding.json.exception.SimpleJsonException;

import java.util.List;

/**
 * <p>
 * 序列化反序列化操作
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 15:01
 */
public interface JsonAdapter {
	/**
	 * 序列化
	 *
	 * @param obj 对象
	 * @return json 字符串
	 * @throws SimpleJsonException 自定义异常
	 */
	String serialize(Object obj) throws SimpleJsonException;

	/**
	 * 反序列化
	 *
	 * @param <T>     类泛型
	 * @param jsonStr json 字符串
	 * @param clazz   对象类型
	 * @return 对象
	 * @throws SimpleJsonException 自定义异常
	 */
	<T> T deserialize(String jsonStr, Class<T> clazz) throws SimpleJsonException;

	/**
	 * 反序列化为集合
	 *
	 * @param <T>     类泛型
	 * @param jsonStr json 字符串
	 * @param clazz   对象类型
	 * @return 对象集合
	 * @throws SimpleJsonException 自定义异常
	 */
	<T> List<T> deserializeList(String jsonStr, Class<T> clazz) throws SimpleJsonException;
}
