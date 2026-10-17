import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
                { 't', '.', '.', 't', 't', 't', 't', '.', 't' },
                { '.', '.', 't', 't', '.', '.', '.', '.', 't' },
                { '.', '.', 't', 't', 't', 't', 't', 't', 't' },
                { 't', 't', 't', 't', '.', '.', '.', '.', '.' }
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    // Add more tests!

    @Test
    public void testRowOfTrees() {
        char[][] forest = { { 't', 't', 't', 't' } };

        assertEquals(3, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testColumnOfTrees() {
        char[][] forest = {
                { 't' },
                { 't' },
                { 't' }
        };

        assertEquals(2, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testDisconnectedTrees() {
        char[][] forest = { { 't', 't', '.', 't' } };

        assertEquals(1, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testMatchOnEmptySpace() {
        char[][] forest = {{'.', 't'}};

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testSquareOfTrees() {
        char[][] forest = {
            {'t', 't'},
            {'t', 't'}
        };

        assertEquals(2, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testDiagonalTrees() {
        char[][] forest = {
            {'t', '.'},
            {'.', 't'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testStartInMiddle() {
        char[][] forest = {{'t', 't', 't', 't', 't'}};

        assertEquals(2, Fire.timeToBurn(forest, 0, 2));
    }
    }
