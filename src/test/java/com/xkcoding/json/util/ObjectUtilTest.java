package com.xkcoding.json.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ObjectUtilTest {

	@Test
	public void toStr() {
		Object o1 = 1;
		String result = ObjectUtil.toStr(o1);
		System.out.println(result);
		Assert.assertEquals("1", result);

		Object o2 = null;
		String result2 = ObjectUtil.toStr(o2);
		System.out.println(result2);
		Assert.assertNull(result2);

		Map o3 = new HashMap<>();
		o3.put("key", "value");
		o3.put("key1", "value2");
		String result3 = ObjectUtil.toStr(o3);
		System.out.println(result3);
		Assert.assertEquals("{key1=value2, key=value}", result3);
	}

	@Test
	public void toInt() {
		Object o1 = "1";
		Integer result = ObjectUtil.toInt(o1);
		System.out.println(result);
		Assert.assertEquals(1, (int) result);

		Object o2 = null;
		Integer result2 = ObjectUtil.toInt(o2);
		System.out.println(result2);
		Assert.assertNull(result2);

		Object o3 = new HashMap<>();
		Integer result3 = ObjectUtil.toInt(o3);
		System.out.println(result3);
		Assert.assertEquals("1", result3);
	}

	@Test
	public void toShort() {
		Object o1 = "1";
		Short result = ObjectUtil.toShort(o1);
		System.out.println(result);
		Assert.assertTrue(result == 1);

		Object o2 = null;
		Short result2 = ObjectUtil.toShort(o2);
		System.out.println(result2);
		Assert.assertNull(result2);

		Object o3 = new HashMap<>();
		Short result3 = ObjectUtil.toShort(o3);
		System.out.println(result3);
		Assert.assertNotNull(result3);
	}

	@Test
	public void toLong() {
		Object o1 = "1";
		Long result = ObjectUtil.toLong(o1);
		System.out.println(result);
		Assert.assertTrue(result == 1);

		Object o2 = null;
		Long result2 = ObjectUtil.toLong(o2);
		System.out.println(result2);
		Assert.assertNull(result2);

		Object o3 = new HashMap<>();
		Long result3 = ObjectUtil.toLong(o3);
		System.out.println(result3);
		Assert.assertNotNull(result3);
	}

	@Test
	public void toFloat() {
		Object o1 = "1";
		Float result = ObjectUtil.toFloat(o1);
		System.out.println(result);
		Assert.assertTrue(result == 1);

		Object o2 = null;
		Float result2 = ObjectUtil.toFloat(o2);
		System.out.println(result2);
		Assert.assertNull(result2);

		Object o4 = "10.11";
		Float result4 = ObjectUtil.toFloat(o4);
		System.out.println(result4);

		Object o3 = new HashMap<>();
		Float result3 = ObjectUtil.toFloat(o3);
		System.out.println(result3);
		Assert.assertNotNull(result3);
	}

	@Test
	public void toDouble() {
		Object o1 = "1";
		Double result = ObjectUtil.toDouble(o1);
		System.out.println(result);
		Assert.assertTrue(result == 1);

		Object o2 = null;
		Double result2 = ObjectUtil.toDouble(o2);
		System.out.println(result2);
		Assert.assertNull(result2);

		Object o4 = "10.11";
		Double result4 = ObjectUtil.toDouble(o4);
		System.out.println(result4);

		Object o3 = new HashMap<>();
		Double result3 = ObjectUtil.toDouble(o3);
		System.out.println(result3);
		Assert.assertNotNull(result3);
	}

	@Test
	public void toBool() {
		Object o1 = "1";
		Boolean result = ObjectUtil.toBool(o1);
		System.out.println(result);
		Assert.assertTrue(result);

		Object o2 = null;
		Boolean result2 = ObjectUtil.toBool(o2);
		System.out.println(result2);
		Assert.assertFalse(result2);

		Object o3 = "3";
		Boolean result3 = ObjectUtil.toBool(o3);
		System.out.println(result3);
		Assert.assertFalse(result3);

		Object o4 = "a";
		Boolean result4 = ObjectUtil.toBool(o4);
		System.out.println(result4);
		Assert.assertFalse(result4);

		Object o5 = new HashMap<>();
		Boolean result5 = ObjectUtil.toBool(o5);
		System.out.println(result5);
		Assert.assertFalse(result5);

		Object o6 = "true";
		Boolean result6 = ObjectUtil.toBool(o6);
		System.out.println(result6);
		Assert.assertTrue(result6);

		Object o7 = "y";
		Boolean result7 = ObjectUtil.toBool(o7);
		System.out.println(result7);
		Assert.assertTrue(result7);

		Object o8 = "Yes";
		Boolean result8 = ObjectUtil.toBool(o8);
		System.out.println(result8);
		Assert.assertTrue(result8);
	}
}
