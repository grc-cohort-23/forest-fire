import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testTimeToBurn_loneTree() {
        char[][] forest = {
            {'.','.','.'},
            {'.','t','.'},
            {'.','.','.'}
        };

        int actual = Fire.timeToBurn(forest, 1, 1);

        assertEquals(0, actual);
    }

     @Test
    public void testTimeToBurn_singleRow() {
        char[][] forest = {
            {'t','t','t','t','t'}
        };

        int actual = Fire.timeToBurn(forest, 0, 0);

        assertEquals(4, actual);
    }
     @Test
    public void testTimeToBurn_cornerStart() {
        char[][] forest = {
            {'t','t','t'},
            {'t','t','t'},
            {'t','t','t'}
        };

        int actual = Fire.timeToBurn(forest, 0, 0);

        assertEquals(4, actual);
    }
}
