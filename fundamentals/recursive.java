/*
Author: Mehir Wolde
Date generated: 01-09-2020
Date edited: 09-09-2020
Implements a recursive method which reverses a string inputed from the user
*/

package algolabb1;
import java.util.Scanner;

public class recursive {

    public static void rec(String s)
    {
       if(s != "\n")        //körs endast om sträng inte är enter
       {
           if(s.length() == 0)      //returnerar till föregående anrop ifall strängen är tom
           {
               return;
           }
           rec(s.substring(1));     //rekursivt anrop med hela sträng förutom första char
       }
       System.out.print(s.substring(0,1));  
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String f = in.nextLine();
        rec(f);  
    }
}