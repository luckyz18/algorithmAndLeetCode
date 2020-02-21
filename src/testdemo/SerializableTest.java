package testdemo;

import java.io.Serializable;

//通过序列化实现深拷贝
public class SerializableTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setAge(1);
        System.out.println(user);
        //序列化
        //String jsonSerialize = JSON.toJSONString(user);
        //反序列化
        //User user3 = (User) JSON.parseObject(jsonSerialize, User.class);
        //System.out.println(user3);
    }

}
class User implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
