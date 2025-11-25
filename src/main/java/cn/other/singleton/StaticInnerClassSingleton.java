package cn.other.singleton;

/**
 * @author July
 * @description 静态内部类 -- 利用类加载机制保证初始化实例时只有一个线程，线程安全，且实现延迟加载
 * @create 2025-11-23 23:04
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {}

    // 静态内部类在第一次被引用时才会加载
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
