package algorithm.onlineassesment.amazon;

import java.util.Arrays;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->{

            String[] aArray = a.split(" ", 2);
            String[] bArray = b.split(" ", 2);
            String aVal = aArray[1];
            String bVal = bArray[1];
            Character aCh = aVal.charAt(0);
            Character bCh = bVal.charAt(0);
            boolean isaAlphabhet = Character.isAlphabetic(aCh);
            boolean isbAlphabhet = Character.isAlphabetic(bCh);

            if (isaAlphabhet && isbAlphabhet){
                int cmp = aVal.compareTo(bVal);
                if (cmp!=0){
                    return cmp;
                }

                return aArray[0].compareTo(bArray[0]);
            } else {
                if (isaAlphabhet){
                    return -1;
                }else if (isbAlphabhet){
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        return logs;
    }
}
