import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents
     * a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every
     * subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree
     * is also
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
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees
     * also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last
     * tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not
     * included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the
     *               ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    private record Position(int row, int col) {
    }

    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?

        
        Location start = new Location(matchR, matchC, 0);
        Queue<Location> queue = new ArrayDeque<>();
        Set<Position> visited = new HashSet<>();
        queue.add(start);

        int time = 0;
        while (!queue.isEmpty()) {
            Location current = queue.remove();
            if (visited.contains(new Position(current.row(), current.column()))) {continue;}
            visited.add(new Position(current.row(), current.column()));
            time = current.time();
                List<Location> neighbors  = possibleMoves(forest, current);
             for (Location neighbor : neighbors) {
                queue.add(neighbor);
             }
            }
            return time;
        }

    // Implement this AND add more tests!!!
    public static List<Location> possibleMoves(char[][] forest, Location current) {
        int[][] moves = new int[][] {
                { -1, 0 }, // UP
                { 1, 0 }, // DOWN
                { 0, -1 }, // LEFT
                { 0, 1 }, // RIGHT
        };
        List<Location> vaildMoves = new ArrayList<>();
        for (int[] move : moves) {
            Location possibleMove = new Location(current.row() + move[0],
                    current.column() + move[1], current.time() +1);

            if (possibleMove.row() >= 0 && possibleMove.row() < forest.length && possibleMove.column() >= 0
                    && possibleMove.column() < forest[0].length && forest[possibleMove.row()][possibleMove.column()] == 't') {
                vaildMoves.add(possibleMove);
            }
        }
        return vaildMoves;
    }
}