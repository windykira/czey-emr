package com.haoze;

/**
 * Created by haoz-dev4 on 2018/6/23.
 */
public class Test {

    @org.junit.Test
    public void test() {

        String str = "D:\\dc\\emr\\27b9b502a7024d38abeaf58a4ae6b735.xml";
        String newStr = str.substring(str.lastIndexOf("\\") + 1).replace(".xml","");
        System.out.println(newStr);
    }
}
