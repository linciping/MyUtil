package com.linciping.library;

import org.junit.Test;

import java.util.Scanner;


/**
 * @author linciping
 *         2017/9/11
 */
public class CheckUtilTest {

    @Test
    public void testStringEmpty(){
        String content="测试内容";
        System.out.println(CheckUtil.isStringEmpty(content));
    }
}