package testdemo;

import java.io.*;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        BirdChild birdChild = new BirdChild();
        birdChild.name = "小小鸟";
        Bird bird = new Bird();
        bird.name = "小鸟";
        bird.birdChild = birdChild;
        // 使用序列化克隆对象
        Bird bird2 = (Bird) bird.clone();
        bird2.name = "黄雀";
        bird2.birdChild.name = "小黄雀";
        System.out.println("bird name:" + bird.name);
        System.out.println("bird child name:" + bird.birdChild.name);
        System.out.println("bird name 2:" + bird2.name);
        System.out.println("bird child name 2:" + bird2.birdChild.name);
    }
}
//通过序列化 实现深拷贝
class Bird implements Cloneable ,Serializable{
    public String name;
    public BirdChild birdChild;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Bird bird = (Bird) super.clone();
        bird.birdChild = (BirdChild) birdChild.clone();
        return bird;
    }
}
class BirdChild implements Serializable,Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String name;
}

/*
class CloneUtils {
    //原生的方式
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bo);
            oos.writeObject(obj);
            oos.close();
            //分配内存,写入原始对象,生成新对象
            ByteArrayInputStream bi = new
                    ByteArrayInputStream(bo.toByteArray());//获取上面的输出字节流
            ObjectInputStream oi = new
                    ObjectInputStream(bi);
            //返回生成的新对象
            cloneObj = (T) oi.readObject();
            oi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}
*/
