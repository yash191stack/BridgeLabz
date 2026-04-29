import java.util.*;

class ZeroSumSubarrays {
    static void findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray: " + (start + 1) + " to " + i);
                }
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }
}