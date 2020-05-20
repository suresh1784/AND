package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CombinationalSumTest {
    CombinationalSum combinationalSum = new CombinationalSum();

    @Test
    void combinationSum2() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> actual = combinationalSum.combinationSum2(candidates, target);
        System.out.println(actual);
    }
}