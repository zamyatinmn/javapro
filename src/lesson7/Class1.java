package lesson7;

public class Class1 {

    @Test(priority = 3)
    public static void abc(){
        System.out.println("abc");
    }
    @Test(priority = 8)
    public static void abc3(){
        System.out.println("abc3");
    }
    @Test
    public static void abc2(){
        System.out.println("abc2");
    }
    @BeforeSuite
    public static void abcb(){
        System.out.println("before");
    }
    @AfterSuite
    public static void abcb2(){
        System.out.println("after");
    }
}
