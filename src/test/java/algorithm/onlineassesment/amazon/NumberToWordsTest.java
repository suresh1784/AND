package algorithm.onlineassesment.amazon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordsTest {
    NumberToWords numberToWords = new NumberToWords();
    @Test
    void numberToWords() {
        int number = 123;
        String expected = "One Hundred Twenty Three";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numberToWords1() {
        int number = 12345;
        String expected = "Twelve Thousand Three Hundred Forty Five";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numberToWords2() {
        int number = 1234567;
        String expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numberToWords3() {
        int number = 1234567891;
        String expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numberToWords4() {
        long number = 1234567891;
        String expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numberToWords5() {
        long number = 20;
        String expected = "Twenty";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numberToWords6() {
        long number = 2000;
        String expected = "Two Thousand";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    void numberToWords7() {
        long number = 1000;
        String expected = "One Thousand";
        String actual = numberToWords.numberToWords(number);
        Assert.assertEquals(expected, actual);
    }

}