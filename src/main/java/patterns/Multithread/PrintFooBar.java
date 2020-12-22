package patterns.Multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintFooBar {
    int n;

    public PrintFooBar(int n) {
        this.n = n;
    }
    boolean isFoo = true;
    public synchronized void PrintFoo() throws InterruptedException {
//        while (!isFoo){
//            wait();
//        }
        for (int i = 1; i <= n; i++) {
            System.out.print("Foo");
        }
        isFoo = false;
        notifyAll();
    }

    public synchronized void PrintBar() throws InterruptedException{
//        while(isFoo){
//            wait();
//        }
        for (int i = 1; i <= n; i++) {
            System.out.print("Bar");
        }
        isFoo = true;
        notifyAll();
    }

    public static void main(String[] args) {
        PrintFooBar printFooBar = new PrintFooBar(500);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()-> {
            try{
                printFooBar.PrintFoo();
            }catch (InterruptedException ex){

            }
        });

        executorService.submit(()-> {
            try{
                printFooBar.PrintBar();
            }catch (InterruptedException ex){

            }
        });
    }
}

