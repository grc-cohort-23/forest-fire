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
    public void testSingleTree() {
        char[][] forest = {
            {'t'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testTwoAdjacentTrees() {
        char[][] forest = {
            {'t', 't'}
        };

        assertEquals(1, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testStraightLineOfTrees() {
        char[][] forest = {
            {'t', 't', 't', 't'}
        };

        assertEquals(3, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testAllTrees() {
        char[][] forest = {
            {'t', 't'},
            {'t', 't'}
        };

        assertEquals(2, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testDisconnectedTrees() {
        char[][] forest = {
            {'t', '.', 't'},
            {'t', '.', 't'},
            {'t', '.', 't'}
        };

        assertEquals(2, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testFireStartsInMiddle() {
        char[][] forest = {
            {'t', 't', 't', 't', 't'}
        };

        assertEquals(2, Fire.timeToBurn(forest, 0, 2));
    }

    @Test
    public void testFireBlockedByEmptySpace() {
        char[][] forest = {
            {'t', '.', 't'}
        };

        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

}
