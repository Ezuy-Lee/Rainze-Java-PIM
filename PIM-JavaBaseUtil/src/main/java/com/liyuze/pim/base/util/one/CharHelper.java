package com.liyuze.pim.base.util.one;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * <p>
 * Title:字符编码工具类
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author:
 * @version 1.0
 */
public class CharHelper {

	/**
	 * 转换编码 ISO-8859-1到GB2312
	 * 
	 * @param text
	 * @return
	 */
	public static final String ISO2GB(String text) {
		String result = "";
		try {
			result = new String(text.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException ex) {
			result = ex.toString();
		}
		return result;
	}

	/**
	 * 转换编码 GB2312到ISO-8859-1
	 * 
	 * @param text
	 * @return
	 */
	public static final String GB2ISO(String text) {
		String result = "";
		try {
			result = new String(text.getBytes("GB2312"), "ISO-8859-1");
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static String GBK2UTF8(String strVal) {
		try {
			if (strVal == null) {
				return "";
			} else {
				strVal = new String(strVal.getBytes("GBK"), "UTF-8");
				return strVal;
			}
		} catch (Exception exp) {
			return "";
		}
	}

	/**
	 * 字符串从GBK编码转换为Unicode编码
	 * 
	 * @param text
	 * @return
	 */
	public static String GBK2Unicode(String text) {
		String result = "";
		int input;
		StringReader isr;
		try {
			isr = new StringReader(new String(text.getBytes(), "GBK"));
		} catch (UnsupportedEncodingException e) {
			return "-1";
		}
		try {
			while ((input = isr.read()) != -1) {
				result = result + "&#x" + Integer.toHexString(input) + ";";

			}
		} catch (IOException e) {
			return "-2";
		}
		isr.close();
		return result;

	}

	/**
	 * Author:Jack Time:2017年9月2日下午5:40:19
	 * 
	 * @param strVal
	 * @return Return:String Description:
	 */
	public static String ISO2UTF8(String strVal) {
		try {
			if (strVal == null) {
				return "";
			} else {
				strVal = new String(strVal.getBytes("ISO-8859-1"), "UTF-8");
				return strVal;
			}
		} catch (Exception exp) {
			return "";
		}
	}

	/**
	 * Author:Jack Time:2017年9月2日下午5:40:25
	 * 
	 * @param strVal
	 * @return Return:String Description:
	 */
	public static String UTF82ISO(String strVal) {
		try {
			if (strVal == null) {
				return "";
			} else {
				strVal = new String(strVal.getBytes("UTF-8"), "ISO-8859-1");
				return strVal;
			}
		} catch (Exception exp) {
			return "";
		}
	}

	/**
	 * 把字符串转换为UTF8859编码
	 *
	 * @param source
	 *            需要进行转换的字符串
	 */
	public static final String GBKto8859(String source) {
		String temp = null;
		if (source == null || source.equals("")) {
			return source;
		}
		try {
			temp = new String(source.getBytes("GBK"), "8859_1");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Convert code Error");
		}
		return temp;
	}

	/**
	 * 把字符串转换为GBK编码
	 *
	 * @param source
	 *            需要进行转换的字符串
	 */
	public static final String toGBK(String source) {
		String temp = null;
		if (source == null || source.equals("")) {
			return source;
		}
		try {
			temp = new String(source.getBytes("8859_1"), "GBK");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Convert code Error");
		}
		return temp;
	}

	/**
	 * 把字符串转换为gb2312编码
	 *
	 * @param source
	 *            需要进行转换的字符串
	 */
	public static final String toGb2312(String source) {
		String temp = null;
		if (source == null || source.equals("")) {
			return source;
		}
		try {
			temp = new String(source.getBytes("8859_1"), "GB2312");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("转换字符串为gb2312编码出错");
		}
		return temp;
	}

	/**
	 * 把中文字符串，转换为unicode字符串
	 *
	 * @param source
	 *            需要进行转换的字符串
	 * @return 转换后的unicode字符串
	 */
	public static String chineseToUnicode(String source) {
		if (source == null || source.trim().length() == 0) {
			return source;
		}
		String unicode = null;
		String temp = null;
		for (int i = 0; i < source.length(); i++) {
			temp = "\\u" + Integer.toHexString((int) source.charAt(i));
			unicode = unicode == null ? temp : unicode + temp;
		}
		return unicode;
	}

	/**
	 * 在将数据存入数据库前转换
	 * 
	 * @param strVal
	 *            要转换的字符串
	 * @return 从“ISO8859_1”到“GBK”得到的字符串
	 * @since 1.0
	 */
	public static String toChinese(String strVal) {
		try {
			if (strVal == null) {
				return "";
			} else {
				strVal = strVal.trim();
				strVal = new String(strVal.getBytes("ISO8859_1"), "GBK");
				return strVal;
			}
		} catch (Exception exp) {
			return "";
		}
	}

	/**
	 * Utf8URL编码
	 * 
	 * @param s
	 * @return
	 */
	public static final String Utf8URLencode(String text) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < text.length(); i++) {

			char c = text.charAt(i);
			if (c >= 0 && c <= 255) {
				result.append(c);
			} else {

				byte[] b = new byte[0];
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (Exception ex) {
				}

				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					result.append("%" + Integer.toHexString(k).toUpperCase());
				}

			}
		}

		return result.toString();
	}

