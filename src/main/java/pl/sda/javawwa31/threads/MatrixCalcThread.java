package pl.sda.javawwa31.threads;

import java.time.Duration;
import java.time.Instant;

public class MatrixCalcThread extends Thread {

    private final int[][] matrix;
    private int startX, stopX;
    private long calcSum = 0;
    private String name;

    public MatrixCalcThread(final int[][] matrix, int startX, int stopX, String name) {
        this.matrix = matrix;
        this.startX = startX;
        this.stopX = stopX;
        this.name = name;
    }

    @Override
    public void run() {
        Instant start = Instant.now();

        int sizeY = matrix[0].length;

        for(int x = startX; x < stopX; x++) {
            for(int y = 0; y < sizeY; y++) {
                calcSum += matrix[x][y];
            }
        }

        Instant end = Instant.now();

        System.out.printf("Watek %s zakonczyl obliczenia w czasie %sms - suma czesciowa wynosi %d\n",
                name, Duration.between(start, end).toMillis(), calcSum);
    }

    public long getCalcSum() {
        return calcSum;
    }
}
