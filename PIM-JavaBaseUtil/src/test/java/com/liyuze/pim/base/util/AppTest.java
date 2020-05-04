package com.liyuze.pim.base.util;

import com.alibaba.fastjson.JSONObject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
//       User user = new User(18, null, "Jack", 2);
//       String jsonString = FastJsonUtil.toJSONString(user);
//       System.out.println(jsonString);
//       User us =  FastJsonUtil.toBean(jsonString,User.class);
//       System.out.println(us);
    	 /** 
         * 主函数，测试请求 
         *  
         * @param args 
         */  
            Map<String, String> parameters = new HashMap<String, String>();  
            parameters.put("name", "sarin");  
            parameters.put("age", "18"); 
            String jsonResult =HttpUtils.sendPostJson("http://127.0.0.1:8081/member/getMemberByParam", parameters);
            System.out.println(jsonResult); 
            JSONObject obj = FastJsonUtil.toJsonObj(jsonResult);
            System.out.println(obj);
    }
}
