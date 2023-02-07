package triangular_series;
import java.util.Scanner;
import java.util.concurrent.*;

public class Triangular_series {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Pleses Enter a positive number: ");
        //to get the user input
        int n = input.nextInt();
        //to create 4 thread
        ExecutorService executor = Executors.newFixedThreadPool(4);
        //calculate the start time
        long StartTime = System.currentTimeMillis();

        // for loop to execute the thread 
        for (int i = 0; i < 4; i++) {
            executor.execute(new TriangularNumSeries(i, n));
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
        }
        //calculate the end time
        long EndTime = System.currentTimeMillis();
        //calculate the time elapsed
        System.out.println("The Time elapsed is: " + (EndTime - StartTime) + " milliseconds.");

    }
}

class TriangularNumSeries implements Runnable {

    int Thread_Rank;
    int n;

    TriangularNumSeries(int Thread_Rank, int n) {
        this.n = n;
        this.Thread_Rank = Thread_Rank;
    }

    @Override
    public void run() {
        int local_m = n / 4;
        int my_first = local_m * Thread_Rank;
        int my_last = my_first + local_m;
        for (int i = my_first; i < my_last; i++) {
            System.out.println("thread: " + Thread_Rank + " the result is " + i * (i + 1) / 2);
        }
    }
}
