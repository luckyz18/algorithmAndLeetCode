package basic.my_basic.class_1;

import java.util.PriorityQueue;

public class Comparator {

	public static class Student{
		private String name;
		private int id;
		private int age;
		
		public Student(String name, int id, int age) {
			super();
			this.name = name;
			this.id = id;
			this.age = age;
		}

	}
	
	//比较器
	public static class IdAscendingComparator implements java.util.Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.id - o2.id;
		}		
	}

	public static class IdDescendingComparator implements java.util.Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o2.id - o1.id;
		}
	}
	public static class AgeAscendingComparator implements java.util.Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}		
	}

	public static class AgeDescendingComparator implements java.util.Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o2.age - o1.age;
		}
	}
	

	public static void main(String[] args) {
		//优先级队列  == heap
		PriorityQueue<Student> heap = new PriorityQueue<>(new IdDescendingComparator()); 
		Student stu1 = new Student("lili", 1, 10);
		Student stu2 = new Student("tom", 2, 20);
		Student stu3 = new Student("jack", 3, 30);
		
		heap.add(stu3);
		heap.add(stu2);
		heap.add(stu1);
		
		while (!heap.isEmpty()) {
			Student student = heap.poll();
			System.out.println("Name: "+student.name+" "+"id "+student.id+" "+" age:"+student.age);
		}
		

	}

}
