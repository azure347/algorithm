package cn.other.singleton;

/**
 * @author July
 * @description 双重检查锁 -- 在懒汉式的基础上，减少同步块的范围
 * @create 2025-11-23 22:52
 */
public class DoubleCheckedSingleton {

    // 使用volatile防止指令重排
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {}

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
