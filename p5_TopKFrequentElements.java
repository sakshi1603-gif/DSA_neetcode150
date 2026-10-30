
import java.util.*;

public class p5_TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Add numbers according to frequency
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            buckets[frequency].add(key);
        }

        // Step 4: Collect top K elements
        int[] ans = new int[k];
        int j = 0;

        for (int i = buckets.length - 1; i >= 1; i--) {
            for (int num : buckets[i]) {
                ans[j++] = num;

                if (j == k) {
                    return ans;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] result = topKFrequent(nums, k);

        System.out.println("Top K Frequent Elements: " + Arrays.toString(result));

        sc.close();
    }
}
