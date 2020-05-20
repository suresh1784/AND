package patterns.BinarySearch;

public class BinarySearchPattern {

    public static void main(String[] atgs){

        // Binary Search three template
        int[] arr = {1,3,5,7,9,11};
        int[] arr1 = {0,2,4,6,8,10,12};

        for (int i : arr){
            System.out.println("One "+binarySearchOne(arr, i));
            System.out.println("R One "+recursiveOne(arr, i));
            System.out.println("Two "+binarySearchTwo(arr, i));
            System.out.println("R Two "+recursiveTwo(arr, i));
            System.out.println("Three "+binarySearchThree(arr, i));
            System.out.println("R Three "+recursiveThree(arr, i));
        }

        for (int i : arr1){
            System.out.println("One "+binarySearchOne(arr1, i));
            System.out.println("R One "+recursiveOne(arr1, i));
            System.out.println("Two "+binarySearchTwo(arr1, i));
            System.out.println("R Two "+recursiveTwo(arr1, i));
            System.out.println("Three "+binarySearchThree(arr1, i));
            System.out.println("R Three "+recursiveThree(arr1, i));
        }
    }


    // Template I // iterative

    public static int binarySearchOne(int[] arr, int target){
        int left = 0 ;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left +right)/2;
            if (arr[mid]== target){
                return mid;
            }

            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    // Template I // recursive

    public static int recursiveOne(int[] arr, int target){
        return recursiveOne(arr, target, 0 , arr.length-1);
    }


    public static int recursiveOne(int[] arr, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left+right)/2;
        if (arr[mid]== target){
            return mid;
        }

        if (target < arr[mid]){
            return recursiveOne(arr, target, left, mid-1);
        }else {
            return recursiveOne(arr, target, mid+1, right);
        }
    }
    // Template II // iterative

    public static int binarySearchTwo(int[] arr, int target){
        int left = 0 ;
        int right = arr.length-1;

        while(left < right){
            int mid = (left +right)/2;
            if (arr[mid]== target){
                return mid;
            }

            if (target < arr[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        if (left != arr.length && arr[left]== target){
            return left;
        }
        return -1;
    }


    // Template II // recursive

    public static int recursiveTwo(int[] arr, int target){
        return recursiveTwo(arr, target, 0 , arr.length-1);
    }


    public static int recursiveTwo(int[] arr, int target, int left, int right){
        if (left == right){
            if (left!= arr.length && arr[left]== target){
                return left;
            }
            return -1;
        }
        int mid = (left+right)/2;
        if (arr[mid]== target){
            return mid;
        }

        if (target < arr[mid]){
            return recursiveTwo(arr, target, left, mid);
        }else {
            return recursiveTwo(arr, target, mid+1, right);
        }
    }

    // Template III // iterative

    public static int binarySearchThree(int[] arr, int target){
        int left = 0 ;
        int right = arr.length-1;

        while(left+1 < right){
            int mid = (left +right)/2;
            if (arr[mid]== target){
                return mid;
            }

            if (target < arr[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (left != arr.length && arr[left]== target){
            return left;
        }

        if (right >=0 && arr[right]== target){
            return right;
        }
        return -1;
    }

    // Template III // recursive

    public static int recursiveThree(int[] arr, int target){
        return recursiveThree(arr, target, 0 , arr.length-1);
    }


    public static int recursiveThree(int[] arr, int target, int left, int right){
        if (left+1 == right){
            if (left!= arr.length && arr[left]== target){
                return left;
            }
            if (right >=0 && arr[right]== target){
                return right;
            }

            return -1;
        }
        int mid = (left+right)/2;
        if (arr[mid]== target){
            return mid;
        }

        if (target < arr[mid]){
            return recursiveThree(arr, target, left, mid);
        }else {
            return recursiveThree(arr, target, mid, right);
        }
    }

}
