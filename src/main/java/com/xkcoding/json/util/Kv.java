package com.xkcoding.json.util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 继承自 HashMap，提供一些基础的类型转换，方便使用
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @date 2021-01-27 11:50
 */
public class Kv extends HashMap<String, Object> {

	public Object get(String key, Object defaultValue) {
		Object value = super.get(key);
		return (value != null) ? value : defaultValue;
	}

	public <T> ArrayList<T> getArrayList(Object key) {
		Object value = super.get(key);
		return ArrayUtil.toList(value);
	}

	public String getString(Object key) {
		Object value = super.get(key);
		return ObjectUtil.toStr(value);
	}

	public Boolean getBoolean(Object key) {
		Object value = super.get(key);
		return ObjectUtil.toBool(value);
	}

	public boolean getBooleanValue(Object key) {
		Boolean value = getBoolean(key);
		return null != value && value;
	}

	public Integer getInteger(Object key) {
		Object value = super.get(key);
		return ObjectUtil.toInt(value);
	}

	public int getIntValue(Object key) {
		Integer value = getInteger(key);
		return null == value ? 0 : value;
	}

	public Short getShort(Object key) {
		Object value = super.get(key);
		return ObjectUtil.toShort(value);
	}

	public short getShortValue(Object key) {
		Short value = getShort(key);
		return null == value ? 0 : value;
	}

	public Long getLong(Object key) {
		Object value = super.get(key);
		return ObjectUtil.toLong(value);
	}

	public long getLongValue(Object key) {
		Long value = getLong(key);
		return null == value ? 0 : value;
	}

	public Float getFloat(Object key) {
		Object value = super.get(key);
		return ObjectUtil.toFloat(value);
	}

	public float getFloatValue(String key) {
		Float value = getFloat(key);
		return null == value ? 0 : value;
	}

	public Double getDouble(Object key) {
		Object value = super.get(key);
		return ObjectUtil.toDouble(value);
	}

	public double getDoubleValue(String key) {
		Double value = getDouble(key);
		return null == value ? 0 : value;
	}
}
