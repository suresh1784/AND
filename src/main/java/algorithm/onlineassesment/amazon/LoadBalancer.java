package algorithm.onlineassesment.amazon;

public class LoadBalancer {
   public boolean loadBalancer(int[] nums){
      int i = 0 ;
      int j = nums.length-1;
      int sumi = 0 ;
      int sumj = 0 ;
      int sum = 0 ;
      for (int num : nums){
         sum+= num;
      }

      int targetSum = sum/3;
      while (i<j){
         if (sumi > targetSum){
            break;
         }
         if (sumi==sumj){
            if (3*sumi == sum-nums[i]-nums[j] && j-i > 1){
               return true;
            }else {
               sumi+= nums[i];
               sumj+=nums[j];
               i++;
               j--;
            }
         }else {
            if (sumi > sumj){
               sumj+= nums[j];
               j--;
            }else if (sumj> sumi){
               sumi+= nums[i];
               i++;
            }
         }
      }
      return false;
   }


}
