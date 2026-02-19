class Table {

    public synchronized void printTable(int n){

        for(int i = 1; i <= 5; i++){

            System.out.print(n * i+" ");

         //   if(i < 5){
         //       System.out.print(" ");
          //  }
        }

        System.out.println();
    }
}

class MyThread1 extends Thread {

    Table t;

    MyThread1(Table t){
        this.t = t;
    }

    public void run(){
        t.printTable(5);
    }
}

class MyThread2 extends Thread {

    Table t;

    MyThread2(Table t){
        this.t = t;
    }

    public void run(){
        t.printTable(100);
    }
}

public class SynchronizationDemo {

    public static void main(String[] args) throws InterruptedException {

        Table tbl = new Table();

        MyThread1 t1 = new MyThread1(tbl);
        MyThread2 t2 = new MyThread2(tbl);

        t1.start();
        t1.join();   // wait until t1 finishes

        t2.start();
        t2.join();   // wait until t2 finishes
    }
}
