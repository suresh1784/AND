package patterns.Multithread.FizzBuzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        MainThread mainThread = new MainThread();
        mainThread.run();
    }

    public void run() throws InterruptedException{
        MultithreadedFizzBuzz obj = new MultithreadedFizzBuzz(15);
        ExecutorService executorService = Executors.newFixedThreadPool(13);
        executorService.submit(()-> {
            try {
                obj.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        executorService.submit(()-> {
            try {
                obj.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()-> {
            try {
                obj.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(()-> {
            try {
                obj.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
