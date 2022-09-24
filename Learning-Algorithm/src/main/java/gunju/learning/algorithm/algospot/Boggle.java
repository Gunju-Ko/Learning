package gunju.learning.algorithm.algospot;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class Boggle {

    private final char[][] board = new char[5][5];
    private Boolean[][][] cache;

    private final int[][] nextSteps = {{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};

    public Boggle embrace(int rowNum, String row) {
        if (rowNum > 5) throw new IllegalArgumentException("rowNum should not bigger than 5");
        if (row.length() != 5) throw new IllegalArgumentException("row's length should be 5");
        for (int x = 0; x < row.length(); ++x) {
            board[rowNum][x] = row.charAt(x);
        }
        return this;
    }

    public boolean find(String s) {
        cache = new Boolean[5][5][10];
        char start = s.charAt(0);
        for (int y = 0; y < 5; ++y) {
            for (int x = 0; x < 5; ++x) {
                if (board[y][x] == start) {
                    if (findRecursive(y, x, 1, s)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findRecursive(int y, int x, int position, String s) {
        if (position == s.length()) return true;
        if (cache[y][x][position] != null && !cache[y][x][position]) return false;
        char current = s.charAt(position);

        for (int[] nextStep: nextSteps) {
            int nextY = y + nextStep[0];
            int nextX = x + nextStep[1];
            if (rangeIn(nextY, nextX) && board[nextY][nextX] == current && findRecursive(nextY, nextX, position + 1, s)) {
                return true;
            }
        }
        cache[y][x][position] = false;
        return false;
    }

    private boolean rangeIn(int y, int x) {
        return rangeIn(y) && rangeIn(x);
    }

    private boolean rangeIn(int a) {
        return a >= 0 && a < 5;
    }
}
