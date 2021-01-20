package com.xkcoding.json.support.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xkcoding.json.config.JsonConfig;
import com.xkcoding.json.exception.SimpleJsonException;
import com.xkcoding.json.support.AbstractJsonAdapter;
import com.xkcoding.json.util.StringUtil;

/**
 * <p>
 * FastJson 序列化实现，时间格式化可以通过 {@link JsonConfig} 设置，也可以通过 {@link com.alibaba.fastjson.annotation.JSONField} 设置
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 15:12
 */
public class FastJsonJsonAdapter extends AbstractJsonAdapter {

	public FastJsonJsonAdapter() {
		this(new JsonConfig());
	}

	public FastJsonJsonAdapter(JsonConfig jsonConfig) {
		super(jsonConfig);
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
		if (StringUtil.isNotEmpty(jsonConfig.getDateFormat())) {
			JSON.DEFFAULT_DATE_FORMAT = jsonConfig.getDateFormat();
			return JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);
		}
		return JSON.toJSONString(obj);
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
		return JSON.parseObject(jsonStr, clazz);
	}
}
