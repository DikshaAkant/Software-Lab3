public class Optimised {

    //Windsurf optimised code

    // public class MaxSubarrayKadane {
        // At each index, either extend the previous subarray or start fresh here.
        static int maxSubarraySum(int[] a) {
            int cur = a[0], best = a[0];
            for (int i = 1; i < a.length; i++) {
                cur = Math.max(a[i], cur + a[i]);
                best = Math.max(best, cur);
            }
            return best;
        }
    
        // Variant that also reports the subarray bounds.
        static int[] maxSubarrayWithBounds(int[] a) {
            int cur = a[0], best = a[0], start = 0, bestStart = 0, bestEnd = 0;
            for (int i = 1; i < a.length; i++) {
                if (cur + a[i] < a[i]) { cur = a[i]; start = i; }
                else { cur += a[i]; }
                if (cur > best) { best = cur; bestStart = start; bestEnd = i; }
            }
            return new int[]{best, bestStart, bestEnd};
        }
    
        public static void main(String[] args) {
            int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println(maxSubarraySum(a));                        // 6
            System.out.println(java.util.Arrays.toString(maxSubarrayWithBounds(a))); // [6, 3, 6]
        }
    // }




    //Github copilot optimsed code 
    // public class MaxSubarrayOptimized {
    
    //     public static int maxSubarraySumOptimized(int[] nums) {
    //         int maxSum = nums[0];
    //         int currentSum = nums[0];
    
    //         for (int i = 1; i < nums.length; i++) {
    //             // Decide: extend existing subarray or start fresh from nums[i]
    //             currentSum = Math.max(nums[i], currentSum + nums[i]);
    //             // Track the highest sum seen so far
    //             maxSum = Math.max(maxSum, currentSum);
    //         }
    
    //         return maxSum;
    //     }
    
    //     public static void main(String[] args) {
    //         int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    //         System.out.println("Maximum Subarray Sum (Kadane's): " + maxSubarraySumOptimized(nums)); // Output: 6
    //     }
    // }
}
