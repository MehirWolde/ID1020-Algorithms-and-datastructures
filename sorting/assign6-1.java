package labb2; 

import java.util.Random;
import java.util.Scanner;

public class assign6 {
    public static int[] merge(int[] a, int[] b) 
    {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if (i >= a.length)
                c[k] = b[j++];
            else if (j >= b.length)
                c[k] = a[i++];
            else if (a[i] <= b[j])
                c[k] = a[i++];
            else
                c[k] = b[j++];
        }
        return c;
    }

    public static int[] mergesort(int[] input, int cut) {       //lägg till cutoff parameter
        int N = input.length;
        if (N <= cut) return sort(input) ;  //om den har lika med/mindre storlek än cutoff kör insertionsort o returnera
        int[] a = new int[N/2];
        int[] b = new int[N - N/2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];
        return merge(mergesort(a,cut), mergesort(b,cut));
    }
    
    public static int[] sort(int[] a)
    {
        int t;
        for(int i = 1; i < a.length; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(a[j-1] > a[j])
                {
                    t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                }
            }
        }
        return a;
    }

    
    public static int[] copy(int[] a) {     
        int[] c = new int[a.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i];
        }
        return c;
    }

    public static int[] randomArray(int n) {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n+1);
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how long the array should be: ");     //bestäm storlek
        int n = in.nextInt();
        int[] a = randomArray(n);
        System.out.println("Enter cutoff: ");       //bestäm cutoff
        int c = in.nextInt();
        long startTime1 = System.nanoTime();
        mergesort(a,c);
        long elapsedTime1 = System.nanoTime() - startTime1;
        System.out.println("Time taken to mergesort: " + elapsedTime1/1000000 + " milliseconds");
        
    }
}
 