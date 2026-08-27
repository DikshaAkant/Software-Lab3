public class CodeOptimisation {
    
    // public static void main(String[] args) {
    //     //maximum subarray sum
    //     //{1, 2,-3, 6, 5, -2}  op=11
    //     int[] arr = {1, 2,-3, 6, 5, 2};
    //     int n = arr.length;
    //     int sum = 0;
    //     int maxSum = Integer.MIN_VALUE;

    //     for(int i=0; i<n; i++) {
    //         for(int j=0; j<n; j++) {
    //             for(int k=i; k<j; k++) {
    //                 sum += arr[k];
    //             }
    //             maxSum = Math.max(maxSum, sum);
    //             sum = 0;
    //         }
    //     }

    //     System.out.println(maxSum);
    // }


    // public class MaxSubarrayBruteForce {

        //WindSurf code 
        // Try every subarray [i..j] and track the best sum.
        static int maxSubarraySum(int[] a) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < a.length; i++) {
                int sum = 0;
                for (int j = i; j < a.length; j++) {
                    sum += a[j];
                    best = Math.max(best, sum);
                }
            }
            return best;
        }
    
        public static void main(String[] args) {
            int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            System.out.println(maxSubarraySum(a)); // 6  -> [4,-1,2,1]
        }
    // }



    //Github Copilot code 
    // public class MaxSubarrayBruteForce {
    
    //     public static int maxSubarraySumBruteForce(int[] nums) {
    //         int maxSum = Integer.MIN_VALUE;
    
    //         // Outer loop: start index of the subarray
    //         for (int i = 0; i < nums.length; i++) {
    //             int currentSum = 0;
                
    //             // Inner loop: end index of the subarray
    //             for (int j = i; j < nums.length; j++) {
    //                 currentSum += nums[j]; // Accumulate sum from i to j
    //                 maxSum = Math.max(maxSum, currentSum);
    //             }
    //         }
            
    //         return maxSum;
    //     }
    
    //     public static void main(String[] args) {
    //         int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    //         System.out.println("Maximum Subarray Sum (Brute Force): " + maxSubarraySumBruteForce(nums)); // Output: 6
    //     }
    // }
}