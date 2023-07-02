import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a matrix multiplication method.");
            System.out.println("1. Multiplication");
            System.out.println("2. Line Multiplication");
            System.out.println("3. Block Multiplication");
            System.out.print("Selection? "); 
            int n = scanner.nextInt();
            if (n == 0) {
                return;
            }

            System.out.print("Dimensions? line=cols:");
            int size = scanner.nextInt();

            long timeTaken = -1;
            switch(n) {
                case 1:
                    timeTaken = OnMult(size);
                    break;
                case 2:
                    timeTaken = OnMultLine(size);
                    break;
                case 3:
                    System.out.print("Block Size? ");
                    int blockSize = scanner.nextInt();
                    timeTaken = OnMultBlock(size, blockSize);
                    break;
                    // onMultBlock(size, blockSize);
                    
                default:
                    System.out.println("Invalid selection.");
            }
            
            System.out.println("Time taken: " + timeTaken + "ms");
            System.out.println();
        }
    }
    
    public static long OnMult(int m_size) {
        // Matrix generation
        double[][] m_a = new double[m_size][m_size];
        double[][] m_b = new double[m_size][m_size];
        double[][] m_c = new double[m_size][m_size];

        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < m_size; j++) {
                m_a[i][j] = 1D;        
            }
        }
        
        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < m_size; j++) {
                m_b[i][j] = (double)(i + 1);
            }
        }

        long start = System.currentTimeMillis();

        for(int i=0; i<m_size; i++) {
            for(int j=0; j<m_size; j++) {
                double temp = 0;
			    for(int k=0; k<m_size; k++) {	
                    m_c[i][j] += m_a[i][k] * m_b[k][j];
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("\nResult Matrix:\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(m_c[0][i] + " ");
        }
        System.out.print('\n');

        return end - start;
    }

    public static long OnMultLine(int m_size) {
        // Matrix generation
        double[][] m_a = new double[m_size][m_size];
        double[][] m_b = new double[m_size][m_size];
        double[][] m_c = new double[m_size][m_size];

        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < m_size; j++) {
                m_a[i][j] = 1D;        
            }
        }
        
        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < m_size; j++) {
                m_b[i][j] = (double)(i + 1);
            }
        }

        long start = System.currentTimeMillis();

        for(int i=0; i<m_size; i++) {
            for(int j=0; j<m_size; j++) {
			    for(int k=0; k<m_size; k++) {
                    m_c[i][k] += m_a[i][j] * m_b[j][k];
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("\nResult Matrix:\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(m_c[0][i] + " ");
        }
        System.out.print('\n');


        return end - start;
    }

    public static long OnMultBlock(int m_size, int bkSize) {
        double[][] m_a = new double[m_size][m_size];
        double[][] m_b = new double[m_size][m_size];
        double[][] m_c = new double[m_size][m_size];

        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < m_size; j++) {
                m_a[i][j] = 1D;        
            }
        }
        
        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < m_size; j++) {
                m_b[i][j] = (double)(i + 1);
            }
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < m_size; i += bkSize) {
            for (int j = 0; j < m_size; j += bkSize) {
                for (int k = 0; k < m_size; k += bkSize) {
                    for (int a = 0; a < bkSize; a++) {
                        for (int b = 0; b < bkSize; b++) {
                            for (int c = 0; c < bkSize; c++) {
                                m_c[a + i][c + k] += m_a[a + i][b + j] * m_b[b + j][c + k];
                            }
                        }
                    }
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("\nResult Matrix:\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(m_c[0][i] + " ");
        }
        System.out.print('\n');

        return end - start;
    }
}