package gunju.learning.algorithm.programmers.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class FeatureDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < progresses.length; ++i) {
            if (isFinish(progresses[i])) {
                continue;
            }
            if (i == progresses.length - 1) {
                results.add(1);
                break;
            }
            int remain = 100 - progresses[i];
            int speed = speeds[i];
            int days = getDays(remain, speed);

            for (int j = i + 1; j < progresses.length; ++j) {
                if (isFinish(progresses[j])) {
                    continue;
                }
                progresses[j] += days * speeds[j];
                if (progresses[j] >= 100) {
                    setFinish(progresses, j);
                }
            }
            int finish = 0;
            for (int j = i + 1; j < progresses.length; ++j) {
                if (isFinish(progresses[j])) {
                    finish++;
                } else {
                    break;
                }
            }

            results.add(1 + finish);
        }
        return results.stream().mapToInt(i -> i).toArray();
    }

    private void setFinish(int[] progresses, int j) {
        progresses[j] = -1;
    }

    private boolean isFinish(int progress) {
        return progress == -1;
    }

    private int getDays(int remain, int speed) {
        int days = remain / speed;
        if (remain % speed != 0) {
            days++;
        }
        return days;
    }

}
