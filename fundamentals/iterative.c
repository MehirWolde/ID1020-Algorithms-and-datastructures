/*
Date genrated: 09-09-2020
Date edited: 09-09-202
Implements an iterative function which reverses a string read from the
user input
*/


#include <Stdio.h>
void reviter()
{
	int i,length = 0, max = 20;   //skapa loop variabel, max längd och längd för input
	char s[max];
	
	printf("%s, \n", "Enter a string with a maximum length of 20 characters, if input has more only the first 10 will be reversed");
	while((s[i] = getchar()) != '\n' && length < max)		//hämta input tills det blir enter och räkna storlek
	{	
		length++;
		i++;
	}
	
	for(i = length-1; i >= 0; i--)		
	{
		putchar(s[i]);
	}
}

int main()
{
	reviter();
}
