package basic.my_basic.class_3;

import java.util.LinkedList;
import java.util.Queue;

/*猫狗队列*/
public class Code_04_CatDogQueue {
	public static class Pet{
		private String type;

		public Pet(String type) {
			this.type = type;
		}
		public  String getPetType() {
			return this.type;
		}
	}
	public static class Dog extends Pet{
		public Dog() {
			super("dog");
		}
	}
	public static class Cat extends Pet{
		public Cat() {
			super("cat");
		}
	}
	
	public static class PetEnterQueue{
		private Pet pet;
		private Integer count;
		
		public PetEnterQueue(Pet pet, Integer count) {
			this.pet = pet;
			this.count = count;
		}
		public Pet getPet() {
			return pet;
		}
		
		public Integer getCount() {
			return count;
		}
	}
	
	public static class DogCatQueue{
		private Queue<PetEnterQueue> dogQ;
		private Queue<PetEnterQueue> catQ;
		private int count =0 ;
		
		
		public DogCatQueue() {
			super();
			this.dogQ = new LinkedList<PetEnterQueue>();
			this.catQ = new LinkedList<PetEnterQueue>();
			this.count = 0;
		}
		
		public void add(Pet pet) {
			if (pet.getPetType().equals("dog")) {
				this.dogQ.add(new PetEnterQueue(pet, this.count++));
			}else if (pet.getPetType().equals("cat")) {
				this.catQ.add(new PetEnterQueue(pet, count++));
			}else {
				throw new IllegalArgumentException("不是猫或狗");
			}
		}
		public Pet pollAll() {
			if (!dogQ.isEmpty() && !catQ.isEmpty()) {
				if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
					return dogQ.poll().getPet();
				}else {
					return catQ.poll().getPet();
				}
			}else if (!dogQ.isEmpty()) {
				return dogQ.poll().getPet();
			}else if (!catQ.isEmpty()) {
				return catQ.poll().getPet();
			}else {
				throw new RuntimeException("queue is empty!");
			}
		}
		public Pet pollDog() {
			if (!isDogEmpty()) {
				return dogQ.poll().getPet();
			}
			throw new RuntimeException("dogQ is empty!" );
		}
		public Pet pollCat() {
			if (!isCatEmpty()) {
				return catQ.poll().getPet();
			}
			throw new RuntimeException("dogQ is empty!" );
		}
		public boolean isEmpty() {
			return (dogQ.isEmpty() && catQ.isEmpty())? true : false;
		}
		public boolean isDogEmpty() {
			return dogQ.isEmpty();
		}
		public boolean isCatEmpty() {
			return catQ.isEmpty();
		}
		
	}
	
	/*for test*/
	public static void main(String[] args) {
		DogCatQueue test = new DogCatQueue();

		Pet dog1 = new Dog();
		Pet cat1 = new Cat();
		Pet dog2 = new Dog();
		Pet cat2 = new Cat();
		Pet dog3 = new Dog();
		Pet cat3 = new Cat();

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);

		test.add(dog1);
		test.add(cat1);
		test.add(dog2);
		test.add(cat2);
		test.add(dog3);
		test.add(cat3);
		while (!test.isDogEmpty()) {
			System.out.println(test.pollDog().getPetType());
		}
		while (!test.isEmpty()) {
			System.out.println(test.pollAll().getPetType());
		}
	}

}
