package cn.datastructures;

/**
 * 类说明
 *
 * @author wanghao
 * @date 2022/7/21 14:59
 */
public class Asserts {
    public static void test(boolean value) {
        try {
            if (!value) throw new Exception("测试未通过");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}