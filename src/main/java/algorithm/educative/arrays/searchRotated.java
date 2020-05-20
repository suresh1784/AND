package algorithm.educative.arrays;

public class searchRotated {
    public static void main(String[] args) {
        int[] arr = {176,
                188,
                199,
                200,
                210,
                222,
                1,
                10,
                20,
                47,
                59,
                63,
                75,
                88,
                89,
                107,
                120,
                133,
                155,
                162
        };

        for (int i : arr) {
            System.out.println("Index of array "+ i +"  is "+ binary_search_rotated(arr, i+1));
        }

    }

    static int binary_search_rotated(int[] arr, int key) {
        //TODO: Write - Your - Code
        return rotatedBinRec(arr, key, 0, arr.length-1);
    }

    static int rotatedBinRec(int[] a, int key, int start, int end){
        if (end<=start){
            return -1;
        }

        if (a[start]==key){
            return start;
        }

        if (a[end]==key){
            return end;
        }

        if (a[start] < key  && key < a[end]){
            return binRec(a,key,start,end);
        }

        if (a[start]<key || key <a[end]){
            if (a[start] < key && key > a[end]){
                int middle = (start+end)/2;
                if (a[middle]== key){
                    return middle;
                }
                if (a[middle]>a[end]){
                    if (key< a[middle]){
                        return rotatedBinRec(a,key,start,middle-1);
                    }
                    return rotatedBinRec(a,key,middle+1,end);
                }else{
                    return rotatedBinRec(a,key,start,middle-1);
                }



            }else {
                int mid = (start + end) / 2;
                if (a[mid] == key) {
                    return mid;
                }
                if (a[mid] < a[end]) {
                    if (key > a[mid]) {
                        return rotatedBinRec(a, key, mid+1, end);
                    }
                    return rotatedBinRec(a, key, start, mid - 1);
                }else{
                    return rotatedBinRec(a,key,mid+1,end);
                }
            }

        }
return -1;
    }

    static int binRec(int[] a, int key, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (a[middle] == key) {
            return middle;
        } else if (key < a[middle]) {
            return binRec(a, key, start, middle);
        } else {
            return binRec(a, key, middle + 1, end);

        }
    }
}