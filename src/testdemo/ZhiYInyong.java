package testdemo;

public class ZhiYInyong {
    static class Student{
        int score;

        public Student(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(0);
        Student b = new Student(100);
        System.out.println(a.getScore() +"   "+ b.getScore());
        swap(a,b);
        System.out.println(a.getScore() +"   "+ b.getScore());

    }

    private static void swap(Student x, Student y) {
        Student tmp = x;
        x = y;
        y = tmp;
    }
}
