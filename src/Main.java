public class Main {

    // ЗАВДАННЯ 5: Створити клас з виконавчим методом
    public static void main(String[] args) {
        System.out.println("=== Лабораторна робота №1 ===");

        try {
            // ЗАВДАННЯ №1: Визначити C5, C7, C11
            int studentNumber = 10;
            int C5 = studentNumber % 5;   // C5 = 0
            int C7 = studentNumber % 7;   // C7 = 3
            int C11 = studentNumber % 11; // C11 = 10

            System.out.println("Порядковий номер: " + studentNumber);
            System.out.println("C5 = " + C5 + " (C = a * B) Дія з матрицею(ями)");
            System.out.println("C7 = " + C7 + " (тип int) Тип елементів матриці");
            System.out.println("C11 = " + C11 + " (середнє значення) Дія з матрицею С");
            System.out.println();

            int rows = 3;
            int cols = 4;
            int constant = 5; // константа a для множ.

            // ЗАВДАННЯ №2 + №3: Створення матриці B з типом int
            int[][] matrixB = new int[rows][cols];

            // заповнення матриці B
            int value = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixB[i][j] = value;
                    value++;
                }
            }

            System.out.println("Матриця B:");
            printMatrix(matrixB);

            // ЗАВДАННЯ №2: Перша дія - C = a * B (множення на константу)
            int[][] matrixC = multiplyByConstant(matrixB, constant);

            System.out.println("РЕЗУЛЬТАТ ПЕРШОЇ ДІЇ:");
            System.out.println("Матриця C = " + constant + " * B:");
            printMatrix(matrixC);

            // ЗАВДАННЯ №4: Друга дія - знай. середнє значення елем.
            double average = calculateAverage(matrixC);

            System.out.println("РЕЗУЛЬТАТ ДРУГОЇ ДІЇ:");
            System.out.println("Середнє значення елементів матриці C: " + average);

        } catch (Exception e) {
            System.out.println("ПОМИЛКА: " + e.getMessage());
        }
    }

    // метод для множ. на константу
    public static int[][] multiplyByConstant(int[][] matrix, int constant) {
        if (matrix == null) {
            throw new IllegalArgumentException("Матриця не може бути null");
        }

        int rows = matrix.length;
        if (rows == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою");
        }

        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (matrix[i] == null) {
                throw new IllegalArgumentException("Рядок матриці не може бути null");
            }
            if (matrix[i].length != cols) {
                throw new IllegalArgumentException("Всі рядки повинні мати однакову довжину");
            }

            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        return result;
    }

    // метод обчис. середнього значення
    public static double calculateAverage(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Матриця не може бути null");
        }

        if (matrix.length == 0) {
            throw new IllegalArgumentException("Матриця не може бути порожньою");
        }

        int sum = 0;
        int totalElements = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) {
                throw new IllegalArgumentException("Рядок матриці не може бути null");
            }

            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                totalElements++;
            }
        }

        if (totalElements == 0) {
            throw new IllegalArgumentException("Матриця не містить елементів");
        }

        return (double) sum / totalElements;
    }

    // вивидення матриці
    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Матриця null");
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}