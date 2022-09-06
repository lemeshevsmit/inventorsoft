import java.util.ArrayList;
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
     * this is main method (start of application)
     *
     * @param args
     */
    public static void main(String[] args) {
//        ArrayList<String> strArr = inputMatrix();
//        //displayMatrix(strArr);
//        System.out.println("Max rectangle sub-matrix with value 1: "
//                + matrixChallenge(strArr));


        System.out.println(matrixChallenge(
                new String[]{"1111", "0110", "1110", "1111", "0111"}));
    }

//    /**
//     * this method display matrix in console
//     *
//     * @param strArr ArrayList of String input value
//     */
//    private static void displayMatrix(ArrayList<String> strArr) {
//        System.out.println("Input matrix:");
//        for (String str : strArr) {
//            System.out.println("\t" + str);
//        }
//    }
//
//    /**
//     * this method check input matrix parameter and values
//     * If all values correct create matrix else throw exception
//     *
//     * @return ArrayList<String> with input values
//     * @throws InputMismatchException incorrect input parameters
//     */
//    private static ArrayList<String> inputMatrix() {
//        Scanner sc = new Scanner(System.in);
//        ArrayList<String> result = new ArrayList<>();
//        System.out.print("Please, input size of matrix: ");
//        try {
//            int size = sc.nextInt();
//            if (size <= 0) throw new InputMismatchException();
//            System.out.println("Please, input matrix values: ");
//            for (int i = 0; i < size; i++) {
//                String inputValue = sc.next();
//                if (inputValue.replaceAll("[^0-1]", "").length() != size) {
//                    throw new InputMismatchException();
//                }
//                result.add(inputValue);
//            }
//        } catch (InputMismatchException e) {
//            System.err.println("Please, input correct value!");
//        }
//        sc.close();
//        return result;
//    }

    static int matrixChallenge(String[] strArr) {
        int size = strArr.length;
        if (size == 1) return Integer.parseInt(strArr[0]) == 1 ? 1 : 0;
        int[][] matrix = new int[size][strArr[0].length()];
        for (int i = 0; i < size; i++) {
            String[] row = strArr[i].split("");
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = Integer.parseInt(row[j]);
        }
        return findMaxRectangle(matrix);
    }

    private static int findMaxRectangle(int[][] matrix) {
        int result = 0;
        return result;
    }
}
