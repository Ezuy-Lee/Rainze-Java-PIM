package com.liyuze.pim.base.util;

import java.util.List;

/**   
* @Title: ConvertHelper.java 
* @Package com.jarvis.base.util 
* @Description:数据类型转换
* @author liyuze 
* @date 2017年9月2日 下午3:22:05 
* @version V1.0   
*/ 
public class ConvertHelper
{
	/**
	 * 把字串转化为整数,若转化失败，则返回0
	 *
	 * @param str
	 *            字串
	 * @return
	 */
	public static int strToInt(String str) {
		if (str == null) {
			return 0;
		}

		try {
			return Integer.parseInt(str);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(str + "转换成int类型失败，请检查数据来源");
		}
		return 0;
	}

	/**
	 * 把字串转化为长整型数,若转化失败，则返回0
	 *
	 * @param str
	 *            要转化为长整型的字串
	 * @return
	 */
	public static long strToLong(String str) {
		if (str == null) {
			return 0;
		}

		try {
			return Long.parseLong(str);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(str + "转换成long类型失败，请检查数据来源");
		}
		return 0;
	}

	/**
	 * 把字串转化为Float型数据,若转化失败，则返回0
	 *
	 * @param str
	 *            要转化为Float的字串
	 * @return
	 */
	public static float strToFloat(String str) {
		if (str == null) {
			return 0;
		}
		try {
			return Float.parseFloat(str);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(str + "转换成float类型失败，请检查数据来源");
		}
		return 0;
	}

	/**
	 * 把字串转化为Double型数据，若转化失败，则返回0
	 * 
	 * @param str
	 *            要转化为Double的字串
	 * @return
	 */
	public static double strToDouble(String str) {
		if (str == null) {
			return 0;
		}
		try {
			return Double.parseDouble(str);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(str + "转换成double类型失败，请检查数据来源");
		}
		return 0;
	}

	/**
	 * 描述：字符转为一个元素的Object数组
	 * 
	 * @param str
	 * @return
	 */
	public static Object[] strToArry(String str) {
		if (str == null) {
			return null;
		} else {
			return new Object[] { str };
		}
	}

