package com.xkcoding.json.util;

import com.xkcoding.json.exception.SimpleJsonException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Kv getKv(String key) {
		Object value = super.get(key);
		if (null == value) {
			return null;
		}
		if (value instanceof Map) {
			Kv kv = new Kv();
			kv.putAll((Map) value);
			return kv;
		}
		throw new SimpleJsonException(value.getClass().getName() + " cannot be cast to com.xkcoding.json.util.Kv");
	}

	public List<Kv> getListKv(String key) {
		List<Object> values = getArrayList(key);
		if (null == values) {
			return null;
		}
		List<Kv> result = new ArrayList<>();
		Kv item = null;
		for (Object o : values) {
			if (o instanceof Map) {
				item = new Kv();
				item.putAll((Map) o);
				result.add(item);
				continue;
			}
			throw new SimpleJsonException(o.getClass().getName() + " cannot be cast to com.xkcoding.json.util.Kv");
		}
		return result;
	}
}
