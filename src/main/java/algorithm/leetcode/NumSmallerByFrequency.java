package algorithm.leetcode;

import java.util.Arrays;

public class NumSmallerByFrequency {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
       int[] queriesArray =  getFrequency(queries);
       int[] answer = new int[queries.length];
       int[] wordsArray = getFrequency(words);
       Arrays.sort(wordsArray);

       for (int i = 0 ; i < queries.length ; i++){
         int value = wordsArray.length - getGreaterIndex(wordsArray, queriesArray[i]+1)  ;
         answer[i] = value;
       }
      return answer;

    }

    static int getGreaterIndex(int[] array, int key){
        int index = 0 ;
        for (int i = 0 ; i < array.length ; i++ ){
            if (array[i]>=key ){
                index = i ;
                break;
            }

        }
        return index;
    }

    static int getGreaterIndex1(int[] array, int key){
        return search(array, key, 0, array.length-1);
    }



    static int search(int[] arr, int key , int start , int end){

        if (start >= end){
            return start;
        }

        int mid = start + ((end-start)/2);
        if (arr[mid] == key){
            return mid;
        }
        if (arr[mid] < key){
            return search (arr, key, mid+1, end);
        }else {
            return search (arr, key, start, mid-1);
        }
    }

    static int[] getFrequency(String[] strings){
        int[] result = new int[strings.length];
        for (int i = 0 ; i < strings.length ; i++) {
            result[i] = getFrequency(strings[i]);
        }
        return result;
    }

    static int getFrequency(String str) {

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        char[] input = str.toCharArray();
        int max = 0 ;
        int count = 0 ;
        for (char ch : input){
            if (ch == chars[0]){
                count++;
            }else {
                max = Math.max(count, max);
                count = 0 ;
            }
        }
        max = Math.max(count, max);
        return max;
    }


    public static void main(String[] args){
    String[] queries = {"cbd"};
    String[] words = {"zaaaz"};

    String[] queries1 = {"bbb","cc"};
    String[]   words1 = {"a","aa","aaa","baabaaaa"};


        String[] queries2 =   {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
      String[] words2 = {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};

    int[] results = numSmallerByFrequency(queries2, words2);

    int[] input = {1, 1, 2,2, 3, 3, 3,  3,5, 5, 6};

        System.out.println("getGreaterIndex "+ getGreaterIndex(input, 5));

    for (Integer result : results){
        System.out.println("result --> "+result);
    }

    }
}
