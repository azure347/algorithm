package cn.other.singleton;

/**
 * @author July
 * @description 懒汉式 -- 在第一次调用getInstance方法时才会创建实例，但为了线程安全，需要加锁，可能影响性能
 * @create 2025-11-23 22:45
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
