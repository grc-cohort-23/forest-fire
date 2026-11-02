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
    public void straightLine() {
        char[][] forest = { {'t','t','t','t','t'} };
        assertEquals(4, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void startInMiddle() {
        char[][] forest = { {'t','t','t','t','t'} };
        assertEquals(2, Fire.timeToBurn(forest, 0, 2));
    }
}







  
 
 