package cn.other.singleton;

/**
 * @author July
 * @description 饿汉式 —— 在类加载的时候就创建实例，线程安全，但可能会提取占用系统资源
 * @create 2025-11-23 22:41
 */
public class EagerSingleton {

    // 类加载时就创建实例
    private static final EagerSingleton instance = new EagerSingleton();

    // 私有构造函数
    private EagerSingleton() {
        // 防止通过反射创建实例
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
