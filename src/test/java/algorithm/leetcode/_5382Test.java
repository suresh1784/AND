package algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _5382Test {
    _5382 obj = new _5382();
    @Test
    void entityParser() {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        String expected = "& is an HTML entity but &ambassador; is not.";
        String actual = obj.entityParser(text);
        Assert.assertEquals(expected,actual );
    }
    @Test
    void entityParser1() {
        String text = "and I quote: &quot;...&quot;";
        String expected = "and I quote: \"...\"";
        String actual = obj.entityParser(text);
        Assert.assertEquals(expected,actual );
    }

    @Test
    void entityParser2() {
        String text =  "Stay home! Practice on Leetcode :)";
        String expected =  "Stay home! Practice on Leetcode :)";
        String actual = obj.entityParser(text);
        Assert.assertEquals(expected,actual );
    }

    @Test
    void entityParser3() {
        String text = "x &gt; y &amp;&amp; x &lt; y is always false";
        String expected = "x > y && x < y is always false";
        String actual = obj.entityParser(text);
        Assert.assertEquals(expected,actual );
    }

    @Test
    void entityParser4() {
        String text = "leetcode.com&frasl;problemset&frasl;all";
        String expected = "leetcode.com/problemset/all";
        String actual = obj.entityParser(text);
        Assert.assertEquals(expected,actual );
    }
}