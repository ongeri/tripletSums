package ongeri.japheth.tulaa;

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
    }
}
