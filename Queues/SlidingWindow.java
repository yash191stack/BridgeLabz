import java.util.*;

class SlidingWindow {
    static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove out of window
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            // Store result
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }

        return result;
    }
}