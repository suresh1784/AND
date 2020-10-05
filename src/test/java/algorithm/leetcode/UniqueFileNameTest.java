package algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UniqueFileNameTest {
    UniqueFileName uniqueFileName = new UniqueFileName();
    @Test
    void getFolderNames1() {
        String[] arr = {"pes","fifa","gta","pes(2019)"};
        String[] expected = {"pes","fifa","gta","pes(2019)"};
        String[] actual = uniqueFileName.getFolderNames(arr);
        assertEquals(expected, actual);
    }

    @Test
    void getFolderNames2() {
        String[] arr = {"gta","gta(1)","gta","avalon"};
        String[] expected = {"gta","gta(1)","gta(2)","avalon"};
        String[] actual = uniqueFileName.getFolderNames(arr);
        assertEquals(expected, actual);
    }


    @Test
    void getFolderNames3() {
        String[] arr = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"};
        String[] expected = {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"};
        String[] actual = uniqueFileName.getFolderNames(arr);
        assertEquals(expected, actual);
    }


    @Test
    void getFolderNames4() {
        String[] arr = {"wano","wano","wano","wano"};
        String[] expected = {"wano","wano(1)","wano(2)","wano(3)"};
        String[] actual = uniqueFileName.getFolderNames(arr);
        assertEquals(expected, actual);
    }

    @Test
    void getFolderNames5() {
        String[] arr = {"kaido","kaido(1)","kaido","kaido(1)"};
        String[] expected = {"kaido","kaido(1)","kaido(2)","kaido(1)(1)"};
        String[] actual = uniqueFileName.getFolderNames(arr);
        assertEquals(expected, actual);
    }
}