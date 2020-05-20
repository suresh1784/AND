package patterns.CyclicSort;

class CyclicSort {

    public static void sort(int[] a) {
        // TODO: Write your code here

        int i = 0 ;
        while (i < a.length){
            if (a[i]!= i+1){
                int idx = a[i]-1;
                int temp = a[idx];
                a[idx]= a[i];
                a[i]= temp;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
