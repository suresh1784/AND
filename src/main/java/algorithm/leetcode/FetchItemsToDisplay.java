package algorithm.leetcode;
import java.util.*;
public class FetchItemsToDisplay {
    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // Write your code here
        List<String> result = new ArrayList<>();

            Collections.sort(items, (a,b)-> {
                String aStr = a.get(0);
                String bStr = b.get(0);
                String ar = a.get(1);
                String br = b.get(1);
                String ap = a.get(2);
                String bp = b.get(2);
                int aVal = 0 ;
                int bVal = 0 ;

                if (sortParameter==0){
                    if (sortOrder == 0){
                        return aStr.compareTo(bStr);
                    }else {
                        return bStr.compareTo(aStr);
                    }
                }else if (sortParameter ==1){
                    aVal = Integer.parseInt(ar);
                    bVal = Integer.parseInt(br);
                }else {
                    aVal = Integer.parseInt(ap);
                    bVal = Integer.parseInt(bp);
                }

                if (sortOrder == 0){
                  return  Integer.compare(aVal, bVal);
                }else {
                  return  Integer.compare(bVal, aVal);
                }

            });

      //  System.out.println(items);

        int startIndex = pageNumber*itemsPerPage;
        int count = 0 ;

        while (startIndex < items.size() && count < itemsPerPage){
            result.add(items.get(startIndex).get(0));
            startIndex++;
            count++;
        }

        return result;
    }

    public static void main(String[] args) {
//        List<List<String>> in = new ArrayList<>();
//        List<String> item1 = Arrays.asList("item2", "3", "4");
//        List<String> item2 = Arrays.asList("item1", "10", "15");
//        List<String> item3 = Arrays.asList("item3", "17", "8");
//        in = Arrays.asList(item1, item2, item3);

        List<List<String>> in = new ArrayList<>();
        List<String> item1 = Arrays.asList("p1", "1", "2");
        List<String> item2 = Arrays.asList("p2", "2", "1");
        in = Arrays.asList(item1, item2);

        System.out.println(fetchItemsToDisplay(in , 0,0,1,0));
    }
}
