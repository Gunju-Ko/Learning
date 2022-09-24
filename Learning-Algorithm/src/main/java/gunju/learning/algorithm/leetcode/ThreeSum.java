package gunju.learning.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        DistinctList result = new DistinctList();
        Index index = new Index(nums);
        List<Integer> compressed = index.getNums();
        if (index.max < 0 || index.min > 0) return Collections.emptyList();
        for (int i = 0; i < compressed.size(); ++i) {
            int a = compressed.get(i);
            if (a < 0 && (-a) > (index.max * 2)) {
                continue;
            }
            int aCount = index.find(a);
            if (aCount >= 3 && a == 0) result.add(0, 0, 0);
            else if (a != 0 && aCount >= 2 && (index.find(-(2 * a))) > 0) result.add(a, a, -(2 * a));
            for (int j = i + 1; j <compressed.size(); ++j) {
                int b = compressed.get(j);
                int c = -(a + b);
                if (a > 0 && b > 0 && c < index.min) break;
                int wordCount = index.find(c);
                if (wordCount == 0) continue;
                if (a != b && b != c && c != a) {
                    result.add(a, b, c);
                } else if (a == b && b == c) {
                    if (wordCount >= 3) result.add(a, b, c);
                } else if (wordCount >= 2) {
                    result.add(a, b, c);
                }
            }
        }

        return result.getAs();
    }

    public static class DistinctList {
        private final Set<String> result = new HashSet<>();

        public void add(int a, int b, int c) {
            int[] nums = new int[] {a, b, c};
            Arrays.sort(nums);
            result.add(nums[0] + "," + nums[1] + "," + nums[2]);
        }

        private List<List<Integer>> getAs() {
            List<List<Integer>> r = new ArrayList<>();

            for (String str: result) {
                String[] splited = str.split(",");
                r.add(Arrays.asList(Integer.valueOf(splited[0]), Integer.valueOf(splited[1]), Integer.valueOf(splited[2])));
            }

            return r;
        }
    }

    public static class Index {
        private final Map<Integer, Integer> treeMap = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        public Index(int[] nums) {
            for (int num : nums) {
                int count = find(num) + 1;
                treeMap.put(num, count);
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }
        }

        public int find(int num) {
            Integer ret = treeMap.get(num);
            if (ret == null) return 0;
            else return ret;
        }

        public List<Integer> getNums() {
            return new ArrayList<>(treeMap.keySet());
        }
    }
}
