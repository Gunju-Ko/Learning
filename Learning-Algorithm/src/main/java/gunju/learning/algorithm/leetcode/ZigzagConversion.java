package gunju.learning.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<Position> positions = new ArrayList<>();
        Position now = new Position(0, 0, numRows, Direction.UP, s.charAt(0));
        positions.add(now);

        for (int i = 1; i < s.length(); ++i) {
            Position next = now.next(s.charAt(i));
            positions.add(next);
            now = next;
        }

        positions.sort((o1, o2) -> {
            if (o1.y > o2.y) return 1;
            else if (o1.y < o2.y) return -1;
            else return o1.x - o2.x;
        });

        return positions.stream().map(p -> String.valueOf(p.value)).collect(Collectors.joining());
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
