import java.lang.Math;
import java.util.Scanner;

public class InfiniteSeries {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int recurse = factorial(n - 1);
        int result = n * recurse;
        return result;
    }

    public static double myExp (double x, int n) {
        double sum = 0.0;
        double term = 0.0;

        for (int i = 0; i<=n; i++) {
            double myFactorial = factorial(i);
            double numerator = Math.pow(x, i);

            term = numerator/myFactorial;
            sum += term;
        }
        return sum;
    }
    public static double newExp (double x, int n) {
        double sum = 1.0;
        double numerator = 1.0;
        double denominator = 1.0;

        for (int i = 1; i<=n; i++) {
            numerator *= x;
            denominator *= i;
            sum += numerator/denominator;
        }
        return sum;
    }

    public static void check (double x) {
        double result1 = myExp(x, 10);
        double result2 = Math.exp(x);
        System.out.println(x + "\t" + result1 + "\t" + result2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the x value: ");
        double x =  scanner.nextDouble();
        System.out.println("Enter number of terms: ");
        int n = scanner.nextInt();

        double result = myExp(x, n);
        double result2 = newExp(x, n);
        System.out.println("Our myExp result is: " + result);
        System.out.println("Our newExp result is: " + result2);
//        System.out.println("Third result is: " + Math.exp(x));
        System.out.print("Our check method is: ");
        check(x);

        System.out.println("");
        /**
         * As the value of x increases the difference is bigger.
         */
        System.out.println("As the value of x increases the difference is bigger.");
        x = 0.1;
        while (x <= 100.0) {
//            System.out.println(i);
            check(x);
            x *= 10;
        }
        System.out.println("");

        /**
         * As the value of x decreases the difference is bigger.
         */
        System.out.println("As the value of x decreases the difference is bigger.");
        x = -0.1;
        while (x >= -100.0) {
//            System.out.println(x);
            check(x);
            x *= 10;
        }
    }
}
