/* Name: Mehir Wolde
Generated: 26-08-2020
Updated: 09-09-2020
This code uses a recursive funtction to read print characters from stdin in reverse order
*/

#include <stdio.h>

void revrec()
{
	char rec;						//skapa en char som läses från standard input
	if((rec = getchar()) != '\n')   //checkar om input är enter
	{
		revrec();					//recursivt anrop av metod
		putchar(rec);				//printar input i nuvarande anrop
	}
}

int main()
{
  printf("%s, \n", "Enter a string to be reversed");
  revrec();
  return 0;
}
