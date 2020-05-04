package com.liyuze.pim.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 作者: liyuze
 * 时间: 2017年9月2日下午8:38:17
 * 说明: 常用的数据验证工具类。
 *
 */
public class ValidateUtil {

	
	 public static final Pattern CODE_PATTERN = Pattern.compile("^0\\d{2,4}$");
	 public static final Pattern POSTCODE_PATTERN = Pattern.compile("^\\d{6}$");
	 public static final Pattern BANK_CARD_PATTERN = Pattern.compile("^\\d{16,30}$");
	 /** 
	     * 匹配图象 
	     *  
	     *  
	     * 格式: /相对路径/文件名.后缀 (后缀为gif,dmp,png) 
	     *  
	     * 匹配 : /forum/head_icon/admini2005111_ff.gif 或 admini2005111.dmp 
	     *  
	     *  
	     * 不匹配: c:/admins4512.gif 
	     *  
	     */  
	    public static final String ICON_REGEXP = "^(/{0,1}//w){1,}//.(gif|dmp|png|jpg)$|^//w{1,}//.(gif|dmp|png|jpg)$";  
	  
	    /** 
	     * 匹配email地址 
	     *  
	     *  
	     * 格式: XXX@XXX.XXX.XX 
	     *  
	     * 匹配 : foo@bar.com 或 foobar@foobar.com.au 
	     *  
	     * 不匹配: foo@bar 或 $$$@bar.com 
	     *  
	     */  
	    public static final String EMAIL_REGEXP = "(?://w[-._//w]*//w@//w[-._//w]*//w//.//w{2,3}$)";  
	  
	    /** 
	     * 匹配并提取url 
	     *  
	     *  
	     * 格式: XXXX://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX 
	     *  
	     * 匹配 : http://www.suncer.com 或news://www 
	     *  
	     * 不匹配: c:/window 
	     *  
	     */  
	    public static final String URL_REGEXP = "(//w+)://([^/:]+)(://d*)?([^#//s]*)";  
	  
	    /** 
	     * 匹配并提取http 
	     *  
	     * 格式: http://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX 或 ftp://XXX.XXX.XXX 或 
	     * https://XXX 
	     *  
	     * 匹配 : http://www.suncer.com:8080/index.html?login=true 
	     *  
	     * 不匹配: news://www 
	     *  
	     */  
	    public static final String HTTP_REGEXP = "(http|https|ftp)://([^/:]+)(://d*)?([^#//s]*)";  
	  
	    /** 
	     * 匹配日期 
	     *  
	     *  
	     * 格式(首位不为0): XXXX-XX-XX或 XXXX-X-X 
	     *  
	     *  
	     * 范围:1900--2099 
	     *  
	     *  
	     * 匹配 : 2005-04-04 
	     *  
	     *  
	     * 不匹配: 01-01-01 
	     *  
	     */  
	    public static final String DATE_BARS_REGEXP = "^((((19){1}|(20){1})\\d{2})|\\d{2})-[0,1]?\\d{1}-[0-3]?\\d{1}$";    
	  
	    /** 
	     * 匹配日期 
	     *  
	     *  
	     * 格式: XXXX/XX/XX 
	     *  
	     *  
	     * 范围: 
	     *  
	     *  
	     * 匹配 : 2005/04/04 
	     *  
	     *  
	     * 不匹配: 01/01/01 
	     *  
	     */  
	    public static final String DATE_SLASH_REGEXP = "^[0-9]{4}/(((0[13578]|(10|12))/(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)/(0[1-9]|[1-2][0-9]|30)))$";  
	  
