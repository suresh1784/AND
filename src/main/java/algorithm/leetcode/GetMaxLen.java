package algorithm.leetcode;

public class GetMaxLen {
    private class Property{
        long product;
        int length;
        int index;

        public Property(){
            this.product = 1;
            this.length = 0;
            this.index = 0;
        }

        public Property(long product, int length, int index){
            this.product = product;
            this.length = length;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Property{" +
                    "product=" + product +
                    ", length=" + length +
                    ", index=" + index +
                    '}';
        }
    }
    public int getMaxLen(int[] nums) {
        int length = 0 ;
        int maxLength = 0 ;
        int maxNegLength = 0 ;
        int startIndex = 0 ;
        long product = 1;
        int maxStartIndex = 0 ;
        Property maxPos = new Property();
        Property maxNeg = new Property();

        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i]==0){
                startIndex = i+1;
                continue;
            }
            product *= nums[i];
            int currLength = i-startIndex+1;
            if (product>0 && currLength > maxLength){
                maxLength = currLength;
                maxPos = new Property(product, currLength, i);
                maxStartIndex = startIndex;
                if (startIndex > 0){

                }
            }

            if (product < 0 && currLength >= maxNegLength) {
                maxNegLength = currLength;
                maxNeg = new Property(product, currLength, i);
            }
        }

        System.out.println("maxPos : "+maxPos.toString());
        System.out.println("maxNeg : "+maxNeg.toString());

        for (int i = maxStartIndex ; i < nums.length ; i++){
            if (nums[i]<0){
                int currLength = maxNeg.index - i;
                if (currLength > maxLength){
                    maxLength = currLength;
                }
                break;
            }
        }


        return maxLength;
    }
}
