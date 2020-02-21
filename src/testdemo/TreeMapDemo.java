package testdemo;

import java.util.*;

/**
 * treemap value 倒序排列
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap();
        treeMap.put("a", "aa");
        treeMap.put("b", "bb");
        treeMap.put("c", "cc");
        treeMap.put("d", "dd");
       /* // map.entrySet() 转成 List
        List<Map.Entry<String, String>> list = new ArrayList<> (treeMap.entrySet());
        // 通过比较器实现比较排序
        Collections.sort(list, new Comparator<Map.Entry<String,  String>>() {
            public int compare(Map.Entry<String, String> m1, Map.Entry<String, String> m2) {
                return m2.getValue().compareTo(m1.getValue());
            }
        });
        // 打印结果
        for (Map.Entry<String, String> item : list) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }*/

       //
        NavigableMap<String, String> m = treeMap.descendingMap();
        Iterator<Map.Entry<String, String>> iterator = m.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
