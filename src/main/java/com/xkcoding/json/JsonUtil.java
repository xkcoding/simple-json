package com.xkcoding.json;

import com.xkcoding.json.config.JsonConfig;
import com.xkcoding.json.exception.SimpleJsonException;
import com.xkcoding.json.support.AbstractJsonAdapter;
import com.xkcoding.json.support.JsonAdapter;
import com.xkcoding.json.support.fastjson.FastJsonJsonAdapter;
import com.xkcoding.json.support.gson.GsonJsonAdapter;
import com.xkcoding.json.support.hutool.HutoolJsonJsonAdapter;
import com.xkcoding.json.support.jackson.JacksonJsonAdapter;
import com.xkcoding.json.util.ClassUtil;
import lombok.experimental.UtilityClass;

/**
 * <p>
 * Json工具类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 14:58
 */
@UtilityClass
public class JsonUtil {
	private static AbstractJsonAdapter jsonAdapter;

	private void checkJsonAdapterNotNull(JsonAdapter jsonAdapter) {
		if (null == jsonAdapter) {
			selectJsonAdapter();
		}
	}

	private static void selectJsonAdapter() {
		AbstractJsonAdapter defaultJsonAdapter = null;
		ClassLoader classLoader = JsonUtil.class.getClassLoader();
		// 基于 jackson
		if (null == defaultJsonAdapter && ClassUtil.isPresent("com.fasterxml.jackson.databind.ObjectMapper", classLoader)) {
			defaultJsonAdapter = getJsonAdapter(JacksonJsonAdapter.class);
		}
		// 基于 fastjson
		if (null == defaultJsonAdapter && ClassUtil.isPresent("com.alibaba.fastjson.JSON", classLoader)) {
			defaultJsonAdapter = getJsonAdapter(FastJsonJsonAdapter.class);
		}
		// 基于 gson
		if (null == defaultJsonAdapter && ClassUtil.isPresent("com.google.gson.Gson", classLoader)) {
			defaultJsonAdapter = getJsonAdapter(GsonJsonAdapter.class);
		}
		// 基于 hutool
		if (null == defaultJsonAdapter && ClassUtil.isPresent("cn.hutool.json.JSONUtil", classLoader)) {
			defaultJsonAdapter = getJsonAdapter(HutoolJsonJsonAdapter.class);
		}

		if (defaultJsonAdapter == null) {
			throw new SimpleJsonException("Has no JsonImpl defined in environment!");
		}

		jsonAdapter = defaultJsonAdapter;
	}

	private static <T extends AbstractJsonAdapter> AbstractJsonAdapter getJsonAdapter(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Throwable e) {
			// ignore error
			return null;
		}
	}

	public void setJsonAdapter(AbstractJsonAdapter jsonAdapter) {
		JsonUtil.jsonAdapter = jsonAdapter;
	}

	public void setConfig(JsonConfig jsonConfig) {
		checkJsonAdapterNotNull(jsonAdapter);
		if (null == jsonConfig) {
			jsonConfig = new JsonConfig();
		}
		jsonAdapter.setJsonConfig(jsonConfig);
	}

	/**
	 * 序列化
	 *
	 * @param obj 对象
	 * @return json 字符串
	 */
	public String toJsonString(Object obj) {
		checkJsonAdapterNotNull(jsonAdapter);
		return jsonAdapter.serialize(obj);
	}

	/**
	 * 反序列化
	 *
	 * @param jsonStr json 字符串
	 * @param clazz   对象类型
	 * @return 对象
	 */
	public <T> T toBean(String jsonStr, Class<T> clazz) {
		checkJsonAdapterNotNull(jsonAdapter);
		return jsonAdapter.deserialize(jsonStr, clazz);
	}

	/**
	 * 反序列化为 {@link SimpleMap}
	 *
	 * @param jsonStr json 字符串
	 * @return SimpleMap
	 */
	public SimpleMap parse(String jsonStr) {
		return toBean(jsonStr, SimpleMap.class);
	}

}
