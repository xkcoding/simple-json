/*
 * Copyright (c) 2019-2029, xkcoding & Yangkai.Shen & 沈扬凯 (237497819@qq.com & xkcoding.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xkcoding.json.util;

import lombok.experimental.UtilityClass;

/**
 * <p>
 * 字符串工具类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2021-01-20 18:21
 */
@UtilityClass
public class StringUtil {

	public boolean isEmpty(String str) {
		return null == str || str.trim().isEmpty();
	}

	public boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
}
