package gunju.learning.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        DistinctList result = new DistinctList();
        Index index = new Index(nums);

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j <nums.length; ++j) {
                int a = nums[i];
                int b = nums[j];
                int c = -(nums[i] + nums[j]);

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

        public Index(int[] nums) {
            for (int num : nums) {
                if (treeMap.containsKey(num)) {
                    treeMap.put(num, treeMap.get(num) + 1);
                } else {
                    treeMap.put(num, 1);
                }
            }
        }

        public int find(int num) {
            if (treeMap.containsKey(num)) {
                return treeMap.get(num);
            }
            return 0;
        }
    }
}
