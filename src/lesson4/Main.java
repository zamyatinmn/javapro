package lesson4;

public class Main {
    private static int queueNum = 1;
    private static final int CYCLE_NUM = 5;
    private static final Object mon = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < CYCLE_NUM; i++) {
                synchronized (mon){
                    while (queueNum != 1){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    queueNum = 2;
                    mon.notifyAll();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < CYCLE_NUM; i++) {
                synchronized (mon) {
                    while (queueNum != 2) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    queueNum = 3;
                    mon.notifyAll();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < CYCLE_NUM; i++) {
                synchronized (mon) {
                    while (queueNum != 3) {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    queueNum = 1;
                    mon.notifyAll();
                }
            }
        }).start();
    }
}
