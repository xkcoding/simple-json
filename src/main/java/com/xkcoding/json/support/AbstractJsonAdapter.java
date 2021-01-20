package com.xkcoding.json.support;

import com.xkcoding.json.config.JsonConfig;

/**
 * <p>
 * 抽象实现
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 17:12
 */
public abstract class AbstractJsonAdapter implements JsonAdapter {
	protected JsonConfig jsonConfig;

	public AbstractJsonAdapter(JsonConfig jsonConfig) {
		this.jsonConfig = jsonConfig;
	}

	public void setJsonConfig(JsonConfig jsonConfig) {
		this.jsonConfig = jsonConfig;
	}
}
