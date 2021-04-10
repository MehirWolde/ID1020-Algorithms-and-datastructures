/*
Author: Mehir Wolde
Date generated: 15-09-2020
Date edited: 21-09-2020
README: Code implements the sorting method insertion sort to sort an array of ints, the method will count amount of swaps performed when sorting the aray. Uses a seperate method "inversionCount" to count and print amount of inversions in array before its sorted
Code is used in main method by allowing the user to define the size the input and then input the elements to be sorted
*/

package algolabb2;

import java.util.Scanner;

public class assignment1_2_3 
{
    public static void sort(int[] a)
    {
        System.out.println("This is your array: ");
        print(a);
        System.out.println("Starting sorting:");
        int c = 0;
        int t;  
        for(int i = 1; i < a.length; i++)       //picks 1 element
        {
            for(int j = i; j > 0; j--)      //goes through every element to the left of it
            {
                if(a[j-1] > a[j])       //if current element is smaller than element to the left, swap
                {
                    t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                    print(a);   
                    c++;        //increment swapcounter if a swap occurs
                }
            }
        }
        System.out.println("The amount of swaps performed: " + c);
    }

    public static void inversionCount(int[] a)      //function which counts and shows inversions in input array
    {
        int inversions = 0;
        for(int i = 0; i < a.length - 1; i++)
        {
            for(int j = i+1; j < a.length; j++)
            {
                if(a[i] > a[j])     //if there exists an inverison print out
                {
                    System.out.println("[" + i + "," + a[i] + "] <--> [" + j + "," + a[j] + "]");
                    inversions++;
                }
            }
        }
        System.out.println("Amount of inversions: " + inversions);
    }

    public static void print(int[] n)
    {
        for(int i = 0; i < n.length; i++)
        {
            if(i == n.length -1)
            {
                System.out.print("[" + n[i] + "]");
                break;
            }
            System.out.print("[" + n[i] + "] , ");
        }  
        System.out.println();
    }

    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How many values do you want to enter:");
        int f = in.nextInt();
        System.out.println("Enter what values you want to sort:");
        int[] a = new int[f];
        for(int i = 0; i < f; i++)
        {
            a[i] = in.nextInt();
        }
        inversionCount(a);
        sort(a);
    } 
}