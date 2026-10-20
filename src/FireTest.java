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

     @Test
    public void testSingleTree() {
        char[][] forest = {
            {'t'}
        };

        int actual = Fire.timeToBurn(forest, 0, 0);
        assertEquals(0, actual); // Takes 0 steps to burn the only tree it starts on.                                                                                                   }
    }

     @Test
    public void testEmptyForest() {
        char[][] forest = {};

        int actual = Fire.timeToBurn(forest, 0, 0);
        assertEquals(0, actual);                                                               
    
        }

        @Test
    public void testNullForest() {
        char[][] forest = null;

        int actual = Fire.timeToBurn(forest, 0, 0);
        assertEquals(0, actual);                                                               
    
        }

         


        @Test
    public void testZeroColumnForest() {
        char[][] forest = {{}};

        int actual = Fire.timeToBurn(forest, 0, 0);
        assertEquals(0, actual);                                                               
    
        }

         @Test
    public void testNoTree() {
        char[][] forest = {{'.'}};

        int actual = Fire.timeToBurn(forest, 0, 0);
        assertEquals(0, actual);                                                               
    
        }

         @Test
    public void testInvalidStartingRow() {
        char[][] forest = {
    {'t','.','.','t','t','t','t','.','t'},
    {'.','.','t','t','.','.','.','.','t'},
    {'.','.','t','t','t','t','t','t','t'},
    {'t','t','t','t','.','.','.','.','.'}};

        int actual = Fire.timeToBurn(forest, -1, 3);
        assertEquals(0, actual);                                                               
    
        }


        @Test
    public void testInvalidStartingColumn() {
        char[][] forest = {
    {'t','.','.','t','t','t','t','.','t'},
    {'.','.','t','t','.','.','.','.','t'},
    {'.','.','t','t','t','t','t','t','t'},
    {'t','t','t','t','.','.','.','.','.'}};

        int actual = Fire.timeToBurn(forest, 1, -1);
        assertEquals(0, actual);                                                               
    
        }

        @Test
    public void testMatchOnEmptySpace() {
        char[][] forest = {
    {'t','.','.','t','t','t','t','.','t'},
    {'.','.','t','t','.','.','.','.','t'},
    {'.','.','t','t','t','t','t','t','t'},
    {'t','t','t','t','.','.','.','.','.'}};

        int actual = Fire.timeToBurn(forest, 1, 1);
        assertEquals(0, actual);                                                               
    
        }

        @Test
    public void testStraightLineFireSpread() {
        char[][] forest = {
    {'.','.','.','.','.','.','.','.','.'},
    {'t','t','t','t','t','t','t','t','t'},
    {'.','.','.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.','.','.'}};

        int actual = Fire.timeToBurn(forest, 1, 0);
        assertEquals(8, actual);                                                               
    
        }

        @Test
    public void testBranchingFireSpread() {
        char[][] forest = {
    {'.','t','.','.','.','.','.','.','.'},
    {'t','t','t','t','t','t','t','t','t'},
    {'.','.','.','t','.','.','.','t','t'},
    {'.','.','t','t','.','.','.','t','t'}};

        int actual = Fire.timeToBurn(forest, 3, 7);
        assertEquals(9, actual);                                                               
    
        }

        @Test
    public void testDisconnectedTreesFireSpread() {
        char[][] forest = {
    {'.','t','.','.','.','.','.','.','.'},
    {'t','t','t','t','t','t','.','.','.'},
    {'.','.','.','t','.','.','.','t','t'},
    {'.','.','t','t','.','.','.','t','t'}};

        int actual = Fire.timeToBurn(forest, 3, 7);
        assertEquals(2, actual);                                                               
    
        }

    }


    
    // Add more tests!

