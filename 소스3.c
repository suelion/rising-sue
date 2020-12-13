#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#pragma warning (disable : 4996)
#define DATASIZE 10000
#define AVRTIME 10

void BubbleSort(int a[], int n)
{
	int i, scan, temp;
	for (scan = 0; scan < n - 1; scan++)
	{
		for (i = 0; i < n - 1; i++)
		{
			if (a[i] > a[i + 1])
			{
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}
	}
}

int divide(int array[], int low, int high) {
	int wall, current, pivot, temp;
	pivot = array[high];
	wall = low;
	for (current = low; current < high; current++)
		if (array[current] <= pivot) {
			temp = array[current];
			array[current] = array[wall];
			array[wall] = temp;
			wall++;
		}
	temp = array[wall];
	array[wall] = array[high];
	array[high] = temp;

	return wall;
}

void QuickSort(int array[], int low, int high) {
	int p;
	if (low < high) {
		p = divide(array, low, high);
		QuickSort(array, low, p - 1);
		QuickSort(array, p + 1, high);
	}
}

double GetAverage(double array[], int size) {
	double sum = 0;
	for (int i = 0; i < size; i++) {
		sum += array[i];
	}
	return sum / size;
}


int main(void) {
	clock_t startTime, endTime;
	int numsTobeSorted[DATASIZE];
	double avrTimeBubble[AVRTIME], avrTimeQuick[AVRTIME];

	for (int j = 0; j < AVRTIME; j++) {
		srand(time(NULL));
		for (int i = 0; i < DATASIZE; i++) numsTobeSorted[i] = rand() % DATASIZE;
		startTime = clock();
		BubbleSort(numsTobeSorted, DATASIZE);
		endTime = clock();
		avrTimeBubble[j] = ((double)(endTime - startTime)) / CLOCKS_PER_SEC;

		for (int i = 0; i < DATASIZE; i++) numsTobeSorted[i] = rand() % 10000;
		startTime = clock();
		QuickSort(numsTobeSorted, 0, DATASIZE - 1);
		endTime = clock();
		avrTimeQuick[j] = ((double)(endTime - startTime)) / CLOCKS_PER_SEC;
	}
	printf("bubble 정렬의 평균 시간은 %f초\n quick 정렬의 평균 시간은 %f초", GetAverage(avrTimeBubble, AVRTIME), GetAverage(avrTimeQuick, AVRTIME));
	return 0;
}