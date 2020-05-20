package algorithm.educative.arrays;

import java.util.ArrayList;
import java.util.List;

class findLowHigh{


    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1); //0
        arr.add(1); //1
        arr.add(2);//2
        arr.add(2);//3
        arr.add(3);//4
        arr.add(3);//5
        arr.add(3);//6
        arr.add(5);//7
        arr.add(5);//8
        arr.add(5);//9
        arr.add(5);//10
        arr.add(5);//11
        arr.add(5);//12
        arr.add(5);//13
        arr.add(5);//14
        arr.add(5);//15
        arr.add(8);//16
        arr.add(8);//17
        arr.add(9);//18
        arr.add(10);//19
        arr.add(10);//20

        System.out.println("Low Index of  5  is "+find_low_index(arr,5));
        System.out.println("High Index of  5  is "+find_high_index(arr,5));
  // Testing
//        for (int i : arr){
//            System.out.println("Low Index of  "+i +" is " +find_low_index(arr,i));
//        }
//        for (int i : arr){
//            System.out.println("Low Index of  "+(i+1) +" is " +find_low_index(arr,i+1));
//        }
////
        for (int i : arr){
            System.out.println("High Index of  "+i +" is " +find_high_index(arr,i));
        }
//        for (int i : arr){
//            System.out.println("High Index of  "+i+1 +" is " +find_high_index(arr,i+1));
//        }


    }

    static int find_low_index(
            List<Integer> arr,
            int key) {
        if (arr.get(0) == key){
            return 0;
        }

        return lowRecc(arr, key, 0, arr.size()-1);
    }

    static int find_high_index(
            List<Integer> arr,
            int key) {
        int size = arr.size()-1;
        if (arr.get(size) == key){
            return size;
        }

        return highRecc(arr, key, 0, arr.size()-1);
    }

    static int highRecc(List<Integer> arr, int key, int start , int end){
        if (start > end){
            return -1;
        }

        if (arr.get(start) <= key && key <= arr.get(end)){
            int middle = (start+end)/2;
            if (arr.get(middle) == key){
                if (middle+1 < arr.size()-1  && arr.get(middle+1)>key){
                    return middle;
                }
                return highRecc(arr, key, middle+1, end);
            }

            if (arr.get(middle) < key){
                return   highRecc(arr, key, middle+1, end);
            }else if (arr.get(middle) > key){
                return  highRecc(arr, key, start, middle-1);
            }

        }
        return -1;
    }

    static int lowRecc(List<Integer> arr, int key, int start , int end){
        if (start > end){
            return -1;
        }

        if (arr.get(start) <= key && key <= arr.get(end)){
            int middle = (start+end)/2;
            if (arr.get(middle) == key){
                if (middle-1 >=0  && arr.get(middle-1)<key){
                    return middle;
                }
               return lowRecc(arr, key, start, middle-1);
            }

            if (arr.get(middle) < key){
              return   lowRecc(arr, key, middle+1, end);
            }else if (arr.get(middle) > key){
               return  lowRecc(arr, key, start, middle-1);
            }

        }
        return -1;
    }
}