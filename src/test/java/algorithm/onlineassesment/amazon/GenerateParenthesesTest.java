package algorithm.onlineassesment.amazon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
class GenerateParenthesesTest {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    @Test
    void test(){
        int n = 3;
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> actual = generateParentheses.generateParenthesis(n);
        assertThat(actual,containsInAnyOrder(expected.toArray()));
    }

}