	/**
	 * 对于一个字符串数组，把字符串数组中的每一个字串转换为整数。 返回一个转换后的整型数组，对于每一个字串若转换失败，则对 应的整型值就为0
	 *
	 * @param strArray
	 *            要转化的数组
	 * @return
	 */
	public static int[] strArrayToIntArray(String[] strArray) {
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = strToInt(strArray[i]);
		}
		return intArray;
	}

	/**
	 * 描述：数组转换为字符串
	 * 
	 * @param arg0
	 *            数组
	 * @return
	 */
	public static String arrToString(Object[] arg0) {
		if (arg0 == null) {
			return "";
		}
		return arrToString(arg0, ",");
	}

	/**
	 * 描述：数据转换为字符串
	 * 
	 * @param arg0
	 *            数组
	 * @param arg1
	 *            取数组个数
	 * @return
	 */
	public static String arrToString(Object[] arg0, int arg1) {
		if (arg0 == null) {
			return "";
		}
		return arrToString(arg0, ",", arg1);
	}

	/**
	 * 描述：数据转换为字符串
	 * 
	 * @param arg0
	 *            数组
	 * @param arg1
	 *            间隔符号
	 * @return
	 */
	public static String arrToString(Object[] arg0, String arg1) {
		return arrToString(arg0, arg1, 0);
	}

	/**
	 * 描述：数据转换为字符串
	 * 
	 * @param arg0
	 *            数组
	 * @param arg1
	 *            间隔符号
	 * @param arg2
	 *            取数组个数
	 * @return
	 */
	public static String arrToString(Object[] arg0, String arg1, int arg2) {
		if (arg0 == null || arg0.length == 0) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			int length = arg0.length;
			if (arg2 != 0) {
				length = arg2;
			}
			for (int i = 0; i < length; i++) {
				if (arg1 == null)
					arg1 = "";
				sb.append(arg0[i]).append(arg1);
			}
			sb.delete(sb.lastIndexOf(arg1), sb.length());
			return sb.toString();
		}
	}

	/**
	 * 描述：List转换为字符串
	 * 
	 * @param list
	 *            List数据
	 * @param separation
	 *            间隔符
	 * @return
	 */
	public static String listToString(List<?> list) {
		return listToString(list, ",");
	}

	/**
	 * 描述：List转换为字符串
	 * 
	 * @param list
	 *            List数据
	 * @param separation
	 *            间隔符
	 * @return
	 */
	public static String listToString(List<?> list, String separation) {
		return arrToString(listToStringArray(list), separation);
	}

	/**
	 * 描述：字串数据元素包装
	 * 
	 * @param sArr
	 *            字串数据
	 * @param pre
	 *            前缀
	 * @param aft
	 *            后缀
	 * @return
	 */
	public static String[] strArrDoPack(String[] sArr, String pre, String aft) {
		return strArrDoPack(sArr, pre, aft, 1, 0);
	}

	/**
	 * 描述：字串数据元素包装
	 * 
	 * @param sArr
	 *            字串数据
	 * @param pre
	 *            前缀
	 * @param aft
	 *            后缀
	 * @param num
	 *            生成个数
	 * @return
	 */
	public static String[] strArrDoPack(String[] sArr, String pre, String aft, int num) {
		return strArrDoPack(sArr, pre, aft, num, 0);
	}

	/**
	 * 描述：字串数据元素包装
	 * 
	 * @param sArr
	 *            字串数据
	 * @param pre
	 *            前缀
	 * @param aft
	 *            后缀
	 * @param num
	 *            生成个数
	 * @param step
	 *            数字值1：加，-1：减，0：不变
	 * @return
	 */
	public static String[] strArrDoPack(String[] sArr, String pre, String aft, int num, int step) {
		String[] arr = null;
		if (sArr != null) {
			boolean isAdd = false;
			if (step > 0) {
				isAdd = true;
			}

			if (num < 0) {
				num = 1;
			}

			arr = new String[sArr.length * num];
			int icount = 0;
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < sArr.length; j++) {
					if (StringHelper.isNotEmpty(pre)) {
						arr[icount] = pre + sArr[j];
					}
					if (StringHelper.isNotEmpty(aft)) {
						arr[icount] += aft;
					}
					icount++;
				}

				boolean b = false;
				if (step != 0) {
					pre = stepNumInStr(pre, isAdd);
					b = true;
				}
				if (!b) {
					if (step != 0) {
						aft = stepNumInStr(aft, isAdd);
					}
				}
			}

		}
		return arr;
	}

	/**
	 * 描述：生成字符串
	 * 
	 * @param arg0
	 *            字符串元素
	 * @param arg1
	 *            生成个数
	 * @return
	 */
	public static String createStr(String arg0, int arg1) {
		if (arg0 == null) {
			return "";
		}
		return createStr(arg0, arg1, ",");
	}

	/**
	 * 描述：生成字符串
	 * 
	 * @param arg0
	 *            字符串元素
	 * @param arg1
	 *            生成个数
	 * @param arg2
	 *            间隔符号
	 * @return
	 */
	public static String createStr(String arg0, int arg1, String arg2) {
		if (arg0 == null) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arg1; i++) {
				if (arg2 == null)
					arg2 = "";
				sb.append(arg0).append(arg2);
			}
			if (sb.length() > 0) {
				sb.delete(sb.lastIndexOf(arg2), sb.length());
			}

			return sb.toString();
		}
	}

	/**
	 * 描述：生成字符串数据
	 * 
	 * @param arg0
	 *            字符串元素
	 * @param arg1
	 *            生成个数
	 * @param arg2
	 *            间隔符号
	 * @return
	 */
	public static String[] createStrArr(String arg0, int arg1) {
		if (arg0 == null) {
			return null;
		} else {
			String[] arr = new String[arg1];
			for (int i = 0; i < arg1; i++) {
				arr[i] = arg0;
			}

			return arr;
		}
	}

	/**
	 * 描述：只保留字符串的英文字母和“_”号
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceAllSign(String str) {
		if (str != null && str.length() > 0) {
			str = str.replaceAll("[^a-zA-Z_]", "");
		}
		return str;
	}

	/**
	 * 描述：字串中的数字值加1
	 * 
	 * @param str
	 *            字串
	 * @param isAdd
	 *            数字值true：加，false：减
	 * @return
	 */
	public static String stepNumInStr(String str, boolean isAdd) {
		String sNum = str.replaceAll("[^0-9]", ",").trim();
		if (sNum == null || sNum.length() == 0) {
			return str;
		}
		String[] sNumArr = sNum.split(",");

		for (int i = 0; i < sNumArr.length; i++) {
			if (sNumArr[i] != null && sNumArr[i].length() > 0) {
				int itemp = Integer.parseInt(sNumArr[i]);
				if (isAdd) {
					itemp += 1;
				} else {
					itemp -= 1;
				}
				str = str.replaceFirst(sNumArr[i], String.valueOf(itemp));
				break;
			}
		}

		return str;
	}

	/**
	 * 描述：list 转换为 String[]
	 * 
	 * @param list
	 * @return
	 */
	public static String[] listToStringArray(List<?> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		return (String[]) list.toArray(new String[list.size()]);
	}

}
