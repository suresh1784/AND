package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoadBalancerTest {
    LoadBalancer loadBalancer = new LoadBalancer();
    @Test
    void loadBalancer() {
       int [] in =  {1, 3, 4, 2, 2, 2, 1, 1, 2} ;
       boolean actual = loadBalancer.loadBalancer(in);
       boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    void loadBalancer1() {
        int [] in =  {1, 1, 1, 1, 1, 1} ;
        boolean actual = loadBalancer.loadBalancer(in);
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
// [2, 4, 5, 3, 3, 9, 2, 2, 2]
@Test
void loadBalancer3() {
    int [] in =  {2, 4, 5, 3, 3, 9, 2, 2, 2} ;
    boolean actual = loadBalancer.loadBalancer(in);
    boolean expected = true;
    Assert.assertEquals(expected, actual);
}
}