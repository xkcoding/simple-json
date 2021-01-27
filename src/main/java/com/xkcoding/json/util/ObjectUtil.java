package com.xkcoding.json.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 对象操作工具类，参考借鉴自:
 * - com.alibaba.fastjson.util.TypeUtils
 * - cn.hutool.core.util.BooleanUtil
 * </p>
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @date 2021-01-27 11:18
 */
public class ObjectUtil {

	private static final List<String> TRUE_LIST = Arrays.asList("true", "yes", "y", "t", "ok", "1", "on", "是", "对", "真", "對", "√");

	public static String toStr(Object o) {
		return null == o ? null : o.toString();
	}

	public static Integer toInt(Object o) {
		if (null == o) {
			return null;
		}
		if (o instanceof Integer) {
			return (Integer) o;
		}

		if (o instanceof BigDecimal) {
			return ((BigDecimal) o).intValueExact();
		}

		if (o instanceof Number) {
			return ((Number) o).intValue();
		}

		if (o instanceof String) {
			String strVal = (String) o;
			if (strVal.length() == 0
				|| "null".equalsIgnoreCase(strVal)) {
				return null;
			}
			if (strVal.indexOf(',') != 0) {
				strVal = strVal.replaceAll(",", "");
			}
			return Integer.parseInt(strVal);
		}

		if (o instanceof Boolean) {
			return (Boolean) o ? 1 : 0;
		}

		throw new ClassCastException(o.getClass().getName() + " cannot be converted to Integer, obj : " + o);
	}

	public static Boolean toBool(Object o) {
		if (null == o) {
			return null;
		}
		if (o instanceof Boolean) {
			return (Boolean) o;
		}

		if (o instanceof BigDecimal) {
			return ((BigDecimal) o).intValueExact() == 1;
		}

		if (o instanceof Number) {
			return ((Number) o).intValue() == 1;
		}

		String obj = toStr(o).trim().toLowerCase();
		return TRUE_LIST.contains(obj);
	}

	public static Short toShort(Object o) {
		if (null == o) {
			return null;
		}
		if (o instanceof Short) {
			return (Short) o;
		}

		if (o instanceof BigDecimal) {
			return ((BigDecimal) o).shortValueExact();
		}

		if (o instanceof Number) {
			return ((Number) o).shortValue();
		}

		if (o instanceof String) {
			String strVal = (String) o;
			if (strVal.length() == 0
				|| "null".equalsIgnoreCase(strVal)) {
				return null;
			}
			return Short.parseShort(strVal);
		}
		throw new ClassCastException(o.getClass().getName() + " cannot be converted to Short, obj : " + o);
	}

	public static Long toLong(Object o) {
		if (null == o) {
			return null;
		}
		if (o instanceof Long) {
			return (Long) o;
		}

		if (o instanceof BigDecimal) {
			return ((BigDecimal) o).longValueExact();
		}

		if (o instanceof Number) {
			return ((Number) o).longValue();
		}

		if (o instanceof String) {
			String strVal = (String) o;
			if (strVal.length() == 0
				|| "null".equalsIgnoreCase(strVal)) {
				return null;
			}
			if (strVal.indexOf(',') != 0) {
				strVal = strVal.replaceAll(",", "");
			}
			try {
				return Long.parseLong(strVal);
			} catch (NumberFormatException ignored) {
			}
		}

		throw new ClassCastException(o.getClass().getName() + " cannot be converted to Long, obj : " + o);
	}

	public static Float toFloat(Object o) {
		if (o == null) {
			return null;
		}
		if (o instanceof Number) {
			return ((Number) o).floatValue();
		}
		if (o instanceof String) {
			String strVal = o.toString();
			if (strVal.length() == 0
				|| "null".equalsIgnoreCase(strVal)) {
				return null;
			}
			if (strVal.indexOf(',') != 0) {
				strVal = strVal.replaceAll(",", "");
			}
			return Float.parseFloat(strVal);
		}
		throw new ClassCastException(o.getClass().getName() + " cannot be converted to Float, obj : " + o);
	}

	public static Double toDouble(Object o) {
		if (o == null) {
			return null;
		}
		if (o instanceof Number) {
			return ((Number) o).doubleValue();
		}
		if (o instanceof String) {
			String strVal = o.toString();
			if (strVal.length() == 0
				|| "null".equalsIgnoreCase(strVal)) {
				return null;
			}
			if (strVal.indexOf(',') != 0) {
				strVal = strVal.replaceAll(",", "");
			}
			return Double.parseDouble(strVal);
		}
		throw new ClassCastException(o.getClass().getName() + " cannot be converted to Double, obj : " + o);
	}

}
