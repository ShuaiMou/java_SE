package cn.saul.specialTestDemo;

import org.junit.Test;

/**
 * @Auther: Saul
 * @Date: 13/2/20 10:42 PM
 * @Description:
 */
public class SpecialTest {
    /***
     * @Author Saul
     * @Description  TODO: 测试Integer 用valueOf时的缓存-128 ～ 127 （包含首尾）
     *                    Long也一样, Byte也有缓存
     * @Date 11:13 PM 13/2/20
     */
    @Test
    public void test1(){
        Integer a = Integer.valueOf(128);
        Integer b = Integer.valueOf(128);

        Integer c = Integer.valueOf(127);
        Integer d = Integer.valueOf(127);

        Integer e = new Integer(128);
        Integer f = new Integer(128);

        int g = 128;

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(a == g);
        System.out.println(e == g);
        System.out.println(a == e);
    }
}
