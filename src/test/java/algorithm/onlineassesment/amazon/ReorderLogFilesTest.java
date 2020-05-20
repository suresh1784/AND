package algorithm.onlineassesment.amazon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderLogFilesTest {

    @Test
    void reorderLogFiles() {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String[] actual =reorderLogFiles.reorderLogFiles(logs);
        String[] expected = {"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        assertArrayEquals(actual,expected );
    }

    @Test
    void reorderLogFiles1() {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String[] actual =reorderLogFiles.reorderLogFiles(logs);
        String[] expected ={"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        assertArrayEquals(actual,expected );
    }

    @Test
    void reorderLogFiles2() {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String[] actual =reorderLogFiles.reorderLogFiles(logs);
        String[] expected ={"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        assertArrayEquals(actual,expected );
    }

    @Test
    void reorderLogFiles3() {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String[] actual =reorderLogFiles.reorderLogFiles(logs);
        String[] expected ={"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        assertArrayEquals(actual,expected );
    }


}