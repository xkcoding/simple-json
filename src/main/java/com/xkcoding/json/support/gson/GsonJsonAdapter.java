package com.xkcoding.json.support.gson;

import com.google.gson.*;
import com.xkcoding.json.config.JsonConfig;
import com.xkcoding.json.exception.SimpleJsonException;
import com.xkcoding.json.support.AbstractJsonAdapter;
import com.xkcoding.json.util.StringUtil;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

/**
 * <p>
 * Gson 序列化实现，时间格式化可以通过 {@link JsonConfig} 设置，默认为时间戳类型
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 15:14
 */
public class GsonJsonAdapter extends AbstractJsonAdapter {
	private static Gson gson;

	public GsonJsonAdapter() {
		this(new JsonConfig());
	}

	public GsonJsonAdapter(JsonConfig jsonConfig) {
		super(jsonConfig);
		GsonBuilder gb = new GsonBuilder();
		if (StringUtil.isEmpty(jsonConfig.getDateFormat())) {
			gb.registerTypeAdapter(Date.class, new GsonDateSerializer()).setDateFormat(DateFormat.LONG);
			gb.registerTypeAdapter(Date.class, new GsonDateDeserializer()).setDateFormat(DateFormat.LONG);
		} else {
			gb.setDateFormat(jsonConfig.getDateFormat());
		}
		gson = gb.create();
	}

	@Override
	public void setJsonConfig(JsonConfig jsonConfig) {
		super.setJsonConfig(jsonConfig);
		GsonBuilder gb = new GsonBuilder();
		if (StringUtil.isEmpty(jsonConfig.getDateFormat())) {
			gb.registerTypeAdapter(Date.class, new GsonDateSerializer()).setDateFormat(DateFormat.LONG);
			gb.registerTypeAdapter(Date.class, new GsonDateDeserializer()).setDateFormat(DateFormat.LONG);
		} else {
			gb.setDateFormat(jsonConfig.getDateFormat());
		}
		gson = gb.create();
	}

	/**
	 * 序列化
	 *
	 * @param obj 对象
	 * @return json 字符串
	 * @throws SimpleJsonException 自定义异常
	 */
	@Override
	public String serialize(Object obj) throws SimpleJsonException {
		return gson.toJson(obj);
	}

	/**
	 * 反序列化
	 *
	 * @param jsonStr json 字符串
	 * @param clazz   对象类型
	 * @return 对象
	 * @throws SimpleJsonException 自定义异常
	 */
	@Override
	public <T> T deserialize(String jsonStr, Class<T> clazz) throws SimpleJsonException {
		return gson.fromJson(jsonStr, clazz);
	}

	private static class GsonDateSerializer implements JsonSerializer<Date> {

		@Override
		public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
			return new JsonPrimitive(date.getTime());
		}
	}

	private static class GsonDateDeserializer implements JsonDeserializer<Date> {

		@Override
		public Date deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext)
			throws JsonParseException {
			return new Date(json.getAsJsonPrimitive().getAsLong());
		}
	}
}
