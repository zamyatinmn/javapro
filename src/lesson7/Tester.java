package lesson7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tester {

    public static void start(Class clazz) throws Exception {
        work();
    }

    public static void start(String clazz) throws Exception {
        work();
    }

    private static void work() throws Exception {
        Class cl = Class1.class;
        ArrayList<Method> methods = new ArrayList<>(Arrays.asList(cl.getDeclaredMethods()));
        Method before = null;
        Method after = null;
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (before != null) {
                    throw new RuntimeException("BeforeSuite > 1");
                } else {
                    before = m;
                }
            }

            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (after != null) {
                    throw new RuntimeException("AfterSuite > 1");
                } else {
                    after = m;
                }
            }
        }
        methods.remove(before);
        methods.remove(after);


        methods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
            }
        });

        if (before != null) before.invoke(null);
        for (Method m : methods) {
            m.invoke(null);
        }
        if (after != null) after.invoke(null);
    }
}
