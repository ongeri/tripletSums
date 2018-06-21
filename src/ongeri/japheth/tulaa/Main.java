package ongeri.japheth.tulaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of distinct integers and a sum value find count of triplets with sum less than the given sum value
 */
public class Main {

    public static void main(String[] args) {
        int lengthOfArray = -1;
        Scanner sc = new Scanner(System.in);
        do {//This do while loop enables re-taking of user input in case it was invalid
            try {
                lengthOfArray = sc.nextInt();
            } catch (Exception e) {//Catch cases where user attempts to enter other characters instead of integer
                System.out.println("ERROR " + e.getMessage());
                sc = new Scanner(System.in);//Re-initialize scanner that may have crashed due to previous error
            }
            if (lengthOfArray < 1) {
                System.out.println("Enter a valid integer greater than 0");
            }
        } while (lengthOfArray < 1);
        System.out.println("Enter the " + lengthOfArray + " distinct numbers in the array");

        List<Integer> distinctValues = new ArrayList<>();
        for (int i = 0; i < lengthOfArray; i++) {
            int enteredValueIndex = -1;
            do {
                System.out.println("Enter number #" + i + 1);
                int number = sc.nextInt();
                //Check that the entered name exists in list of distinctValues or else repeat until a valid name is entered
                enteredValueIndex = distinctValues.indexOf(number);
                if (enteredValueIndex >= 0) {
                    System.out.println("The number " + number + " has already been entered, enter a different value");
                }
            } while (enteredValueIndex >= 0);
        }

        System.out.println("Now enter the sum value");
        int sumValue = -1;
        do {
            try {
                sumValue = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR " + e.getMessage());
                sc = new Scanner(System.in);
            }
            if (sumValue < 1) {
                System.out.println("Enter a valid integer greater than 0");
            }
        } while (sumValue < 1);
    }
}
