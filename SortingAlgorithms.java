package com.zimenina.julia;

import java.util.Arrays;
import java.util.Scanner;

public class SortingAlgorithms {

    // Class variables
    public static int compare; //variable indicating the number of comparisons
    public static int transposition; //variable indicating the number of permutations

    // Method to run the program
    public void startSort() {
        Scanner scanner = new Scanner(System.in);

        // Variables taking temporary values
        double startWork = 0; //start of the algorithm
        double endWork = 0; // the end of the algorithm

        System.out.println("N takes one of three values: 100, 1000, 10 000.");
        System.out.println("Enter value N: ");
        int n = scanner.nextInt();

        // Initializing and filling the array
        int[] arraySort = new int[n];
        for (int i = 0; i < n; i++)
            arraySort[i] = (int) (Math.random() * 1001);

        int[][] arraySort1 = new int[3][n];
        for (int i = 0; i < 3; i++)
            System.arraycopy(arraySort, 0, arraySort1[i], 0, n); //copying an array

        //Counting the number of permutations, comparisons and running time of the algorithm
        compare = 0;
        transposition = 0;
        startWork = System.nanoTime();
        countingSort(arraySort1[0]);
        endWork = System.nanoTime();
        System.out.println("Algorithm CountingSort");
        System.out.println("Number of comparisons: " + compare);
        System.out.println("Number of permutations: " + transposition);
        System.out.println("Algorithm running time:" + ((endWork - startWork) / 1000000) + "\n");


        compare = 0;
        transposition = 0;
        startWork = System.nanoTime();
        bubbleSort(arraySort1[1]);
        endWork = System.nanoTime();
        System.out.println("Algorithm BubbleSort");
        System.out.println("Number of comparisons: " + compare);
        System.out.println("Number of permutations: " + transposition);
        System.out.println("Algorithm running time:" + ((endWork - startWork) / 1000000) + "\n");

        compare = 0;
        transposition = 0;
        startWork = System.nanoTime();
        quickSort(arraySort1[0], 0, arraySort.length - 1);
        endWork = System.nanoTime();
        System.out.println("Algorithm QuickSort");
        System.out.println("Number of comparisons: " + compare);
        System.out.println("Number of permutations: " + transposition);
        System.out.println("Algorithm running time:" + ((endWork - startWork) / 1000000) + "\n");
    }

    //Counting Sort
    private static void countingSort(int[] arraySort) {
        int maxMasEl = arraySort[0];
        for (int i = 1; i < arraySort.length; i++) {
            if (arraySort[i] > maxMasEl)
                maxMasEl = arraySort[i];
        }

        int[] countArray = new int[maxMasEl + 1];
        Arrays.fill(countArray, 0);

        for (int i = 1; i < arraySort.length; i++) {
            countArray[arraySort[i]]++;
        }

        for (int i = 1; i <= maxMasEl; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] sortArray = new int[arraySort.length];
        for (int i = arraySort.length - 1; i >= 0; i--) {
            sortArray[countArray[arraySort[i]] - 1] = arraySort[i];
            countArray[arraySort[i]]--;
        }
    }

        //Bubble Sort
        private static void bubbleSort(int[] arraySort) {
            int n = arraySort.length;

            for (int i = 0; i < n - 1; i++)
            {

                for (int j = 0; j < n - i - 1; j++)
                {
                    if (arraySort[j] > arraySort[j + 1])
                    {
                        int temp = arraySort[j];
                        arraySort[j] = arraySort[j + 1];
                        arraySort[j + 1] = temp;
                        transposition++;
                    }
                    compare++;
                }
            }
        }
        private static int partition(int [] arraySort, int low, int high) {
            int pivot = arraySort[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (arraySort[j] < pivot) {
                    transposition++;
                    i++;
                    int temp = arraySort[i];
                    arraySort[i] = arraySort[j];
                    arraySort[j] = temp;
                }
                compare++;
            }
            int temp = arraySort[i + 1];
            arraySort[i + 1] = arraySort[high];
            arraySort[high] = temp;

            return i + 1;
        }

        //Quick Sort
        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }
    }


