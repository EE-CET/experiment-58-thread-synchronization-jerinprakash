class Table {
    // synchronized method
    public synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }
}

class MyThread1 extends Thread {
    Table t;

    MyThread1(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {

        // Create shared Table object
        Table tbl = new Table();

        // Create threads
        MyThread1 t1 = new MyThread1(tbl);
        MyThread2 t2 = new MyThread2(tbl);

        // Start threads
        t1.start();
        t2.start();
    }
}
