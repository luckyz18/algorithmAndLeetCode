package testdemo;

import java.util.HashMap;
import java.util.Map;

public class CopyMap {
    public static void fun1(){
        Map<String,String> m1 = new HashMap<>();
        m1.put("a","aa");
        //Map m2 = new HashMap(m1);  //深拷贝
        Map<String,String>  m2 = (Map<String, String>) ((HashMap<String, String>) m1).clone();
        //m2.put("b","bb");
        m2.put("a","aaaaa");
        System.out.println();
    }

    public static void main(String[] args) {
        fun1();
    }
}
