package gunju.learning.algorithm.algospot;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class Boggle {

    private final char[][] board = new char[5][5];
    private Boolean[][][] cache;

    public Boggle embrace(int rowNum, String row) {
        if (rowNum > 5) throw new IllegalArgumentException("rowNum should not bigger than 5");
        if (row.length() != 5) throw new IllegalArgumentException("row's length should be 5");
        for (int x = 0; x < row.length(); ++x) {
            board[rowNum][x] = row.charAt(x);
        }
        return this;
    }

    public boolean find(String s) {
        initCache();
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

    private void initCache() {
        cache = new Boolean[5][5][10];
    }

    private boolean findRecursive(int y, int x, int position, String s) {
        if (position == s.length()) return true;
        if (cache[y][x][position] != null && !cache[y][x][position]) return false;
        char current = s.charAt(position);
        int right = x + 1;
        int left = x - 1;
        int up = y + 1;
        int down = y - 1;

        if (rangeIn(right)) {
            if (board[y][right] == current && findRecursive(y, right, position + 1, s)) {
                return true;
            }
            if (rangeIn(up) && board[up][right] == current && findRecursive(up, right, position + 1, s)) {
                return true;
            }
            if (rangeIn(down) && board[down][right] == current && findRecursive(down, right, position + 1, s)) {
                return true;
            }
        }

        if (rangeIn(up) && board[up][x] == current && findRecursive(up, x, position + 1, s)) {
            return true;
        }

        if (rangeIn(down) && board[down][x] == current && findRecursive(down, x, position + 1, s)) {
            return true;
        }

        if (rangeIn(left)) {
            if (board[y][left] == current && findRecursive(y, left, position + 1, s)) {
                return true;
            }
            if (rangeIn(up) && board[up][left] == current && findRecursive(up, left, position + 1, s)) {
                return true;
            }
            if (rangeIn(down) && board[down][left] == current && findRecursive(down, left, position + 1, s)) {
                return true;
            }
        }
        cache[y][x][position] = false;
        return false;
    }

    private boolean rangeIn(int a) {
        return a >= 0 && a < 5;
    }
}
