package com.xkcoding.json.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * JSON 序列化反序列化配置
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 17:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonConfig {
	/**
	 * 日期格式，null表示默认的时间戳
	 */
	private String dateFormat;
}
