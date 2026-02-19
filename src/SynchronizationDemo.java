class Table {
    // TODO: synchronized method void printTable(int n)
    // Loop from 1 to 5 (as per sample) or 10
    // Print n * i + " "
    // Handle InterruptedException (try-catch Thread.sleep(400))

	public synchronized void printTable(int n){

		for(int i=1;i<=5;i++){

			System.out.print(n*i);

			if(i<5){

				System.out.print(" ");

			}
			try{

				Thread.sleep(400);

			}catch(InterruptedException e){

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
        // TODO: Call t.printTable(5)
	t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) {
        this.t = t;
    }
    public void run() {
        // TODO: Call t.printTable(100)
	t.printTable(100);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        // TODO: Create Table object
        // TODO: Create MyThread1 and MyThread2 objects passing the table object
        // TODO: Start both threads
	Table tbl = new Table();
	MyThread1 t1 = new MyThread1(tbl);
	MyThread2 t2 = new MyThread2(tbl);
	t1.start();
	t2.start();
    }
}
