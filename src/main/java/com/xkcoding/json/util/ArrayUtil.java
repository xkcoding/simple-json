package com.xkcoding.json.util;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;

/**
 * 无描述
 *
 * @author : StringKe (authemail(a)qq.com)
 * @date : 2021/10/5 06:16
 */
@UtilityClass
public class ArrayUtil {
	public <T> ArrayList<T> toList(Object object){
		if(object instanceof List<?>) {
			return new ArrayList<T>((List<T>) object);
		}
		return null;
	}
}
