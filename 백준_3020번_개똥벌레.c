#include <stdio.h>
#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif


int u[100001], d[100001];

int partition(int arr[], int l, int r) {
	int pivot = arr[l];
	int temp, low, high;
	low = l + 1; high = r;

	while (low <= high) {
		while (pivot >= arr[low] && low <= r) low++;
		while (pivot <= arr[high] && high >= l + 1) high--;

		if (low <= high) {
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
		}
	}

	temp = arr[high]; arr[high] = arr[l]; arr[l] = temp;
	return high;
}

void quick_sort(int arr[], int l, int r) {
	if (l < r) {
		int p = partition(arr, l, r);
		quick_sort(arr, l, p - 1);
		quick_sort(arr, p + 1, r);
	}
}

//           *
// 1 1 1 2 2 2 3 3 3 3 4 4 4 
// target = 3

int bsearch(int arr[], int n, int target) {
	int l, r, m;
	l = 0; r = n - 1;
	int ans = 0;

	while (l <= r) {
		m = l + (r - l) / 2;

		if (arr[m] < target) {
			ans = m + 1;
			l = m + 1;
		}
		else {
			r = m - 1;
		}
	}

	return ans;
}

int main() {
	int n, h, i;

	scanf("%d %d", &n, &h);

	n /= 2;

	for (i = 0; i < n; i++) {
		scanf("%d", &d[i]);
		scanf("%d", &u[i]);
	}

	quick_sort(d, 0, n - 1);
	quick_sort(u, 0, n - 1);

	int min_collision = n * 2, count = 0;

	for (i = 1; i <= h; i++) {
		int num_collisions; // xxx

		// d = [2, 2, 3, 3, 4, 4, 4]
		// index = 0
		// target = 1
		// bsearch -> 1
		int c1 = n - bsearch(d, n, i); // i보다 작은 값중에서 가장 오른쪽에 있는 index
		int c2 = n - bsearch(u, n, h - i + 1);

		num_collisions = c1 + c2;

		if (min_collision > num_collisions) {
			min_collision = num_collisions;
			count = 1;
		}
		else if (min_collision == num_collisions) {
			count++;
		}
	}

	printf("%d %d\n", min_collision, count);
	return 0;
}


/*
int S1[555555];
int S2[555555];
int S3[555555];

void Firefly(int n, int m) {
	for (int i = 0; i <= n / 2 - 1; ++i) {
		int s1, s2;
		scanf("%d %d", &s1, &s2);
		S1[s1]++;
		S2[s2]++;
	}
	for (int i = m; i > 0; --i) {
		S1[i] += S1[i + 1];
		S2[i] += S2[i + 1];
	}
	int min = 444444;
	for (int i = 1; i <= m; ++i) {
		S3[i] = S1[i] + S2[m - i + 1];
		if (S3[i] < min)
			min = S3[i];
	}
	int res = 0;
	for (int i = 1; i <= m; ++i) {
		if (S3[i] == min)
			res++;
	}
	printf("%d %d \n", min, res);
	return 0;
}

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	Firefly(n, m);
}*/