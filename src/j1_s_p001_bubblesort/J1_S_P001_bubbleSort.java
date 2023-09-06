/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1_s_p001_bubblesort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author MSII
 */
public class J1_S_P001_bubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the number of elements in the array
        int numElements = getUserInput(scanner, "Enter the number of elements in the array: ");

        // Step 2: Generate random integers and create the array
        int[] array = generateRandomArray(numElements);

        // Step 3: Display the unsorted array
        System.out.println("Unsorted Array:");
        displayArray(array);

        // Step 4: Sort the array using the bubble sort algorithm
        bubbleSort(array);

        // Step 5: Display the sorted array
        System.out.println("\nSorted Array:");
        displayArray(array);

        scanner.close();
    }

    // Function to get user input with error handling
    public static int getUserInput(Scanner scanner, String prompt) {
        int userInput = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(prompt);
                userInput = scanner.nextInt();

                if (userInput <= 0) {
                    System.out.println("Please enter a positive number.");
                } else {
                    validInput = true;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        } while (!validInput);

        return userInput;
    }

    // Step 2: Generate random integers less than 100 and create the array
    public static int[] generateRandomArray(int numElements) {
        int[] array = new int[numElements];
        Random random = new Random();

        for (int i = 0; i < numElements; i++) {
            array[i] = random.nextInt(100); // Generate random integers less than 100
        }

        return array;
    }

    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Display the contents of an array
    public static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
