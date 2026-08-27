
public class Messy {

    // Finds second largest element in array
    public static int f(int[] a) {
        if (a == null || a.length < 2) {
            return -100000; // Arbitrary error code!

                }int x = Integer.MIN_VALUE; // Hardcoded Integer.MIN_VALUE
        int y = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > x) {
                y = x;
                x = a[i];
            } else if (a[i] > y && a[i] != x) {
                y = a[i];
            }
        }

        if (y == Integer.MIN_VALUE) {
            return -100000;
        }

        return y;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 35};
        System.out.println("Result: " + f(arr));
    }

}
