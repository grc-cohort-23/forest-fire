
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree is also
     * set on fire. 
     * 
     * 
     * EXAMPLE 
     * forest:
     * 
     * t..tttt.t
     * ..tt....t
     * ..ttttttt
     * tttt.....
     * 
     * matchR: 2
     * matchC: 6
     * 
     * Result: 8
     * 
     * Explanation:
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?

        // Implement this AND add more tests!!!
        if (forest == null || forest.length == 0 || forest[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[forest.length][forest[0].length];
        Queue<Location> burnQueue = new ArrayDeque<>();
        
        // Ensure the starting location is valid and is actually a tree
        if (matchR >= 0 && matchR < forest.length && matchC >= 0 && matchC < forest[0].length 
                && forest[matchR][matchC] == 't') {
            burnQueue.add(new Location(matchR, matchC, 0));
            visited[matchR][matchC] = true;
        }

        int maxTime = 0;

        while (!burnQueue.isEmpty()) {
            Location current = burnQueue.remove();
            maxTime = Math.max(maxTime, current.time());

            // Process all valid adjacent unburned trees
            for (Location neighbor : burnedNeighbors(forest, current)) {
                if (!visited[neighbor.row()][neighbor.column()]) {
                    visited[neighbor.row()][neighbor.column()] = true;
                    burnQueue.add(neighbor);
                }
            }
        }

        return maxTime;
    }

    private static List<Location> burnedNeighbors(char[][] forest, Location current) {
        int[][] moves = new int[][] {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        List<Location> validMoves = new ArrayList<>();

        for (int[] move : moves) {
            int newRow = current.row() + move[0];
            int newCol = current.column() + move[1];

            // Check boundaries and make sure the space is a tree ('t')
            if (newRow >= 0 && newRow < forest.length &&
                newCol >= 0 && newCol < forest[0].length &&
                forest[newRow][newCol] == 't') {
                validMoves.add(new Location(newRow, newCol, current.time() + 1));
            }        
        }

        return validMoves;
    }
}
//e