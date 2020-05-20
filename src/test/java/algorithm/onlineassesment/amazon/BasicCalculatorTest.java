package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorTest {
    BasicCalculator basicCalculator = new BasicCalculator();
    @Test
    void basicCalculator() {
        assertEquals(3, basicCalculator.basicCalculator("3"));
    }

    @Test
    void basicCalculator1() {
        assertEquals(3, basicCalculator.basicCalculator("( + 1 2 )"));
    }

    @Test
    void basicCalculator2() {
        assertEquals(12, basicCalculator.basicCalculator("( + 3 4 5 )"));
    }

    @Test
    void basicCalculator4() {
        assertEquals(288, basicCalculator.basicCalculator("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )"));
    }
}