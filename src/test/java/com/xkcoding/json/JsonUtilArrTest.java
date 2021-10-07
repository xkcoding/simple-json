package com.xkcoding.json;

import com.xkcoding.json.config.JsonConfig;
import com.xkcoding.json.support.fastjson.FastJsonJsonAdapter;
import com.xkcoding.json.support.gson.GsonJsonAdapter;
import com.xkcoding.json.support.hutool.HutoolJsonJsonAdapter;
import com.xkcoding.json.support.jackson.JacksonJsonAdapter;
import com.xkcoding.json.util.Kv;
import com.xkcoding.json.util.StringUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p>
 * 测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 15:59
 */
public class JsonUtilArrTest {
	private final int        strArrSize      = 7;
	private final int        objArrSize      = 2;
	private       String     deserializeTest =
		"{\"age\":20,\"birth\":1611130087451,\"name\":\"序列化测试\",\"uuid\":\"45fe9c13-00bd-49b1-8c8c-9433e69ec4fb\"," +
			"\"arrStr\":[\"aStr\",\"BStr\",\"ctr\",1,2,3,false],\"arrObj\":[{\"name\":\"1\",\"sex\":false}," +
			"{\"test\":true}]}";
	private       JsonConfig jsonConfig;

	@Before
	public void init() {
		String dateFormat = "";
		//		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		if (StringUtil.isEmpty(dateFormat)) {
			jsonConfig = JsonConfig.builder().build();
		} else {
			jsonConfig      = JsonConfig.builder().dateFormat(dateFormat).build();
			deserializeTest =
				"{\"age\":20,\"birth\":\"2021-01-20 18:18:56\",\"name\":\"序列化测试\"," +
					"\"uuid\":\"45fe9c13-00bd-49b1-8c8c-9433e69ec4fb\",\"arrStr\":[\"aStr\",\"BStr\",\"ctr\",1,2,3," +
					"false],\"arrObj\":[{\"name\":\"1\",\"sex\":false},{\"test\":true}]}";
		}
	}

	@Test
	public void testFastJson() {
		JsonUtil.setJsonAdapter(new FastJsonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		Kv full = JsonUtil.parseKv(deserializeTest);
		checkArrayValidator(full.<Object>getArrayList("arrStr"), full.<Object>getArrayList("arrObj"));
	}

	@Test
	public void testJackson() {
		JsonUtil.setJsonAdapter(new JacksonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		Kv full = JsonUtil.parseKv(deserializeTest);
		checkArrayValidator(full.<Object>getArrayList("arrStr"), full.<Object>getArrayList("arrObj"));
	}

	@Test
	public void testGson() {
		JsonUtil.setJsonAdapter(new GsonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		Kv full = JsonUtil.parseKv(deserializeTest);
		checkArrayValidator(full.<Object>getArrayList("arrStr"), full.<Object>getArrayList("arrObj"));
	}

	@Test
	public void testHutoolJson() {
		JsonUtil.setJsonAdapter(new HutoolJsonJsonAdapter());
		JsonUtil.setConfig(jsonConfig);

		Kv full = JsonUtil.parseKv(deserializeTest);
		checkArrayValidator(full.<Object>getArrayList("arrStr"), full.<Object>getArrayList("arrObj"));
	}

	public void checkArrayValidator(ArrayList<Object> strArr, ArrayList<Object> objArr) {
		System.out.println("arrStr size " + strArr.size());
		System.out.println(strArr.get(3).getClass());


		Assert.assertEquals(strArrSize, strArr.size());
		Assert.assertEquals("aStr", strArr.get(0));
		Assert.assertEquals("BStr", strArr.get(1));
		Assert.assertEquals("ctr", strArr.get(2));
		if (strArr.get(3) instanceof Double) {
			Assert.assertEquals(1.0, strArr.get(3));
			Assert.assertEquals(2.0, strArr.get(4));
			Assert.assertEquals(3.0, strArr.get(5));
		} else {
			Assert.assertEquals(1, (int) strArr.get(3));
			Assert.assertEquals(2, (int) strArr.get(4));
			Assert.assertEquals(3, (int) strArr.get(5));
		}
		Assert.assertEquals(false, strArr.get(6));

		System.out.println("objArr size " + objArr.size());
		Assert.assertEquals(objArrSize, objArr.size());
		Map m1 = (Map) objArr.get(0);
		Assert.assertEquals("1", m1.get("name"));
		Assert.assertEquals(false, m1.get("sex"));
		Map m2 = (Map) objArr.get(1);
		Assert.assertEquals(true, m2.get("test"));

	}
}
