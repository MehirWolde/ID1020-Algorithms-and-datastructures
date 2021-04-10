/*
Author: Mehir Wolde
Date generated: 31-08-2020
Date edited: 3-9-2020
Stack class and iterator code taken from prinston
A recursive and iterative code which uses stack class to reverse a string input by the user
*/



package algolabb1;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Stack<Item> {
    private Node<Item> first;     // toppen av stacken
    private int n;                // storlek av stack

    // nodhjälp klass
    private static class Node<Item> 
    {
        private Item item;
        private Node<Item> next;
    }

    
    public Stack() {        //initierar en tom stack
        first = null;       
        n = 0;
    }

    
    public boolean isEmpty() {      //kollar om stack är tom
        return first == null;
    }


    public void push(Item item)         //lägger item på stacken
    {   
        Node<Item> oldfirst = first;        //dereference gamla toppen av stacken
        first = new Node<Item>();           //
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
   

    public static void iterative()
    {
        Scanner in = new Scanner(System.in);

        Stack<String> stack = new Stack<String>();      //skapa stack
        String reverse = in.nextLine();                 //läs sträng från standard input
        String letter;
        
        for(int i = 0; i < reverse.length(); i++)
        {
            stack.push(reverse.substring(i, i+1));      //pushar en bokstav i taget på stacken
        }

        for(int i = 0; i < reverse.length(); i++)
        {
            letter = stack.pop();                       //hämtar tecken från stacken genom att poppa
            System.out.print(letter);
        }
    }

    
    public static void main(String[] args) {

       iterative();
       
    }
}


