package AnimalShelter;

import java.util.LinkedList;

public class Animals {
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal instanceof Dog) dogs.addLast((Dog) animal);
        else if (animal instanceof Cat) cats.addLast((Cat) animal);
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCat();
        } else if (cats.size() == 0) {
            return dequeueDog();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public static void main(String[] args) {
        Animals shelter = new Animals();
        shelter.enqueue(new Cat("Katya"));
        shelter.enqueue(new Cat("Bobo"));
        shelter.enqueue(new Dog("Boris"));
        shelter.enqueue(new Dog("Vasek"));
        shelter.enqueue(new Cat("Dodo"));
        shelter.enqueue(new Dog("Rara"));
        shelter.enqueue(new Dog("Koka"));

        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
    }
}
