package magic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/*
 * Author: Shruti Rabara
 * Date: 10/16/19
 * Course: ITSC 1213 Intro to Computer Science II
 * Description: Program that reads in numbers from a text file and detect if those numbers
 * are a "magic square". A set of integers is a magic square if the n numbers in all rows, all columns, and on both diagonals sum to the same constant and
each number only occurs once in the magic square.
 */

public class MagicAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scann = new Scanner(System.in);
            System.out.println("Enter a file name: ");
            String filename = scann.next();
            File f = new File(filename);
            Scanner scan = new Scanner(f);
            ArrayList<Integer> nums = new ArrayList<>();

            while (scan.hasNextInt()) {
                nums.add(scan.nextInt());
            }

            int size = nums.size();
            int index = (int) Math.sqrt(size);
            int[][] square = new int[index][index];

            int k = 0;
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < index; j++) {
                    square[i][j] = nums.get(k);
                    k++;
                }
            }

            System.out.print("The combination of numbers " + nums);
            int constant = 0;
            for (int i = 0; i < index; i++) {
                constant += square[0][i];
            }
            int constant3 = 0;
            int constant2 = 0;

            for (int i = 0; i < index; i++) {

                for (int j = 0; j < index; j++) {
                    constant2 += square[i][j];
                    constant3 += square[j][i];
                }

                if (constant2 != constant) {
                    System.out.println("not a magic square");
                }

                if (constant3 != constant) {
                    System.out.println("not a magic square");
                }
                constant2 = 0;
                constant3 = 0;
            }

            for (int i = 0; i < index; i++) {
                constant2 += square[i][i];
                constant3 += square[i][index - i - 1];
            }

            if (constant2 != constant) {
                System.out.println("not a magic square");
            }
            if (constant3 != constant) {
                System.out.println("not a magic square");
            }

            int num2 = 0;
            for (int i = 0; i < nums.size(); i++) {
                num2 = nums.get(0);
                nums.remove(0);
                if (nums.contains(num2)) {
                    System.out.println("not a magic sqare");
                }
            }
            System.out.println("is a magic square of order " + index + ".The magic square constant is " + constant);

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
        }
    }
}
