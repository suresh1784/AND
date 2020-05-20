package patterns.twopointers;

class WaterContainer {

    public static int findMaxWater(int[] bh) {
        // TODO: Write your code here

        int left = 0 ;
        int right = bh.length-1;

        int maxArea = 0 ;
        int area = 0 ;



        while (left < right){
            int height = Math.min(bh[left], bh[right]);
            int width = right -left;
            area = height* width;
            maxArea = Math.max(maxArea, area);
            if (bh[left]< bh[right]){
                left++;
            }else {
                right --;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(WaterContainer.findMaxWater(new int[] { 1, 3, 5, 4, 1 }));
        System.out.println(WaterContainer.findMaxWater(new int[] { 3, 2, 5, 4, 2 }));
        System.out.println(WaterContainer.findMaxWater(new int[] { 1, 4, 3, 2, 5, 8, 4 }));
    }
}