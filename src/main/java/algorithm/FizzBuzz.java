package algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzz {
    private final int n;
    public FizzBuzz(int n){
        this.n = n;
    }
    public synchronized void printFizzBuz(int start, int end){
        for (int i = start ; i < end ; i++){
            if (i%3 == 0  || i %5 == 0 ){
                if (i%3==0 && i%5==0 ){
                    System.out.println("FizzBuzz");
                }else if (i%3==0){
                    System.out.println("Fizz");
                }else {
                    System.out.println("Buzz");
                }
            }else {
                System.out.println(" i -->  "+i);
            }
        }
    }

    int num = 1;
    public synchronized  void printBuzz() throws InterruptedException {
        while (num < n ){
            if (num%5==0 && num%3!=0){
                System.out.println("Buzz");
                num++;
                notifyAll();
            }else {
                wait();
            }
        }
    }


    public synchronized  void printFizz() throws InterruptedException {
        while (num < n ){
            if (num%3==0 && num%5!=0){
                System.out.println("Fizz");
                num++;
                notifyAll();
            }else {
                wait();
            }
        }
    }

    public synchronized  void printFizzBuzz() throws InterruptedException {
        while (num < n ){
            if (num%3==0 && num%5==0){
                System.out.println("FizzBuzz");
                num++;
                notifyAll();
            }else {
                wait();
            }
        }
    }

    public synchronized  void printNumber() throws InterruptedException {
        while (num < n ){
            if (num%3!=0 && num%5!=0){
                System.out.println("Num -> "+num);
                num++;
                notifyAll();
            }else {
                wait();
            }
        }
    }



    public static void main(String args[]) {
        FizzBuzz fizzBuzz = new FizzBuzz(30);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.submit(()-> fizzBuzz.printFizzBuz(0,16));
//        executorService.submit(()-> fizzBuzz.printFizzBuz(16,30));
//        executorService.shutdown();
//        Thread1 thread1 = new Thread1();
//        thread1.run();
//        Thread2 thread2 = new Thread2();
//        thread2.run();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()-> {
            try {
                fizzBuzz.printFizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()-> {
            try {
                fizzBuzz.printBuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()-> {
            try {
                fizzBuzz.printFizzBuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()-> {
            try {
                fizzBuzz.printNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}


 class Thread1 implements Runnable {

    Thread t;
    Thread1() {

        // thread created
        t = new Thread(this, "Admin Thread");

        // prints thread created
        t.start();
    }

    public void run() {
       FizzBuzz fizzBuzz = new FizzBuzz(66);
       fizzBuzz.printFizzBuz(0,32);
    }


}

class Thread2 implements Runnable {

    Thread t;
    Thread2() {

        // thread created
        t = new Thread(this, "Admin Thread");

        // prints thread created
        t.start();
    }

    public void run() {
        FizzBuzz fizzBuzz = new FizzBuzz(66);
        fizzBuzz.printFizzBuz(33,64);
    }


}
