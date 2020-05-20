package algorithm.leetcode;

public class CanPlaceFlowers {

    public static void main(String[] args){
        int[] input = {0,1,0,0,1,0,0,0,1};
        System.out.println(canPlaceFlowers(input, 2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length<3){
            return false;
        }
        return canPlaceFlowers(flowerbed, n,0);
    }

    static boolean canPlaceFlowers(int[] flowers, int n, int level){
        if (n==0){
            return true;
        }

        if (level==0 || level== flowers.length-1){
            if (level == flowers.length-1){
                if (flowers[level]==0 && flowers[level-1]== 0 && n==1){
                    return true;
                } else {
                    return false;
                }
            } else if (level==0){
                if (flowers[level+1]==0 && flowers[level]==0){
                    return canPlaceFlowers(flowers, n-1, level+2);
                }else {
                    return canPlaceFlowers(flowers, n, level+1);
                }
            } else {
                return false;
            }
        } else {
            if (flowers[level-1]==0 && flowers[level+1]==0 && flowers[level]==0){
                //flowers[level]= 1;
                return canPlaceFlowers(flowers, n-1, level+2);
            }else {
                return canPlaceFlowers(flowers, n, level+1);
            }
        }
    }
}
