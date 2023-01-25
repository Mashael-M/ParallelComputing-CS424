package triangular;

import java.util.Scanner;
import java.util.concurrent.*;

public class Triangular {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("   Triangular number Series with java using 4 thread   ");
            System.out.print("- Pleses Enter a positive number: ");
            //to get the user input
            int n = input.nextInt(); 
 
            
            //to create 4 thread
            ExecutorService executor = Executors.newFixedThreadPool(4); 
            //calculate the start time
            long StartTime = System.currentTimeMillis();

            // for loop to execute the thread 
            for (int Thread_Rank = 0; Thread_Rank < 4; Thread_Rank++) {
                executor.execute(new TriangularNumSeries(Thread_Rank, n)); 
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

}

//                              THe Triangular number Series Class
class TriangularNumSeries implements Runnable {
    int Thread_Rank;
    int n;

    TriangularNumSeries(int Thread_Rank, int n) {
        this.n = n;
        this.Thread_Rank = Thread_Rank;
    }

    @Override
    public void run() {
        for (int i = Thread_Rank; i < n; i += 4) {
            // To print thread rank + iteration + number of dots in the triangular using the fourmela
            System.out.printf("(Thread:" + Thread_Rank + ") (Itration:" + i + ") (Dots:" + (i * (i + 1)) / 2 + ")\n");
        }
    }
}
