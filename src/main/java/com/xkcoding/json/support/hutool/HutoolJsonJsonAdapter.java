package com.xkcoding.json.support.hutool;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.xkcoding.json.config.JsonConfig;
import com.xkcoding.json.exception.SimpleJsonException;
import com.xkcoding.json.support.AbstractJsonAdapter;
import com.xkcoding.json.util.StringUtil;

/**
 * <p>
 * Hutool JSON 序列化实现，时间格式化可以通过 {@link JsonConfig} 设置，默认为时间戳类型
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 15:05
 */
public class HutoolJsonJsonAdapter extends AbstractJsonAdapter {
	private static JSONConfig hutoolJsonConfig;

	public HutoolJsonJsonAdapter() {
		this(new JsonConfig());
	}

	public HutoolJsonJsonAdapter(JsonConfig jsonConfig) {
		super(jsonConfig);
		configureHutoolJson(jsonConfig);
	}

	@Override
	public void setJsonConfig(JsonConfig jsonConfig) {
		super.setJsonConfig(jsonConfig);
		configureHutoolJson(jsonConfig);
	}

	private void configureHutoolJson(JsonConfig jsonConfig) {
		if (StringUtil.isNotEmpty(jsonConfig.getDateFormat())) {
			hutoolJsonConfig = JSONConfig.create().setDateFormat(jsonConfig.getDateFormat());
		} else {
			hutoolJsonConfig = JSONConfig.create();
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
		return JSONUtil.toJsonStr(JSONUtil.parse(obj, hutoolJsonConfig));
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
		return JSONUtil.parse(jsonStr, hutoolJsonConfig).toBean(clazz);
	}
}
