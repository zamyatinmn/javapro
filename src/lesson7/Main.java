package lesson7;

public class Main {
    public static void main(String[] args) {
        try {
            Tester.start(Class1.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
