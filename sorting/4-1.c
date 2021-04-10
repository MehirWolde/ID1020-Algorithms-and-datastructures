/*
Author: Mehir Wolde
Date generated: 15-09-2020
Date edited: 21-09-2020
README: Implements an inplace function which takes an array of integers and sorts it by putting all the negative integers first in the array
Function is used in main by taking a fixed array and the arraysize as arguments
*/

#include <stdio.h>
#include <stdlib.h>

void place_negatives(int a[], int l)
{
	int i,j;						//skapa loopvariabler
	for(i = 0; i < l; i++)			//hitta plats där det inte finns ett negativt tal
	{
		for(j = i+1;j < l;j++)		//hitta negativt tal
		{
			if(a[j] < 0 && a[i] > 0)	
			{
				int t = a[i];	//byt plats på negativt o positivt tal
				a[i] = a[j];
				a[j] = t;
			}
		}
	}
	
	for(i = 0; i < l; i++)		//printa arrayelement
	{
		printf("%d ", a[i]);
	}	
}

int main()
{
	int a[10] = {-1,3,4,-5,2, -11, 203,1112,-12, -54};
	int l = sizeof(a)/sizeof(a[0]);
	place_negatives(a,l);
}
