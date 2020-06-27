package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        String[] arr = {"казнить", "нельзя", "помиловать"};
        exchangeElementsInArr(arr, 0, 2);

        Object[] arr2 = {new Character('A'), new Character('B'), new Character('C')};
        exchangeElementsInArr(arr2, 0, 2);

        //Задание 2
        arrToArrList(arr);

        //Задание 3
        Box<Orange> box = new Box<>();
        box.addFruit(new Orange());
        box.addFruit(new Orange());
        System.out.println(box.getWeight());

        Box<Orange> box2 = new Box<>();
        box2.addFruit(new Orange());
        box2.addFruit(new Orange());

        System.out.println(box.compare(box2));

        box.shiftFruits(box2);

        System.out.println(box.compare(box2));
    }

    public static <T> void exchangeElementsInArr(T[] arr, int pos1, int pos2) {
        T temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static <T> ArrayList<T> arrToArrList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
