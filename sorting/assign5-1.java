/*
Author: Mehir Wolde
Date generated: 18-09-2020
Date edited: 21-09-2020
README: Code implements both insertionsort, mergesort (code taken from princeton), a random array creator and method which copies an array
Code is used in main with a randomly created array which then is copied. The arrays are then sorted using either mergesort or insertionsort, 
and execution time is calculated.

*/

package labb2;
import java.util.Scanner;
import java.util.Random;

public class assign5 {
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];     //skapa ny array för att sätta ihop delarrayer
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if (i >= a.length)      //om alla tal från delarray a har lagts in lägg in från b
                c[k] = b[j++];
            else if (j >= b.length) //om alla tal från delarray b har lagts in lägg in från a
                c[k] = a[i++];
            else if (a[i] <= b[j])  //resten jämför om a är mindre än b eller vice versa
                c[k] = a[i++];
            else
                c[k] = b[j++];
        }
        return c;
    }

    public static int[] mergesort(int[] input) {
        int N = input.length;
        if (N <= 1) return input;       //om den delat tills man fått array med endast ett element returnera
        int[] a = new int[N/2];         //skapa 2 delarrayer
        int[] b = new int[N - N/2];
        for (int i = 0; i < a.length; i++)      //lägg in alla element i de 2 arrayerna
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return merge(mergesort(a), mergesort(b));       //rekursivt anrop till mergesort med merge 
    }

    public static void insertionSort(int[] a) {
        int t;
        for (int i = 1; i < a.length; i++) {        
            for (int j = i; j > 0 ; j--) {      //kollar alla tal till vänster om i pekare
                if (a[j - 1] > a[j]) {          //om talet till vänster är större byt plats
                    t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }
            }
        }

    }

    public static int[] randomArray(int n)   {
        Random r = new Random();   //skapa instans av klass random
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n+1);      //lägg ett slumpat tal upp till arraylängd
        }
        return a;
    }

    public static int[] copy(int[] a) {     //kopierar en array till en ny array
        int[] c = new int[a.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i];
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array to sort: ");        //bestäm storlek av array
        int n = in.nextInt();
        int[] a = randomArray(n);
        int[] b = copy(a);
        long startTime2 = System.nanoTime();    //hämta starttid
        mergesort(b);
        long elapsedTime2 = (System.nanoTime() - startTime2)/1000000;       //beräkna execution time
        System.out.println("Time taken to mergesort: " + elapsedTime2 + " milliseconds");
        long startTime1 = System.nanoTime();
        insertionSort(a);                              
        long elapsedTime1 = (System.nanoTime() - startTime1)/1000000;
        System.out.println("Time taken for insertionsort: " + elapsedTime1 + " milliseconds");
        
    }

}
