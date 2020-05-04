package com.liyuze.pim.base.util;

/**
 *   
 * 
 * @Title: ReflectHelper.java
 * @Package com.jarvis.base.util
 * @Description: 反射工具类
 * @author liyuze 
 * @date 2017年9月2日 下午4:02:35
 * @version V1.0  
 */
public class ReflectHelper {

	/**
	 * 提指定的类载入以系统中
	 *
	 * @param name
	 *            类名称
	 * @return 类对象
	 * @throws ClassNotFoundException
	 */
	public static Class<?> classForName(String name) throws ClassNotFoundException {
		try {
			return Thread.currentThread().getContextClassLoader().loadClass(name);
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("类[" + name + "]加载出错");
		} catch (SecurityException e) {
			e.printStackTrace();
			System.err.println("类[" + name + "]加载出错");
		}
		return Class.forName(name);
	}

	/**
	 * 根据名称生成指定的对象
	 *
	 * @param name
	 *            类名称
	 * @return 具体的对象,若发生异常，则返回null
	 */
	public static Object objectForName(String name) {
		try {
			return Class.forName(name).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("类[" + name + "]获取对象实例出错");
		}
		return null;
	}
}
