package ongeri.japheth.tulaa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given an array of distinct integers and a sum value find count of triplets with sum less than the given sum value
 */
public class Main {

    public static void main(String[] args) {
        int lengthOfArray = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
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

        Set<Integer> distinctValues = new HashSet<>();
        for (int i = 0; i < lengthOfArray; i++) {
            Integer number = null;
            do {
                try {
                    System.out.println("Enter number #" + (i + 1));
                    number = sc.nextInt();
                    //Check that the entered name exists in list of distinctValues or else repeat until a valid name is entered
                    if (distinctValues.contains(number)) {
                        System.out.println("The number " + number + " has already been entered, enter a different value");
                        number = null;
                    } else {
                        distinctValues.add(number);
                    }
                } catch (Exception e) {
                    System.out.println("ERROR " + e.getMessage());
                    sc = new Scanner(System.in);
                }
            } while (number == null);
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
        TripletSums tripletSums = new TripletSums();
        int count = tripletSums.countTriplets(distinctValues, sumValue);
        System.out.println("The number of triplets is: \t" + count);
    }
}
