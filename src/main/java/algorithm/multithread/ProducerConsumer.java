package algorithm.multithread;
//https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/


public class ProducerConsumer extends Thread{

    public static void main(String[] args) throws InterruptedException{

        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
              //      pc.produce();
                    pc.blockingProduce();
                }catch (InterruptedException e){

                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
               //     pc.consume();
                    pc.blockingConsume();
                }catch (InterruptedException e){

                }
            }
        });


        t1.start();
        t2.start();
      //  t1.join();
     //   t2.join();



    }
}


