import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This first task in Inventorsoft academy .
 * <p>
 * General Description
 * Implement your task and push to the public git repository.
 * Share the link with the mentor. Create a simple java class that will read
 * data from the console and will print results to console.
 * <p>
 * Task 1 (Maximal Rectangle, Matrix Challenge)
 * Have the function MatrixChallenge(strArr) take the strArr
 * parameter being passed which will be a 2D matrix of 0 and 1's,
 * and determine the area of the largest rectangular sub-matrix that
 * contains all 1's. For example: if strArr is ["10100", "10111", "11111", "10010"]
 * then this looks like the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * For the input above, you can see the bolded 1's create the
 * largest rectangular sub-matrix of size 2x3, so your program
 * should return the area which is 6. You can assume the input will not be empty.
 * Examples
 * Input: ["1011","0011","0111","1111"]
 * Output: 8
 * <p>
 * Input: ["101","111","001"]
 * Output: 3
 *
 * @author Aleksandr Lemeshev
 * @since 05.09.2022
 */
public class Matrix {
    /**
     * This is main method (start of application)
     */
    public static void main(String[] args) {
        System.out.println(matrixChallenge(inputMatrix()));
    }

    /**
     * This method read input values and check this information. If we input incorrect
     * values throw InputMismatchException exception and return null, else return values
     *
     * @return input values to create matrix
     * @throws InputMismatchException incorrect input values
     */
    private static String[] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        String[] inputValues;
        System.out.print("Please, input count of elements: ");
        try {
            int size = sc.nextInt();
            if (size <= 0) throw new InputMismatchException();
            inputValues = new String[size];
            System.out.println("Please, input matrix values: ");
            for (int i = 0; i < size; i++) {
                String inputVal = sc.next();
                if (inputVal.replaceAll("[^0-1]", "").length() != size) {
                    throw new InputMismatchException();
                }
                inputValues[i] = inputVal;
            }
        } catch (InputMismatchException e) {
            System.err.println("Please, input correct value!");
            inputValues = null;
        }
        sc.close();
        return inputValues;
    }

    /**
     * This method create int[][] matrix and call search max count
     * of values 1 in this matrix
     *
     * @param strArr input String array
     * @return max count of values 1 in input matrix
     */
    static int matrixChallenge(String[] strArr) {
        //if input string have only 1 number
        if (strArr.length == 1) return Integer.parseInt(strArr[0]) == 1 ? 1 : 0;
        //create int matrix from string
        int[][] matrix = new int[strArr.length][strArr[0].length()];
        for (int i = 0; i < strArr.length; i++) {
            String[] row = strArr[i].split("");
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = Integer.parseInt(row[j]);
        }
        return findMaxRectangle(matrix);
    }

    /**
     * This method iterate to matrix index and find all rectangle submatrix
     * with 1 in input matrix
     *
     * @param matrix input matrix
     * @return max count of values 1 in input matrix
     */
    private static int findMaxRectangle(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    result = Math.max(result, searchSubMatrix(matrix, i, j));
                }
            }
        }
        return result;
    }

    /**
     * This method find zero in submatrix and cut column index by find position
     *
     * @param matrix input matrix
     * @param i      start of row index
     * @param j      start of col index
     * @return count of values 1 in submatrix
     */
    private static int searchSubMatrix(int[][] matrix, int i, int j) {
        int maxRow = findMaxNumber(matrix, i, j, true);
        int maxCol = findMaxNumber(matrix, i, j, false);
        for (int k = 0; k < maxRow; k++) {
            for (int l = 0; l < maxCol; l++) {
                if (matrix[i + k][j + l] == 0) maxCol = l;
            }
        }
        return maxCol * maxRow;
    }

    /**
     * This method find max count of 1 in row or col by input matrix from start position i and j
     * I use boolean key with value true for iterate in row and value false - in column
     *
     * @param matrix input matrix
     * @param i      start of row index
     * @param j      start of col index
     * @param key    input key(true for row; false for col)
     * @return max number values of 1 in input line or column
     */
    private static int findMaxNumber(int[][] matrix, int i, int j, boolean key) {
        int size = key ? matrix.length : matrix[0].length;
        int start = key ? i : j;
        int max = 0;
        for (int k = start; k < size; k++) {
            if ((key ? matrix[k][j] : matrix[i][k]) == 0) break;
            max++;
        }
        return max;
    }
}
