package pl.sda.javawwa31.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class Runner {

    public static void main(String[] args) {
        //int[][] mediumMatrix = create2DimMatrix(1000, 1000, 0, 6);
        int[][] bigMatrix = create2DimMatrix(10000, 10000, 0, 2);
        //int[][] hugeMatrix = create2DimMatrix(100000, 100000, 0, 3);

        //singleThread(bigMatrix);    //42ms, sum = 50007810
        multipleThreads(bigMatrix, 4);  //26ms, 4*125*10^5
        //multipleThreads(bigMatrix, 8);  //30ms
        //multipleThreads(bigMatrix, 12); //34ms

    }

    public static int[][] create2DimMatrix(int sizeX, int sizeY, int min, int max) {
        int[][] matrix = new int[sizeX][sizeY];

        for(int x = 0; x < sizeX; x++) {
            for(int y = 0; y < sizeY; y++) {
                matrix[x][y] = ThreadLocalRandom.current().nextInt(min, max);   //max is exclusive
            }
        }

        return matrix;
    }

    public static long sumMatrixSingleThread(int[][] matrix) {
        int sizeX = matrix.length;
        int sizeY = matrix[0].length;

        long sum = 0;

        for(int x = 0; x < sizeX; x++) {
            for(int y = 0; y < sizeY; y++) {
                sum += matrix[x][y];
            }
        }

        return sum;
    }

    public static void singleThread(int[][] matrix) {
        Instant start = Instant.now();
        long sum = sumMatrixSingleThread(matrix);
        Instant end = Instant.now();

        System.out.printf("Zsumowano macierz jednowatkowo w czasie %sms - suma elementow macierzy wynosi %d\n",
                Duration.between(start, end).toMillis(), sum);
    }

    public static void multipleThreads(int[][] matrix, int noOfThreads) {
        int sizeX = matrix.length;
        int partSizeX = sizeX/noOfThreads;

        MatrixCalcThread[] mcts = new MatrixCalcThread[noOfThreads];

        //0...partSizeX
        //partSizeX...2*partSizeX
        //2*partSizeX...3*partSizeX
        //3*partSizeX...4*partSizeX
        for(int i = 0; i < noOfThreads; i++) {
            mcts[i] = new MatrixCalcThread(matrix, i * partSizeX, (i+1) * partSizeX, "Thread #" + (i+1));
        }

        Instant start = Instant.now();

        for(MatrixCalcThread mct : mcts)
            mct.start();

        Instant end = Instant.now();

        long finalSum = 0;
        for(MatrixCalcThread mct : mcts)
            finalSum += mct.getCalcSum();

        /*System.out.printf("Zsumowano macierz przy pomocy %d watkow w czasie %sms - suma elementow macierzy wynosi %d\n",
                noOfThreads, Duration.between(start, end).toMillis(), finalSum);*/
    }

}
