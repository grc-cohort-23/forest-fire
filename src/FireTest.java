import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    // Add more tests!


    @Test
    public void testTimeToBurnExample2() {
        char[][] forest = {
            {'t','.','.','t','t','t','.','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 7;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnExample3() {
        char[][] forest = {
            {'t','.','.','t','t','t','.','.','t'},
            {'t','.','t','t','.','.','.','.','t'},
            {'t','.','t','t','t','t','t','t','t'},
            {'t','t','.','t','.','.','.','.','.'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 4;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnNoTree() {
        char[][] forest = {
            {'.','.','.','t','t','t','.','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = -1;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }\
    
    @Test
    public void testTimeToBurnOutOfBounds() {
        char[][] forest = {
            {'.','.','.','t','t','t','.','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = -1;
        int matchC = -1;

        assertThrows(IndexOutOfBoundsException.class, () -> Fire.timeToBurn(forest, matchR, matchC));

    }
}
