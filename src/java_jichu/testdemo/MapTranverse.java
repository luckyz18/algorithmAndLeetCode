package java_jichu.testdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map 的遍历方式
 */
public class MapTranverse {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("name", "老王");
        hashMap.put("sex", "你猜");
        hashMap.put("b", "bb");
        hashMap.put("a", "aa");
        //entrySet
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() +","+ entry.getValue());
        }
        //iterator
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+"-----"+next.getValue());
        }
        //keySet
        Set<String> set = hashMap.keySet();
        for (String s : set) {
            System.out.println(s+"+++++++" + hashMap.get(s));
        }
    }
}
