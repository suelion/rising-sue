#include <stdio.h>
#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

int count = 0;

int BSearch(int ar[], int len, int target) {
	int first = 0;
	int last = len - 1;
	int mid;
	while (first <= last) {
		count += 1;
		mid = (first + last) / 2;

		if (target == ar[mid]) {
			return mid;
		}
		else {
			if (target < ar[mid])
				last = mid - 1;
			else
				first = mid + 1;
		}	
	}
	return -1;
}

int main() {
	int n, m;
	int arr[100001];
	int idx;

	printf("배열의 길이n을 입력하세요 : ");
	scanf("%d", &n);


	for (int i = 0; i < n; i++) { 
		scanf("%d", &arr[i]); 
	}

	

	printf("찾고자 하는 정수 m을 입력하세요 : ");
	scanf("%d", &m);

	idx = BSearch(arr, n, m);
	if (idx == -1)
		printf("-1 \n");
	else
		printf("%d \n", idx);

	printf("%d", count);
}

/*
#include <stdio.h>
#include <stdlib.h>
#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

int arr[10001];
int count = 0;

int BSearchRecur(int ar[], int first, int last, int m) {
	if (first > last) return -1;

	int mid = (first + last) / 2;
	count++;
	if (m == ar[mid])
		return mid;

	if (m < ar[mid])
		return BSearchRecur(ar, first, mid - 1, m);

	return BSearchRecur(ar, mid + 1, last, m);
}

int main() {
	int n, m, i;
	printf("10만 이하의 배열의 길이 n을 입력하세요 : ");
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%d", &arr[i]);

	printf("찾고자 하는 정수 m을 입력하세요 : ");
	scanf("%d", &m);

	printf("%d\n", BSearchRecur(arr, 0, n - 1, m));
	printf("%d\n", count);
	return 0;
}*/