	    /** 
	     * 匹配电话 
	     *  
	     *  
	     * 格式为: 0XXX-XXXXXX(10-13位首位必须为0) 或0XXX XXXXXXX(10-13位首位必须为0) 或 
	     *  
	     * (0XXX)XXXXXXXX(11-14位首位必须为0) 或 XXXXXXXX(6-8位首位不为0) 或 
	     * XXXXXXXXXXX(11位首位不为0) 
	     *  
	     *  
	     * 匹配 : 0371-123456 或 (0371)1234567 或 (0371)12345678 或 010-123456 或 
	     * 010-12345678 或 12345678912 
	     *  
	     *  
	     * 不匹配: 1111-134355 或 0123456789 
	     *  
	     */  
	    public static final String PHONE_REGEXP = "^(?:0[0-9]{2,3}[-//s]{1}|//(0[0-9]{2,4}//))[0-9]{6,8}$|^[1-9]{1}[0-9]{5,7}$|^[1-9]{1}[0-9]{10}$";  
	  
	    /** 
	     * 匹配身份证 
	     *  
	     * 格式为: XXXXXXXXXX(10位) 或 XXXXXXXXXXXXX(13位) 或 XXXXXXXXXXXXXXX(15位) 或 
	     * XXXXXXXXXXXXXXXXXX(18位) 
	     *  
	     * 匹配 : 0123456789123 
	     *  
	     * 不匹配: 0123456 
	     *  
	     */  
	    public static final String ID_CARD_REGEXP = "^//d{10}|//d{13}|//d{15}|//d{18}$";  
	  
	    /** 
	     * 匹配邮编代码 
	     *  
	     * 格式为: XXXXXX(6位) 
	     *  
	     * 匹配 : 012345 
	     *  
	     * 不匹配: 0123456 
	     *  
	     */  
	    public static final String ZIP_REGEXP = "^[0-9]{6}$";// 匹配邮编代码  
	  
	    /** 
	     * 不包括特殊字符的匹配 (字符串中不包括符号 数学次方号^ 单引号' 双引号" 分号; 逗号, 帽号: 数学减号- 右尖括号> 左尖括号< 反斜杠/ 
	     * 即空格,制表符,回车符等 ) 
	     *  
	     * 格式为: x 或 一个一上的字符 
	     *  
	     * 匹配 : 012345 
	     *  
	     * 不匹配: 0123456 // ;,:-<>//s].+$";// 
	     */  
	    public static final String NON_SPECIAL_CHAR_REGEXP = "^[^'/";  
	    // 匹配邮编代码  
	  
	    /** 
	     * 匹配非负整数（正整数 + 0) 
	     */  
	    public static final String NON_NEGATIVE_INTEGERS_REGEXP = "^//d+$";  
	  
	    /** 
	     * 匹配不包括零的非负整数（正整数 > 0) 
	     */  
	    public static final String NON_ZERO_NEGATIVE_INTEGERS_REGEXP = "^[1-9]+//d*$";  
	  
	    /** 
	     *  
	     * 匹配正整数 
	     *  
	     */  
	    public static final String POSITIVE_INTEGER_REGEXP = "^[0-9]*[1-9][0-9]*$";  
	  
	    /** 
	     *  
	     * 匹配非正整数（负整数 + 0） 
	     *  
	     */  
	    public static final String NON_POSITIVE_INTEGERS_REGEXP = "^((-//d+)|(0+))$";  
	  
	    /** 
	     *  
	     * 匹配负整数 
	     *  
	     */  
	    public static final String NEGATIVE_INTEGERS_REGEXP = "^-[0-9]*[1-9][0-9]*$";  
	  
	    /** 
	     *  
	     * 匹配整数 
	     *  
	     */  
	    public static final String INTEGER_REGEXP = "^-?//d+$";  
	  
	    /** 
	     *  
	     * 匹配非负浮点数（正浮点数 + 0） 
	     *  
	     */  
	    public static final String NON_NEGATIVE_RATIONAL_NUMBERS_REGEXP = "^//d+(//.//d+)?$";  
	  
	    /** 
	     *  
	     * 匹配正浮点数 
	     *  
	     */  
	    public static final String POSITIVE_RATIONAL_NUMBERS_REGEXP = "^(([0-9]+//.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*//.[0-9]+)|([0-9]*[1-9][0-9]*))$";  
	  
	    /** 
	     *  
	     * 匹配非正浮点数（负浮点数 + 0） 
	     *  
	     */  
	    public static final String NON_POSITIVE_RATIONAL_NUMBERS_REGEXP = "^((-//d+(//.//d+)?)|(0+(//.0+)?))$";  
	  
