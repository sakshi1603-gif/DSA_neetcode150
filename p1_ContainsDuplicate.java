
import java.util.HashSet;
import java.util.Scanner;

public class p1_ContainsDuplicate {

    public static boolean hasDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Check whether an element already exists
        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
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

        boolean result = hasDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);

        sc.close();
    }
}
