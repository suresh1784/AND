package patterns.BinarySearch;

public class FindFirstLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[] {-1, -1};
        }
        int index = search (nums, 0 , nums.length-1, target);
        System.out.println(index);
        if (index == -1 ){
            return new int[] {-1, -1};
        }

//        if (nums.length==1){
//            return new int[] {index, index};
//        }

        int startIndex = searchStart(nums, 0 , index, target);
        System.out.println(startIndex);
        int endIndex  = searchEnd(nums, index , nums.length-1, target);
        System.out.println(endIndex);

        return new int[]{startIndex, endIndex};
    }

    public int search(int[] nums, int start , int end , int target ){
        if (start > end){
            return -1;
        }

        int mid = (start + (end-start)/2);

        if (nums[mid]== target){
            return mid;
        }

        if (target < nums[mid]){
            return search(nums, start, mid-1, target);
        }else {
            return search(nums, mid+1, end, target);
        }

    }

    public int searchStart(int[] nums, int start , int end , int target ) {
        if (start >=end){
            return  start;
        }

        int mid = (start + (end-start)/2);

        if (nums[mid]< target){
            return searchStart(nums, mid+1, end, target);
        }else {
            return searchStart(nums, start, mid, target);
        }

    }

    public int searchEnd(int[] nums, int start , int end , int target ) {
        if (start >=end){
            return  end;
        }

        int mid = (start + (end-start)/2);

        if (mid+1<=end && nums[mid]==target && nums[mid+1]>target){
            return mid;
        }

        if (nums[mid]> target){
            return searchEnd(nums, start, mid-1, target);
        }else {
            return searchEnd(nums, mid+1, end, target);
        }

    }



    public static void main(String[] args) {
        int[] nums = {2};
        int target = 2;
        FindFirstLastPositionSortedArray obj = new FindFirstLastPositionSortedArray();
        int[] result = obj.searchRange(nums, target);
        System.out.println("start "+result[0]);
        System.out.println("end "+result[1]);
    }
}