	    /** 
	     *  
	     * 匹配负浮点数 
	     *  
	     */  
	    public static final String NEGATIVE_RATIONAL_NUMBERS_REGEXP = "^(-(([0-9]+//.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*//.[0-9]+)|([0-9]*[1-9][0-9]*)))$";  
	  
	    /** 
	     *  
	     * 匹配浮点数 
	     *  
	     */  
	    public static final String RATIONAL_NUMBERS_REGEXP = "^(-?//d+)(//.//d+)?$";  
	  
	    /** 
	     *  
	     * 匹配由26个英文字母组成的字符串 
	     *  
	     */  
	    public static final String LETTER_REGEXP = "^[A-Za-z]+$";  
	  
	    /** 
	     *  
	     * 匹配由26个英文字母的大写组成的字符串 
	     *  
	     */  
	    public static final String UPWARD_LETTER_REGEXP = "^[A-Z]+$";  
	  
	    /** 
	     *  
	     * 匹配由26个英文字母的小写组成的字符串 
	     *  
	     */  
	    public static final String LOWER_LETTER_REGEXP = "^[a-z]+$";  
	  
	    /** 
	     *  
	     * 匹配由数字和26个英文字母组成的字符串 
	     *  
	     */  
	    public static final String LETTER_NUMBER_REGEXP = "^[A-Za-z0-9]+$";  
	  
	    /** 
	     *  
	     * 匹配由数字、26个英文字母或者下划线组成的字符串 
	     *  
	     */  
	    public static final String LETTER_NUMBER_UNDERLINE_REGEXP = "^//w+$";  
	  
	
	public static boolean validateEmail(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		}
		Pattern pattern = Pattern.compile(
				"^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

		// Pattern pattern =
		// Pattern.compile("^([a-zA-Z0-9_-])+@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}");
		Matcher matcher = pattern.matcher(str);

		return matcher.matches();

	}

	public static boolean validateMoblie(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		}
		Pattern pattern = Pattern.compile("^(13|14|15|17|18)[0-9]{9}$");
		Matcher matcher = pattern.matcher(str);

