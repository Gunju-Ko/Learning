package gunju.learning.algorithm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class QuadTreeTest {

    @Test
    void testQuadTree() {
        QuadTree tree = new QuadTree();

        assertEquals(tree.reverse("w"), "w");
        assertEquals(tree.reverse("xbwwb"), "xwbbw");
        assertEquals(tree.reverse("xbwxwbbwb"), "xxbwwbbbw");
        assertEquals(tree.reverse("xxwwwbxwxwbbbwwxxxwwbbbwwwwbb"), "xxwbxwwxbbwwbwbxwbwwxwwwxbbwb");
    }
}