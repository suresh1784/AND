package patterns.twopointers;

class ShortestWindowSort {

    public static int sort(int[] arr) {
        // TODO: Write your code here

       int loStart = 0 ;
       int loEnd = arr.length-1;

       while (loStart < loEnd){
           if (arr[loStart]<arr[loStart+1] && arr[loStart]< arr[loEnd]){
               loStart++;
               loEnd--;
           }else if (arr[loStart]> arr[loEnd]){
               if (loStart==0){
                   break;
               }
               loStart--;
           }else {
               loEnd--;
           }
       }


       int hiStart = 0 ;
       int hiEnd = arr.length-1;

       while (hiStart < hiEnd){
        if (arr[hiEnd] > arr[hiEnd-1] && arr[hiStart]< arr[hiEnd]){
            hiEnd--;
            hiStart++;
        }else if (arr[hiStart] < arr[hiEnd]){
            if(hiEnd==arr.length-1){
                break;
            }
            hiEnd++;
        }else {
            hiStart++;
        }
       }
        System.out.println("hiEnd "+hiEnd);
        System.out.println("loStart "+loStart);

       return hiEnd - loStart;

    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
       System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}