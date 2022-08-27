package gunju.learning.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<Position> positions = new ArrayList<>();
        Rows rows = new Rows(numRows);

        Position now = new Position(0, 0, numRows, Direction.UP, s.charAt(0));
        positions.add(now);
        rows.add(now.value, now.y);

        for (int i = 1; i < s.length(); ++i) {
            Position next = now.next(s.charAt(i));
            positions.add(next);
            now = next;
            rows.add(now.value, now.y);
        }

        return rows.get();
    }

    public static class Rows {
        final Row[] rows;

        public Rows(int rowNum) {
            this.rows = new Row[rowNum];
        }

        public void add(char value, int y) {
            if (rows[y] == null) {
                rows[y] = new Row();
            }
            this.rows[y].add(value);
        }

        public String get() {
            StringBuilder result = new StringBuilder();
            for (Row row : rows) {
                if (row != null) result.append(row.get());
            }
            return result.toString();
        }
    }

    public static class Row {
        StringBuilder result;

        public Row() {
            this.result = new StringBuilder();
        }

        public void add(char c) {
            result.append(c);
        }

        public String get() {
            return result.toString();
        }
    }


    public static class Position {
        final int x;
        final int y;
        final int maxRow;
        final Direction direction;
        final char value;

        public Position(int x, int y, int maxRow, Direction direction, char value) {
            this.x = x;
            this.y = y;
            this.maxRow = maxRow;
            this.direction = direction;
            this.value = value;
        }

        Position next(char value) {
            if (this.direction == Direction.UP) {
                if (y < maxRow - 1) {
                    return new Position(this.x, this.y + 1, this.maxRow, this.direction, value);
                } else {
                    // 방향 전환
                    return new Position(this.x + 1, this.y - 1, this.maxRow, Direction.Down, value);
                }
            } else {
                if (y > 0) {
                    return new Position(this.x + 1, this.y - 1, this.maxRow, Direction.Down, value);
                } else {
                    return new Position(this.x, this.y + 1, this.maxRow, Direction.UP, value);
                }
            }
        }

    }

    public enum Direction {
        UP,
        Down
    }

}
