package kaoshi;

public class Singleton {

    private static volatile Singleton instance;
    private Singleton(){

    }
    public Singleton getInstance(){
        if (instance == null){  //避免实例化后的加锁操作
            synchronized (Singleton.class){
                if (instance == null){  //避免实例化多次
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
