/*
Author: Mehir Wolde
Date generated: 23-09-2020
Date edited: 25-09-2020
README: This code implements a filter function which reads a text file and removes all non alphabetic
chcracters and writes them to another text file. 
*/

#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

void filter()
{
    FILE* read = fopen("98-0.txt","r");     //öppna fil som vi ska läsa från
    FILE* write = fopen("write.txt","w");   //öppna fil att skriva till
    char r;
    while((r = fgetc(read))!= EOF)      //så länge som hämtad inte är slutet av filen
    {
        if(!isalpha(r))                 //om inte alfabetiskt ersätt med mellanrum
        {
            r = ' ';
        }
            fputc(r,write);             //lägg in inlästa char
    }

    fclose(read);                       //stäng filer
    fclose(write);
    
}

int main()
{
    filter();
}