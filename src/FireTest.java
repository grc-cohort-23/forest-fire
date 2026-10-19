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

    @Test
    public void testOneTreeBurnsOnly() {
        char[][] forest = {
            {'.','t','.'},
            {'t','.','t'},
            {'.','t','.'}
        };

        int matchR = 1;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnWindyRow() {
        char[][] forest = {
            {'t','.','t','t','t','.','t','t','t'},
            {'t','.','t','.','t','.','t','.','t'},
            {'t','.','t','.','t','.','t','.','t'},
            {'t','t','t','.','t','t','t','.','t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 23;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
    
    @Test
    public void testNoTreesToBurn() {
        char[][] forest = {
            {'.','.','.'},
            {'.','.','.'},
            {'.','.','.'}
        };

        int matchR = 0;
        int matchC = 0;

        assertThrows(NoTreesException.class, () -> Fire.timeToBurn(forest, matchR, matchC));
    }

    @Test
    public void testNullArray() {
        char[][] forest = {
            {}
        };

        int matchR = 0;
        int matchC = 0;

        assertThrows(NoTreesException.class, () -> Fire.timeToBurn(forest, matchR, matchC));
    }

    @Test
    public void testInvalidStartingTreeRowAndColumn() {
        char[][] forest = {
            {'.','t','.'},
            {'t','.','t'},
            {'.','t','.'}
        };

        int matchR = 10;
        int matchC = 10;

        assertThrows(NoTreesException.class, () -> Fire.timeToBurn(forest, matchR, matchC));
    }
}
