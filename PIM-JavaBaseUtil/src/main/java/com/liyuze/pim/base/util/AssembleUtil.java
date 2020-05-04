package com.liyuze.pim.base.util;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class AssembleUtil {

	/**
	 * 有序的不重复的Set集合。
	 */
	private static Set<String> set = new TreeSet<String>();

	/**
	 *Author:Jack
	 *Time:2017年9月13日下午2:53:59
	 *@param sourceStr 初始化的字符串源信息
	 *@param max       每种组合是几个数字
	 *@return
	 *Return:String[]
	 *Description:根据字符串“1,2,3,4,5,6,7”的格式计算出来一共有多少组组合
	 */
	public static String[] getAssemble(String sourceStr, int max) {
		String sourceList [] = sourceStr.split(",");
		String[] array = getAssemble(sourceList, max);
		return array;
	}
	
	/**
	 *Author:Jack
	 *Time:2017年9月13日下午2:53:56
	 *@param sourceArray 初始化的字符串数组信息
	 *@param max         每种组合是几个数字
	 *@return
	 *Return:String[]
	 *Description: 根据字符串数组形式来计算一共有多少种组数{ "1", "2", "3", "4", "5","6","7" }
	 */
	public static String[] getAssemble(String[] sourceArray, int max) {
		for (int start = 0; start < sourceArray.length; start++) {
			doSet(sourceArray[start], sourceArray, max);
		}
		String[] arr = new String[set.size()];
		String[] array = set.toArray(arr);
		set.clear();
		return array;
	}

	/**
	 *Author:Jack
	 *Time:2017年9月13日下午3:00:18
	 *@param start
	 *@param sourceList
	 *@param max
	 *@return
	 *Return:Set<String>
	 *Description:计算组数
	 */
	private static Set<String> doSet(String start, String[] sourceList, int max) {
		String[] olds = start.split("_");
		if (olds.length == max) {
			set.add(start.replaceAll("_", "").trim());
		} else {
			for (int s = 0; s < sourceList.length; s++) {
				if (Arrays.asList(olds).contains(sourceList[s])) {
					continue;
				} else {
					doSet(start + "_" + sourceList[s], sourceList, max);
				}
			}
		}
		return set;
	}

	/**
	 *Author:Jack
	 *Time:2017年9月13日下午3:04:25
	 *@param args
	 *Return:void
	 *Description:测试方法
	 */
	public static void main(String[] args) {
		    
		    String[] sourceArr = new String[] { "1", "2", "3", "4", "5","6","7" };
	        String[] resultArr = getAssemble(sourceArr, 3);
	        System.out.println("累计组合："+resultArr.length+","+Arrays.toString(resultArr));
	        
	        String sourceStr = "1,2,3,4,5,6,7";
	        String[] resultArr2 = getAssemble(sourceStr, 3);
	        System.out.println("累计组合："+resultArr2.length+","+Arrays.toString(resultArr2));
	}
}
