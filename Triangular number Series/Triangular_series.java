package triangular_series;

import java.util.Scanner;

public class Triangular_series {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;
        do {
            System.out.println("Enter positive num: ");
            num = input.nextInt();
        } while (num <= 0);
        long startTime = System.currentTimeMillis();
        triangular_series(num);
        long endTime = System.currentTimeMillis();
        System.out.println("time " + (endTime - startTime) + " millisecond");

    }

    static void triangular_series(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("itration " + i + " the result is " + i * (i + 1) / 2);
        }
    }
}
