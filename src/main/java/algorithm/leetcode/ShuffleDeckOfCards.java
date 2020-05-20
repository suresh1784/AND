package algorithm.leetcode;

public class ShuffleDeckOfCards {
    int[] nums ;
    public ShuffleDeckOfCards(int[] nums){
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }


    public int[] shuffle(){
        int[] rand = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++){
            int r = (int)(Math.random()*i+1);
            rand[r]= rand[i];
            rand[i]= nums[r];
        }
        return rand;
    }
}