		return matcher.matches();

	}
	
	 /**
     * 验证区号是否有效.
     *
     * @param code 要验证的区号
     * @return 是否正确身份证
     */
    public static boolean validateCode(String code) {
        if (StringHelper.isEmpty(code)) {
            return false;
        }
        Matcher m = CODE_PATTERN.matcher(code);
        return m.matches();
    }

    /**
     * 验证邮政编码是否有效.
     *
     * @param postcode 要验证的邮政编码
     * @return 是否正确邮政编码
     */
    public static boolean validatePostcode(String postcode) {
        if (StringHelper.isEmpty(postcode)) {
            return false;
        }
        Matcher m = POSTCODE_PATTERN.matcher(postcode);
        return m.matches();
    }
    
    /**
     * 验证银行卡是否有效.
     *
     * @param bankCardNumber 要验证的银行卡号
     * @return 是否正确银行卡号
     */
    public static boolean validateBankCardNumber(String bankCardNumber) {
        if (StringHelper.isEmpty(bankCardNumber)) {
            return false;
        }
        Matcher m = BANK_CARD_PATTERN.matcher(bankCardNumber);
        return m.matches();
    }
    
    /**
     * 通过身份证获取生日
     *
     * @param idNumber 身份证号
     * @return 返回生日, 格式为 yyyy-MM-dd 的字符串
     */
    public static String getBirthdayByIdNumber(String idNumber) {

        String birthday = "";

        if (idNumber.length() == 15) {
            birthday = "19" + idNumber.substring(6, 8) + "-" + idNumber.substring(8, 10) + "-" + idNumber.substring(10, 12);
        } else if (idNumber.length() == 18) {
            birthday = idNumber.substring(6, 10) + "-" + idNumber.substring(10, 12) + "-" + idNumber.substring(12, 14);
        }

        return birthday;

    }
	
    /**
     * 通过身份证获取性别
     *
     * @param idNumber 身份证号
     * @return 返回性别, 0 保密 , 1 男 2 女
     */
    public static Integer getGenderByIdNumber(String idNumber) {

        int gender = 0;

        if (idNumber.length() == 15) {
            gender = Integer.parseInt(String.valueOf(idNumber.charAt(14))) % 2 == 0 ? 2 : 1;
        } else if (idNumber.length() == 18) {
            gender = Integer.parseInt(String.valueOf(idNumber.charAt(16))) % 2 == 0 ? 2 : 1;
        }

        return gender;

    }
    
	/**
     * 通过身份证获取年龄
     *
     * @param idNumber     身份证号
     * @param isNominalAge 是否按元旦算年龄，过了1月1日加一岁 true : 是 false : 否
     * @return 返回年龄
     */
    public static Integer getAgeByIdNumber(String idNumber, boolean isNominalAge) {

        String birthString = getBirthdayByIdNumber(idNumber);
        if (StringHelper.isEmpty(birthString)) {
            return 0;
        }

        return getAgeByBirthString(birthString, isNominalAge);

    }
	
	
	 /**
     * 通过生日日期获取年龄
     *
     * @param birthDate 生日日期
     * @return 返回年龄
     */
    public static Integer getAgeByBirthDate(Date birthDate) {

        return getAgeByBirthString(new SimpleDateFormat("yyyy-MM-dd").format(birthDate));

    }
	
	 /**
     * 通过生日字符串获取年龄
     *
     * @param birthString 生日字符串
     * @return 返回年龄
     */
    public static Integer getAgeByBirthString(String birthString) {

        return getAgeByBirthString(birthString, "yyyy-MM-dd");

    }

	
	 /**
     * 通过生日字符串获取年龄
     *
     * @param birthString  生日字符串
     * @param isNominalAge 是否按元旦算年龄，过了1月1日加一岁 true : 是 false : 否
     * @return 返回年龄
     */
    public static Integer getAgeByBirthString(String birthString, boolean isNominalAge) {

        return getAgeByBirthString(birthString, "yyyy-MM-dd", isNominalAge);

    }
	
	/**
     * 通过生日字符串获取年龄
     *
     * @param birthString 生日字符串
     * @param format      日期字符串格式,为空则默认"yyyy-MM-dd"
     * @return 返回年龄
     */
    public static Integer getAgeByBirthString(String birthString, String format) {
        return getAgeByBirthString(birthString, "yyyy-MM-dd", false);
    }
	
	/**
     * 通过生日字符串获取年龄
     *
     * @param birthString  生日字符串
     * @param format       日期字符串格式,为空则默认"yyyy-MM-dd"
     * @param isNominalAge 是否按元旦算年龄，过了1月1日加一岁 true : 是 false : 否
     * @return 返回年龄
     */
    public static Integer getAgeByBirthString(String birthString, String format, boolean isNominalAge) {
        int age = 0;
        if (StringHelper.isEmpty(birthString)) {
            return age;
        }
        if (StringHelper.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }
        try {

            Calendar birthday = Calendar.getInstance();
            Calendar today = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            birthday.setTime(sdf.parse(birthString));
            age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
            if (!isNominalAge) {
                if (today.get(Calendar.MONTH) < birthday.get(Calendar.MONTH) ||
                        (today.get(Calendar.MONTH) == birthday.get(Calendar.MONTH) &&
                                today.get(Calendar.DAY_OF_MONTH) < birthday.get(Calendar.DAY_OF_MONTH))) {
                    age = age - 1;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return age;

    }
    
    /** 
     * 大小写敏感的正规表达式批配 
     *  
     * @param source 
     *            批配的源字符串 
     * @param regexp 
     *            批配的正规表达式 
     * @return 如果源字符串符合要求返回真,否则返回假 
     */  
    public static boolean isHardRegexpValidate(String str, String regexp) {
	    	if (str == null || str.trim().length() == 0) {
				return false;
			}
        	Pattern pattern = Pattern.compile(regexp);
    		Matcher matcher = pattern.matcher(str);
    		return matcher.matches();
    }  
	
}
