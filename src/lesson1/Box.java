package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> storage = new ArrayList<>();

    public void addFruit(T fruit) {
        storage.add(fruit);
    }

    public float getWeight() {
        if (storage.size() == 0){
            return 0;
        }else{
            return storage.size() * this.storage.get(0).getWeight();
        }
    }

    public void shiftFruits(Box<T> destination) {
        for (T t : storage) {
            destination.addFruit(t);
        }
        storage.clear();
    }

    public boolean compare(Box another) {
        return  Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }
}
