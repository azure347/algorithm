package cn.other.singleton;

/**
 * @author July
 * @description 枚举 -- 这是实现单例模式的最佳方法，它不仅能避免多线程同步问题，还能防止反序列化重新创建新的对象
 * @create 2025-11-23 23:09
 */
public enum EnumSingleton {

    INSTANCE;
}

// 调用方式：EnumSingleton.INSTANCE
