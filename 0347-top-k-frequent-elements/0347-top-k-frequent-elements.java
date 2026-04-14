import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: min heap (based on frequency)
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        // Step 3: maintain size k
        for (int num : freq.keySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: build result
        int[] result = new int[k];
        int i = 0;
        for (int num : pq) {
            result[i++] = num;
        }

        return result;
    }
}