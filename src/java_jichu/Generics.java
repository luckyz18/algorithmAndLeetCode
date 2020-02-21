package java_jichu;

public class Generics<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void test(){
        Generics<Object> eee = new Generics<>();
        eee.setValue(1);

    }

}
