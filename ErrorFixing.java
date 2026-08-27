public class ErrorFixing {
    public static void printGreeting(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) {
        int age = 20;
        String name = "Alice";
        double price = 19.99;
        boolean isReady = true;
        int total;

        System.out.println("Hello, " + name);
        total = age + 5;

        int[] numbers = {10, 20, 30};
        System.out.println(numbers[2]);

        String message = "Hello";
        System.out.println(message.length());

        int number = 42;
        int parsed = Integer.parseInt("42");
        int result = divide(10, 2);

        printGreeting("Alice");
        int wrongVar = 100;

        if (isReady) {
            System.out.println("Ready");
        }

        System.out.println("Total is " + total);
        System.out.println("Number: " + number);
        System.out.println("Parsed: " + parsed);
        System.out.println("Result: " + result);
        System.out.println("Price: " + price);
        System.out.println("Wrong var: " + wrongVar);
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a / b;
    }
}
