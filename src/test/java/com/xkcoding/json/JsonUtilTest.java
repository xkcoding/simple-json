package com.xkcoding.json;

import com.xkcoding.json.config.JsonConfig;
import com.xkcoding.json.support.fastjson.FastJsonJsonAdapter;
import com.xkcoding.json.support.gson.GsonJsonAdapter;
import com.xkcoding.json.support.hutool.HutoolJsonJsonAdapter;
import com.xkcoding.json.support.jackson.JacksonJsonAdapter;
import com.xkcoding.json.util.Kv;
import com.xkcoding.json.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 15:59
 */
public class JsonUtilTest {
	private User serializeTest = new User(UUID.randomUUID().toString(), "序列化测试", 20, new Date());
	private String deserializeTest =
		"{\"age\":20,\"birth\":1611130087451,\"name\":\"序列化测试\",\"uuid\":\"45fe9c13-00bd-49b1-8c8c-9433e69ec4fb\"}";
	private JsonConfig jsonConfig;

	@Before
	public void init() {
		String dateFormat = "";
		//		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		if (StringUtil.isEmpty(dateFormat)) {
			jsonConfig = JsonConfig.builder().build();
		} else {
			jsonConfig = JsonConfig.builder().dateFormat(dateFormat).build();
			deserializeTest =
				"{\"age\":20,\"birth\":\"2021-01-20 18:18:56\",\"name\":\"序列化测试\",\"uuid\":\"45fe9c13-00bd-49b1-8c8c-9433e69ec4fb\"}";
		}
	}

	@Test
	public void testFastJson() {
		JsonUtil.setJsonAdapter(new FastJsonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		String jsonString = JsonUtil.toJsonString(serializeTest);
		System.out.println(jsonString);

		User user = JsonUtil.toBean(deserializeTest, User.class);
		System.out.println(user);

		Map map = JsonUtil.toBean(deserializeTest, Map.class);
		System.out.println(map);
	}

	@Test
	public void testJackson() {
		JsonUtil.setJsonAdapter(new JacksonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		String jsonString = JsonUtil.toJsonString(serializeTest);
		System.out.println(jsonString);

		User user = JsonUtil.toBean(deserializeTest, User.class);
		System.out.println(user);

		Map map = JsonUtil.toBean(deserializeTest, Map.class);
		System.out.println(map);
	}

	@Test
	public void testGson() {
		JsonUtil.setJsonAdapter(new GsonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		String jsonString = JsonUtil.toJsonString(serializeTest);
		System.out.println(jsonString);

		User user = JsonUtil.toBean(deserializeTest, User.class);
		System.out.println(user);

		Map map = JsonUtil.toBean(deserializeTest, Map.class);
		System.out.println(map);
	}

	@Test
	public void testHutoolJson() {
		JsonUtil.setJsonAdapter(new HutoolJsonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		String jsonString = JsonUtil.toJsonString(serializeTest);
		System.out.println(jsonString);

		User user = JsonUtil.toBean(deserializeTest, User.class);
		System.out.println(user);

		Map map = JsonUtil.toBean(deserializeTest, Map.class);
		System.out.println(map);
	}

	@Test
	public void testToSimpleMap() {

		String jsonString = JsonUtil.toJsonString(serializeTest);
		System.out.println(jsonString);

		Kv kv = JsonUtil.parseKv(jsonString);
		System.out.println(kv);
		System.out.println(kv.getInteger("age"));
		System.out.println(kv.getIntValue("age"));
		System.out.println(kv.getString("uuid"));
		System.out.println(kv.getString("birth"));
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	static class User implements Serializable {
		private String uuid;
		private String name;
		private Integer age;
		private Date birth;
	}
}
