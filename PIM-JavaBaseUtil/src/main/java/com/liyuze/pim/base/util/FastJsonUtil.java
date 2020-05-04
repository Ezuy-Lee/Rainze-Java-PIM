package com.liyuze.pim.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 *   
 * 
 * @Title: FastJsonUtil.java
 * @Package com.jarvis.base.util
 * @Description:fastjson工具类
 * @author liyuze 
 * @date 2017年9月2日 下午4:16:27
 * @version V1.0  
 */
public class FastJsonUtil {

	private static final SerializeConfig config;

	static {
		config = new SerializeConfig();
		config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
		config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
	}

	private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
			SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
			SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
			SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
			SerializerFeature.PrettyFormat  //是否需要格式化输出Json数据
	};

	/**
	 * Author:Jack Time:2017年9月2日下午4:24:14
	 * 
	 * @param object
	 * @return Return:String Description:将对象转成成Json对象
	 */
	public static String toJSONString(Object object) {
		return JSON.toJSONString(object, config, features);
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:27:25
	 * 
	 * @param object
	 * @return Return:String Description:使用和json-lib兼容的日期输出格式
	 */
	public static String toJSONNoFeatures(Object object) {
		return JSON.toJSONString(object, config);
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:24:54
	 * 
	 * @param jsonStr
	 * @return Return:Object Description:将Json数据转换成JSONObject
	 */
	public static JSONObject toJsonObj(String jsonStr) {
		return (JSONObject) JSON.parse(jsonStr);
	}
	
	/**
	 * Author:Jack Time:2017年9月2日下午4:25:20
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return Return:T Description:将Json数据转换成Object
	 */
	public static <T> T toBean(String jsonStr, Class<T> clazz) {
		return JSON.parseObject(jsonStr, clazz);
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:25:34
	 * 
	 * @param jsonStr
	 * @return Return:Object[] Description:将Json数据转换为数组
	 */
	public static <T> Object[] toArray(String jsonStr) {
		return toArray(jsonStr, null);
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:25:57
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return Return:Object[] Description:将Json数据转换为数组
	 */
	public static <T> Object[] toArray(String jsonStr, Class<T> clazz) {
		return JSON.parseArray(jsonStr, clazz).toArray();
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:26:08
	 * 
	 * @param jsonStr
	 * @param clazz
	 * @return Return:List<T> Description:将Json数据转换为List
	 */
	public static <T> List<T> toList(String jsonStr, Class<T> clazz) {
		return JSON.parseArray(jsonStr, clazz);
	}

	/**
	 * 将javabean转化为序列化的JSONObject对象
	 * 
	 * @param keyvalue
	 * @return
	 */
	public static JSONObject beanToJsonObj(Object bean) {
		String jsonStr = JSON.toJSONString(bean);
		JSONObject objectJson = (JSONObject) JSON.parse(jsonStr);
		return objectJson;
	}
	/**
	 * json字符串转化为map
	 * 
	 * @param s
	 * @return
	 */
	public static Map<?, ?> stringToCollect(String jsonStr) {
		Map<?, ?> map = JSONObject.parseObject(jsonStr);
		return map;
	}

	/**
	 * 将map转化为string
	 * 
	 * @param m
	 * @return
	 */
	public static String collectToString(Map<?, ?> map) {
		String jsonStr = JSONObject.toJSONString(map);
		return jsonStr;
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:19:00
	 * 
	 * @param t
	 * @param file
	 * @throws IOException
	 *             Return:void Description:将对象的Json数据写入文件。
	 */
	public static <T> void writeJsonToFile(T t, File file) throws IOException {
		String jsonStr = JSONObject.toJSONString(t, SerializerFeature.PrettyFormat);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		bw.write(jsonStr);
		bw.close();
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:19:12
	 * 
	 * @param t
	 * @param filename
	 * @throws IOException
	 *             Return:void Description:将对象的Json数据写入文件。
	 */
	public static <T> void writeJsonToFile(T t, String filename) throws IOException {
		writeJsonToFile(t, new File(filename));
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:22:07
	 * 
	 * @param cls
	 * @param file
	 * @return
	 * @throws IOException
	 *             Return:T Description:将文件中的Json数据转换成Object对象
	 */
	public static <T> T readJsonFromFile(Class<T> cls, File file) throws IOException {
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			strBuilder.append(line);
		}
		br.close();
		return JSONObject.parseObject(strBuilder.toString(), cls);
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:22:30
	 * 
	 * @param cls
	 * @param filename
	 * @return
	 * @throws IOException
	 *             Return:T Description:将文件中的Json数据转换成Object对象
	 */
	public static <T> T readJsonFromFile(Class<T> cls, String filename) throws IOException {
		return readJsonFromFile(cls, new File(filename));
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:23:06
	 * 
	 * @param typeReference
	 * @param file
	 * @return
	 * @throws IOException
	 *             Return:T Description:从文件中读取出Json对象
	 */
	public static <T> T readJsonFromFile(TypeReference<T> typeReference, File file) throws IOException {
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			strBuilder.append(line);
		}
		br.close();
		return JSONObject.parseObject(strBuilder.toString(), typeReference);
	}

	/**
	 * Author:Jack Time:2017年9月2日下午4:23:11
	 * 
	 * @param typeReference
	 * @param filename
	 * @return
	 * @throws IOException
	 *             Return:T Description:从文件中读取出Json对象
	 */
	public static <T> T readJsonFromFile(TypeReference<T> typeReference, String filename) throws IOException {
		return readJsonFromFile(typeReference, new File(filename));
	}

}