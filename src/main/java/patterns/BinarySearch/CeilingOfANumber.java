package patterns.BinarySearch;
//https://www.geeksforgeeks.org/floor-in-a-sorted-array/
//https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
public class CeilingOfANumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        // TODO: Write your code here

        return arr[celling1(arr, key, 0, arr.length-1)];
    }

    static int celling(int[] arr, int key, int lo, int hi){

        if (lo > hi){
            if (lo >= arr.length){
                return -1;
            }

            return lo;

        }
        int mid = lo + ((hi-lo)/2);



        if (arr[mid] == key){
            return mid;
        }

        if (key < arr[mid]){
            return celling(arr, key, lo, mid-1);
        } else {
            return celling(arr, key, mid+1, hi);
        }
    }

    static Integer floor(int[] arr, int key, int lo, int hi){

        if (lo >hi){
            if (hi < 0){
                return -1;
            }

            return lo;

        }
        int mid = lo + ((hi-lo)/2);



        if (arr[mid] == key){
            return mid;
        }

        // If x lies between mid-1 and mid
        if (mid > 0 && arr[mid-1] <= key && key <
                arr[mid])
            return mid-1;

        if (key > arr[mid]){

            return floor(arr, key, mid+1, hi);
        } else {
            return floor(arr, key, lo, mid-1);
        }
    }

    static Integer floor1(int[] arr, int key, int lo, int hi){

        if (lo >=hi){
            return null;
        }
        int mid = lo + ((hi-lo)/2);
        if (arr[mid] == key){
            return mid;
        }

        if (lo+1==hi){
            if (key >= arr[hi]){
                return hi;
            }
            return lo;
        }

        // If x lies between mid-1 and mid
       if (arr[mid] >= key){
           return floor1(arr, key, lo, mid);
       }

       Integer temp = floor1(arr, key, mid, hi);
       if (temp !=null){
           return temp;
       }
       return mid;
    }

    static Integer celling1(int[] arr, int key, int lo, int hi){

        if (lo >hi){
            return null;
        }
        int mid = lo + ((hi-lo)/2);
        if (arr[mid] == key){
            return mid;
        }

        if (lo+1==hi){
            if (key <= arr[lo]){
                return lo;
            }
            return hi;
        }

        // If x lies between mid-1 and mid
        if (arr[mid] < key){
            return celling1(arr, key, mid, hi);
        }

        Integer temp = celling1(arr, key, lo, mid);
        if (temp !=null){
            return temp;
        }
        return mid;
    }

    public static void main(String[] args) {
//        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6)); //6
//        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12)); //15
//        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17)); //-1
//        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 2)); //
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1,2,4,5,7,9}, -1));
    }
}
