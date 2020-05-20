package algorithm.multithread;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class PC {

    LinkedList<Integer> l = new LinkedList<>();
    final static  int capacity = 2;

public void produce() throws InterruptedException{

    synchronized (this) {
        for (int i = 0; i == i; i++) {

            while (l.size() == capacity ){
                wait();
            }
            l.add(i * 10);
            System.out.println("Producer " + i*10);
            notify();
            Thread.sleep(1000);
        }
    }

}

public void consume() throws InterruptedException{
    synchronized (this) {
        for (int i = 0; i == i; i++) {

            while (l.size() ==0 ){
                wait();
            }


            int val = l.removeFirst();
            System.out.println("consumer" + val);
            notify();
            Thread.sleep(1000);
        }
    }

}

BlockingQueue bq = new LinkedBlockingQueue();

public void blockingProduce() throws InterruptedException{
    while (true){
        for (int i = 0; i<= 10; i++){
            System.out.println("Blocking Producer i "+ i );
            bq.put(i);
           // Thread.sleep(1000);
        }
    }
}

public void blockingConsume() throws InterruptedException{
    while(true) {
        System.out.println("Blocking Consumer  " + bq.take());
      //  Thread.sleep(1000);
    }
}

}
