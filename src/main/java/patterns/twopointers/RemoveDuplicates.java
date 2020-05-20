package patterns.twopointers;

class RemoveDuplicates {

    public static int remove(int[] arr) {

        int start = 0; ;
        int write = 0 ;

        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i]!= arr[write]){
                arr[++write]= arr[i] ;
            }
        }

        return write+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}