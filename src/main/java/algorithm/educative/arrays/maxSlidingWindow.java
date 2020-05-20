package algorithm.educative.arrays;


import java.util.ArrayDeque;
import java.util.Iterator;

class maxSlidingWindow{
        public static void find_max_sliding_window1(int[] array, int window_size) {

            ArrayDeque result = new ArrayDeque();
            int max = 0;
            int count = 1;

            //traverse the array while shifting the window forward
            for(int i = 0; i < array.length; i++) {
                //find maximum in the current window
                if(array[i] > max) {
                    max = array[i];
                }
                if(count == window_size) {
                    result.add(max);
                    max = 0;
                   // System.out.println("i "+ i);
                  //  System.out.println("count "+ count);
                    i = i - count + 1;
                    count = 0;
            //        System.out.println("i >> "+ i);
                }
                count++;
            }
            System.out.println (result+", ");
        }


    public static ArrayDeque<Integer> find_max_sliding_window(
            int[] a,
            int window_size) {
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        ArrayDeque<Integer> window = new ArrayDeque<Integer>();
        int count = 2;
        window.add(0);
        for (int i=1;i<=a.length-1;i++){
       //     System.out.println("i "+i);
            if ((i-window_size)== window.getFirst()){
                window.remove();
            }
            Iterator itr = window.iterator();
            while(itr.hasNext())  {
                int curr = (int)itr.next();
               if (a[curr] <= a[i]){
                   itr.remove();
               }
            }
        //    System.out.println("window "+ window);
            window.add(i);

            if (count == window_size){
                result.add(a[window.getFirst()]);
       //         System.out.println("temp resu " +result);
                count =count-1;
            }
            count++;
        }
      //  System.out.println("result "+result);
        return result;
    }
        public static void main(String[] args) {
            int[] array = { 1, 2, 3, 4, 3, 2, 1, 2, 5 };
            System.out.println("Window Size 4");
            find_max_sliding_window1(array, 4);
            System.out.println("result >> "+ find_max_sliding_window(array, 4));

            System.out.println("\nWindow Size 3");
            find_max_sliding_window1(array, 3);
            System.out.println("result >> "+ find_max_sliding_window(array, 3));

            System.out.println("\nWindow Size 5");
            find_max_sliding_window1(array, 5);
            System.out.println("result >> "+ find_max_sliding_window(array, 5));
        }
    }


