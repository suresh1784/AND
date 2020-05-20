package algorithm.BinarySearch;

public class BinarySearch {


    static int binarySearch(int[] arr, int start, int end , int key){
        int mid = (start+end)/2;
        if (start > end){
            return -1;
        }
        if (arr[mid]== key){
            return mid;
        }

        if (arr[mid] < key){
          return binarySearch(arr, mid+1, end, key);
        }else {
            return binarySearch(arr, start, mid-1, key);
        }
    }
    //5,6,7,1,2,3,4

    static int findMin(int[] arr, int start, int end){
        int mid = (start+end)/2;
        if (start>end){
            return start;
        }

        if (arr[mid]> arr[end]){
            return findMin(arr, mid+1, end);
        }else {
            return findMin(arr, start, mid-1);
        }
    }

   static int rotatedBinarySearch(int[] arr, int left, int right, int key){


        if (left> right){
            return -1;
        }

       int mid = left+(right-left)/2;
        if (arr[mid]== key){
            return mid;
        }


        if ( arr[left] <= arr[mid] &&  arr[mid] >= key && key >= arr[left]){
            return  rotatedBinarySearch(arr,left, mid-1, key);
        }
        else if( arr[right] >= arr[mid] &&  arr[mid] <= key && key <= arr[right]){
            return  rotatedBinarySearch(arr,mid+1, right, key);
        } else if (arr[left]>=arr[mid]){
            return  rotatedBinarySearch(arr,left, mid, key);
        }else if (arr[right] <= arr[mid] ){
            return  rotatedBinarySearch(arr,mid, right, key);
        }
      return -1;
   }

   //l     m      r
   //5,6,7,1,2,3,4
    public static void main(String[] args){
        int[] arr = {1,2,3,4,6,8,9};
        int[] rotatedArr = {7,8,9,1,2,3,4,5,6};
//        for (int i : arr){
//            System.out.println(binarySearch(arr, 0, arr.length-1, i));
//        }
//
        for (int i : rotatedArr){
            System.out.println(rotatedBinarySearch(rotatedArr, 0, rotatedArr.length-1, i));
        }

   //     System.out.println(rotatedArr[findMin(rotatedArr, 0 , rotatedArr.length-1)]);

    }



}
