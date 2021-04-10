package labb3;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class task4 {
    static int count = 0;       //global statisk variabel som används att räkna index
    
    public static void main(String[] args) throws FileNotFoundException{
        BinarySearchST<String, ArrayList<Integer>> bsst = new BinarySearchST<String, ArrayList<Integer>>(10000);  //skapa symbol tabell med arraylist som lagrar värde/index för varje ord
        Scanner reader = new Scanner(new FileReader("C:\\Users\\emilia\\Documents\\java\\labb3\\write - kopia.txt"));
        Scanner in = new Scanner(System.in);
        while(reader.hasNext())     //läser in så länge det finns en nästa char
        {
            reader.useDelimiter("");        //sätter att scannern läser bokstäver istället för hela ord/strings
            String s = indexWord(reader);   

            if(!bsst.contains(s))           //om det är ett nytt ord skapa en arraylist för ordet och lägg in index
            {
                bsst.put(s, new ArrayList<Integer>());
                bsst.get(s).add(count);
                count += s.length();
            }
            else                        //om ordet finns, lägg in nya index idens arraylist
            {
                bsst.get(s).add(count);
                count+= s.length();
            }
        }
        System.out.println("Enter what word you want to find:");
        String k = in.next().toLowerCase();


        for(int i = 0; i < bsst.get(k).size();i++)
        {
            System.out.println("Index: " + bsst.get(k).get(i));
        }
        reader.close();
        in.close();
    }

    public static String indexWord(Scanner in)
    {
        StringBuilder s = new StringBuilder();
        while(true)
        {
            String a = in.next().toLowerCase();     
            if(!a.equals(" "))      //om det är en bokstav appenda till stringbuilder
            {
                s.append(a);
            }
            else                    //annars öka indexcounter och gå ut
            {
                count++;
                break;
            }
        }
        return s.toString();
    }

}
