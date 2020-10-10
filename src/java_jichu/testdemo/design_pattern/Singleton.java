package java_jichu.testdemo.design_pattern;

/**
 * 单例模式实现
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton(){

    }
    //懒汉式  有线程安全问题
    public static Singleton getUniqueSingleton(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
    //饿汉式  没有线程安全问题 但是这个类如果不用也会实例化 浪费资源

    //懒汉式 线程安全 性能问题 不推荐使用
    public static synchronized Singleton getUniqueSingleton2(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //双重锁校验  线程安全  volatile
    public volatile static Singleton instance;
    public  static Singleton getInstance(){
        if (instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    //静态内部类实现
    private static class SingletonHandle{
        private static final Singleton instance2 = new Singleton();
    }
    public static Singleton getInstance2(){
        return SingletonHandle.instance2;
    }

    //枚举类
    public static enum EnumSingleton{
        INSTANCE;
        private Singleton singletonObj;
        //jvm 保证这个方法只调用一次
        EnumSingleton(){
            singletonObj = new Singleton();
        }
        public Singleton getSingletonObj(){
            return singletonObj;
        }
    }
    public Singleton getInstance3(){
        return EnumSingleton.INSTANCE.getSingletonObj();
    }


}
