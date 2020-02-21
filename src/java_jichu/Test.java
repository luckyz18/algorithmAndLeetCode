package java_jichu;

import java.util.*;

public class Test {
    public static void test() {
        String a = new String("a");
        String b = new String("a");
        String g = new String(a);
        String c = a.intern();
        String d = b.intern();

        String e = "a";

        System.out.println(a == c);
        System.out.println(a == g);
        //System.out.println(b == e);
        //System.out.println(c == e);
        //System.out.println(d == e);
        //
        //Integer a = Integer.valueOf(1);
        //Integer b = Integer.valueOf(1);
        //Integer d = Integer.valueOf(130);
        //Integer c = Integer.valueOf(130);
        //System.out.println(a == b);
        //System.out.println(c == d);
    }

    public static void test2() {
        Student a = new Student("a", 1, 2);
        Student b = new Student("a", 1, 2);
        System.out.println(a.equals(b) + "-------------");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        //Integer c = new Integer(1);
        //Integer d = new Integer(1);
        //System.out.println(c.equals(d)+"======");

        HashSet<Object> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size());
        String s = "aaa";

    }

    public static void test3() {
        Student a = new Student("a", 1, 2);
        try {
            Student b = (Student) a.clone();
            System.out.println(b.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void testMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("dsssa", "one");
        map.put("ajkvjfnv", "two");
        map.put("cjfns",  "three");
        map.put("jfhshf", "three");
        map.put("ffhshf", "three");
        map.put("hfhshf", "three");
        map.put("bjjfjs", "three");
        map.put("egofds", "three");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+"==="+next.getValue());
        }

    }


    public static void main(String[] args) throws Exception {
        testMap();
    }
}


class Student implements Cloneable {
    String name;
    int age;
    Integer prefor;

    public Student(String name, int age, int prefor) {
        this.name = name;
        this.age = age;
        this.prefor = prefor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPrefor() {
        return prefor;
    }

    public void setPrefor(int prefor) {
        this.prefor = prefor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(prefor, student.prefor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, prefor);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