	/**
	 * Utf8URL解码
	 * 
	 * @param text
	 * @return
	 */
	public static final String Utf8URLdecode(String text) {
		String result = "";
		int p = 0;

		if (text != null && text.length() > 0) {
			text = text.toLowerCase();
			p = text.indexOf("%e");
			if (p == -1)
				return text;

			while (p != -1) {
				result += text.substring(0, p);
				text = text.substring(p, text.length());
				if (text == "" || text.length() < 9)
					return result;

				result += CodeToWord(text.substring(0, 9));
				text = text.substring(9, text.length());
				p = text.indexOf("%e");
			}

		}

		return result + text;
	}

	/**
	 * utf8URL编码转字符
	 * 
	 * @param text
	 * @return
	 */
	private static final String CodeToWord(String text) {
		String result;

		if (Utf8codeCheck(text)) {
			byte[] code = new byte[3];
			code[0] = (byte) (Integer.parseInt(text.substring(1, 3), 16) - 256);
			code[1] = (byte) (Integer.parseInt(text.substring(4, 6), 16) - 256);
			code[2] = (byte) (Integer.parseInt(text.substring(7, 9), 16) - 256);
			try {
				result = new String(code, "UTF-8");
			} catch (UnsupportedEncodingException ex) {
				result = null;
			}
		} else {
			result = text;
		}

		return result;
	}

	/**
	 * 编码是否有效
	 * 
	 * @param text
	 * @return
	 */
	@SuppressWarnings("unused")
	private static final boolean Utf8codeCheck(String text) {
		String sign = "";
		if (text.startsWith("%e"))
			for (int i = 0, p = 0; p != -1; i++) {
				p = text.indexOf("%", p);
				if (p != -1)
					p++;
				sign += p;
			}
		return sign.equals("147-1");
	}

	/**
	 * 判断是否Utf8Url编码
	 * 
	 * @param text
	 * @return
	 */
	public static final boolean isUtf8Url(String text) {
		text = text.toLowerCase();
		int p = text.indexOf("%");
		if (p != -1 && text.length() - p > 9) {
			text = text.substring(p, p + 9);
		}
		return Utf8codeCheck(text);
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// CharTools charTools = new CharTools();

		String url;

		url = "http://www.google.com/search?hl=zh-CN&newwindow=1&q=%E4%B8%AD%E5%9B%BD%E5%A4%A7%E7%99%BE%E7%A7%91%E5%9C%A8%E7%BA%BF%E5%85%A8%E6%96%87%E6%A3%80%E7%B4%A2&btnG=%E6%90%9C%E7%B4%A2&lr=";
		if (CharHelper.isUtf8Url(url)) {
			System.out.println(CharHelper.Utf8URLdecode(url));
		} else {
			// System.out.println(URLDecoder.decode(url));
		}

		url = "http://www.baidu.com/baidu?word=%D6%D0%B9%FA%B4%F3%B0%D9%BF%C6%D4%DA%CF%DF%C8%AB%CE%C4%BC%EC%CB%F7&tn=myie2dg";
		if (CharHelper.isUtf8Url(url)) {
			System.out.println(CharHelper.Utf8URLdecode(url));
		} else {
			// System.out.println(URLDecoder.decode(url));
		}

	}

}
