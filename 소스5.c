#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#pragma warning (disable : 4996)
#define DATASIZE 100000
#define AVRTIME 10

int seq_search(int list[], int n, int key)
{
	int i;
	for (i = 0; i < n; i++)
		if (list[i] == key)
			return i;
	return -1;
}

int binary_search(int list[], int n, int key)
{
	int low, high, middle;
	low = 0;
	high = n - 1;
	while (low <= high) {
		middle = (low + high) / 2;
		if (key == list[middle])
			return middle;
		else if (key > list[middle])
			low = middle + 1;
		else
			high = middle - 1;
	}
	return -1;
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
	clock_t starttime, endtime;
	int arrayOfSearch[DATASIZE];
	double avrTimeSeq[AVRTIME], avrTimeQuick[AVRTIME];
	int key;
	printf("탐색하고자 하는 key값을 입력하세요 : ");
	scanf("%d", &key);

	for (int j = 0; j < AVRTIME; j++) {
		srand(time(NULL));
		for (int i = 0; i < DATASIZE; i++) arrayOfSearch[i] = rand() % DATASIZE;
		starttime = clock();
		seq_search(arrayOfSearch, DATASIZE, key);
		endtime = clock();
		avrTimeSeq[j] = ((double)(endtime - starttime)) / CLOCKS_PER_SEC;

		for (int i = 0; i < DATASIZE; i++) arrayOfSearch[i] = rand() % 10000;
		starttime = clock();
		QuickSort(arrayOfSearch, 0, DATASIZE - 1);
		binary_search(arrayOfSearch, DATASIZE, key);
		endtime = clock();
		avrTimeQuick[j] = ((double)(endtime - starttime)) / CLOCKS_PER_SEC;
	}
	printf("순차탐색 평균 시간은 %f초\n2진탐색의 평균 시간은 %f초", GetAverage(avrTimeSeq, AVRTIME), GetAverage(avrTimeQuick, AVRTIME));
	return 0;
}