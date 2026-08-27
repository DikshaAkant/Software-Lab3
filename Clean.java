
import java.util.Objects;
import java.util.OptionalInt;

public class Clean {

    /**
     * Finds the second largest distinct integer in the provided array.
     *
     * @param numbers The array to search through.
     * @return An OptionalInt containing the second largest distinct integer, or
     * empty if all elements are identical.
     * @throws IllegalArgumentException if numbers array is null or has fewer
     * than 2 elements.
     */
    public static OptionalInt findSecondLargest(int[] numbers) {
        validateInput(numbers);

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for (int currentNumber : numbers) {
            if (currentNumber > largest) {
                secondLargest = largest;
                largest = currentNumber;
                if (secondLargest != Integer.MIN_VALUE) {
                    foundSecond = true;
                }
            } else if (isValidSecondLargestCandidate(currentNumber, largest, secondLargest)) {
                secondLargest = currentNumber;
                foundSecond = true;
            }
        }

        return foundSecond ? OptionalInt.of(secondLargest) : OptionalInt.empty();
    }

    // Helper method 1: Explicit guard clauses for fail-fast input validation
    private static void validateInput(int[] numbers) {
        if (Objects.isNull(numbers) || numbers.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
    }

    // Helper method 2: Extracting conditional checks to express intent clearly
    private static boolean isValidSecondLargestCandidate(int number, int largest, int secondLargest) {
        return number > secondLargest && number < largest;
    }

    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 35};

        findSecondLargest(numbers).ifPresentOrElse(
                second -> System.out.println("Second largest element: " + second),
                () -> System.out.println("No second distinct largest element found.")
        );
    }

    //Windsurf refactored
    /* 
    public class SecondLargestFinder {

        /**
         * Returns the second largest DISTINCT element.
         * Throws if fewer than 2 distinct elements exist.
         * Single pass, O(n) time, O(1) space.
         
        public static int findSecondLargest(int[] arr) {
            if (arr == null || arr.length < 2) {
                throw new IllegalArgumentException("Array must contain at least 2 elements");
            }
            long largest = Long.MIN_VALUE, secondLargest = Long.MIN_VALUE;
            for (int value : arr) {
                if (value > largest) {
                    secondLargest = largest;
                    largest = value;
                } else if (value < largest && value > secondLargest) {
                    secondLargest = value;
                }
            }
            if (secondLargest == Long.MIN_VALUE) {
                throw new IllegalArgumentException("No second distinct largest element");
            }
            return (int) secondLargest;
        }
    
        public static void main(String[] args) {
            System.out.println(findSecondLargest(new int[]{12, 35, 1, 10, 34, 1}));   // 34
            System.out.println(findSecondLargest(new int[]{10, 10, 9}));              // 9
            System.out.println(findSecondLargest(new int[]{-5, -2, -9}));             // -5
        }
    }
     */
}
