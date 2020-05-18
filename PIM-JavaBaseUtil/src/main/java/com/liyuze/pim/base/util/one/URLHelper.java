package com.liyuze.pim.base.util.one;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *   
 * 
 * @Title: URLHelper.java
 * @Package com.jarvis.base.util
 * @Description:URL工具类
 * @author Jack 
 * @date 2017年9月2日 下午4:06:57
 * @version V1.0  
 */
public class URLHelper {
	/**
	 * 对URL的中文进行编码
	 *
	 * @param url
	 *            来源字符串
	 * @return 编码后的字符串
	 */
	@SuppressWarnings("deprecation")
	public static String urlEncode(String url) {
		return java.net.URLEncoder.encode(url);
	}

	/**
	 * 对URL的中文进行解码
	 *
	 * @param url
	 *            来源字符串
	 * @return 解码后的字符串
	 */
	@SuppressWarnings("deprecation")
	public static String urlDecode(String url) {
		return java.net.URLDecoder.decode(url);
	}

	/**
	 * 把参数组成的MAP转化到对应的URL格式
	 *
	 * @param paramMap
	 *            Map参数
	 * @return
	 */
	public static String toURL(Map<?, ?> paramMap) {
		if (paramMap == null) {
			return "";
		}

		String url = "";
		for (Iterator<?> iter = paramMap.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			String value = (paramMap.get(key)).toString();
			String param = key + "=" + value;
			url += param;
			url += "&";
		}

		if (url.endsWith("&")) {
			url = url.substring(0, url.length() - 1);
		}
		return url;
	}

	/**
	 * 描述：和toUrl反向
	 * 
	 * @param url
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map toMap(String url) {
		if (url == null)
			return null;

		Map paramMap = new HashMap();
		String[] paramArray = url.split("&");
		for (int i = 0; i < paramArray.length; i++) {
			String[] param = paramArray[i].split("=");
			if (param.length == 2) {
				paramMap.put(param[0], param[1]);
			}
		}
		return paramMap;
	}

	/**
	 * 描述：移出查询字串中的某查询参数
	 * 
	 * @param queryString
	 *            查询字串
	 * @param paramName
	 *            查询参数
	 * @return
	 */
	public static String removeQueryParam(String queryString, String paramName) {
		if (StringHelper.isEmpty(queryString)) {
			return "";
		}

		if (StringHelper.isEmpty(paramName)) {
			return queryString;
		}

		String key = paramName + "=";
		int pos = queryString.indexOf(paramName + "=");
		if (pos == -1) {
			return queryString;
		}

		String startStr = queryString.substring(0, pos);
		String endStr = queryString.substring(pos + key.length());
		pos = endStr.indexOf("&");
		if (pos == -1) {
			endStr = "";
		} else {
			endStr = endStr.substring(pos + 1);
		}

		String retStr = startStr + endStr;
		if (retStr.endsWith("&")) {
			retStr = retStr.substring(0, retStr.length() - 1);
		}
		return retStr;

	}

}
