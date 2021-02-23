import java.util.Arrays;

import static java.lang.Math.*;

public class Main {
    public static int size;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        System.out.println("size:" + numberOfSteps(1, 5, 0.01));
        System.out.println("Array X: " + Arrays.toString(arrayX(1, 0.01)));
        System.out.println("Y: " + Arrays.toString(arrayY(arrayX(1, 0.01), 1, 0.01, 2.4)));
        System.out.println("minY: " + findMinY(arrayY(arrayX(1, 0.01), 1, 0.01, 2.4)));
        System.out.println("maxY: " + findMaxY(arrayY(arrayX(1, 0.01), 1, 0.01, 2.4)));
        System.out.println("summOfArrayY: " + sumOfArrayY(arrayY(arrayX(1, 0.01), 1, 0.01, 2.4)));
        System.out.println("averageOfArrayY: " + averageOfArrayY(sumOfArrayY(arrayY(arrayX(1, 0.01), 1, 0.01, 2.4))));
//        System.out.println("minX: " + findMinX(arrayX(1, 0.01)));
//        System.out.println("maxX: " + findMaxX(arrayX(1, 0.01)));
    }

    double[] arrayX(int start, double step) {
        double[] arrayX = new double[size + 1];
        for (int i = 0; i < size + 1; i++) {
            arrayX[i] = start + i * step;
        }
        return arrayX;
    }

    public static int numberOfSteps(int start, int end, double step) {
        size = (int) ((end - start) / step);
        return size;
    }

    double[] arrayY(double[] arrayX, int start, double step, double a) {
        double[] y = new double[size + 1];
        for (int i = 0; i < size + 1; i++) {
            arrayX[i] = start + i * step;
            if (arrayX[i] > a) {
                y[i] = arrayX[i] * sqrt(arrayX[i] * a);
            } else if (arrayX[i] == a) {
                y[i] = arrayX[i] * sin(a * arrayX[i]);
            } else if (arrayX[i] < a) {
                y[i] = exp(-a * arrayX[i]) * cos(a * arrayX[i]);
            }
        }
        return y;
    }

    double findMinY(double[] arrY) {
        double minY = arrY[0];
        for (int i = 1; i < size; i++) {
            if (arrY[i] < minY) {
                minY = arrY[i];
            }
        }
        return minY;
    }

    double findMaxY(double[] arrY) {
        double maxY = arrY[0];
        for (int i = 1; i < size + 1; i++) {
            if (arrY[i] > maxY) {
                maxY = arrY[i];
            }
        }
        return maxY;
    }

    double sumOfArrayY(double[] arrY) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arrY[i];
        }
        return sum;
    }

    double averageOfArrayY(double sum) {
        return sum / size;
    }
}

//    double findMinX(double[] arrX) {
//        double minX = arrX[0];
//        for (int i = 1; i < size; i++) {
//            if (arrX[i] < minX) {
//                minX = arrX[i];
//            }
//        }
//        return minX;
//    }
//
//    double findMaxX(double[] arrX) {
//        double maxX = arrX[0];
//        for (int i = 1; i < size + 1; i++) {
//            if (arrX[i] > maxX) {
//                maxX = arrX[i];
//            }
//        }
//        return maxX;
//    }