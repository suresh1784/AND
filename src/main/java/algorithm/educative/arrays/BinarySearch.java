package algorithm.educative.arrays;

public class BinarySearch {

    public static void main(String[] args){
        int[] arr = {1,10,20,47,59,63,75,88,99,107,120,133,155,162,176,188,199,200,210,222};
        for (int i : arr){
            System.out.println("Index " + binSearch(arr,i));
        }

    }

    static int binSearch(int[] a, int key) {
        //TODO: Write - Your - Code
        return binRec(a,key, 0, a.length);
    }

    static int binRec(int[] a, int key, int start, int end){
        if (start>=end){
            return -1;
        }

        int middle = (start+end )/2;
        if (a[middle]==key){
            return middle;
        } else if (key < a[middle]){
            return binRec(a,key,start,middle);
        }else{
            return binRec(a,key,middle+1,end);
        }
    }
}
