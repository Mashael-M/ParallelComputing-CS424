#include<mpi.h>
#include<string.h>
#include<iostream>

int main()
{
    int rank;
    int comm_size;
    int n, result;
    MPI_Init(NULL, NULL);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &comm_size);

    if (rank == 0) {
        printf("Enter number (n):  ");
        fflush(stdout);
        scanf_s("%d", &n);
    }

    MPI_Bcast(&n, 1, MPI_INT, 0, MPI_COMM_WORLD);
    double local_start, local_finish, local_elapsed, elapsed;
    MPI_Barrier(MPI_COMM_WORLD);
    local_start = MPI_Wtime();

    int local_m = n / comm_size;
    int first = local_m * rank;
    int last = local_m + first;
    for (int i = first; i < last; i++) {
        result = i * (i + 1) / 2;
        printf(" from Process %d the result is : %d  \n", rank, result);
    }
    local_finish = MPI_Wtime();
    local_elapsed = local_finish - local_start;

    MPI_Reduce(&local_elapsed, &elapsed, 1, MPI_DOUBLE, MPI_MAX, 0, MPI_COMM_WORLD);
    fflush(stdout);
    if (rank == 0) {
        printf(" Elapsed time: %f seconds\n", elapsed);
    }


    MPI_Finalize();


}