package com.xkcoding.json.support.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xkcoding.json.config.JsonConfig;
import com.xkcoding.json.exception.SimpleJsonException;
import com.xkcoding.json.support.AbstractJsonAdapter;
import com.xkcoding.json.util.StringUtil;

import java.text.SimpleDateFormat;

/**
 * <p>
 * Jackson 序列化实现，时间格式化可以通过 {@link JsonConfig} 设置，默认为时间戳类型，也可以通过 {@link com.fasterxml.jackson.annotation.JsonFormat} 设置
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 15:22
 */
public class JacksonJsonAdapter extends AbstractJsonAdapter {
	private final ObjectMapper objectMapper;

	public JacksonJsonAdapter() {
		this(new JsonConfig());
	}

	public JacksonJsonAdapter(JsonConfig jsonConfig) {
		super(jsonConfig);
		this.objectMapper = new ObjectMapper();
		if (StringUtil.isNotEmpty(jsonConfig.getDateFormat())) {
			this.objectMapper.setDateFormat(new SimpleDateFormat(jsonConfig.getDateFormat()));
		}
	}

	@Override
	public void setJsonConfig(JsonConfig jsonConfig) {
		super.setJsonConfig(jsonConfig);
		if (StringUtil.isNotEmpty(jsonConfig.getDateFormat())) {
			this.objectMapper.setDateFormat(new SimpleDateFormat(jsonConfig.getDateFormat()));
		}
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
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new SimpleJsonException(e);
		}
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
		try {
			return objectMapper.readValue(jsonStr, clazz);
		} catch (JsonProcessingException e) {
			throw new SimpleJsonException(e);
		}
	}
}
