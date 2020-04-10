package AnimalShelter;

abstract class Animal {
    private int order;
    public String name;
    public Animal(String n) {
        name = n;
    }

    public void setOrder(int ord) {
        order = ord;
    }

    public int getOrder() {
        return order;
    }

    public boolean isOlderThan(Animal animal) {
        return this.order < animal.getOrder();
    }
}
