#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif
#include <stdlib.h>
#include <math.h>
#include <stdio.h>



void rep(int n) {
	

	char arr[16];

	if (n == 0);

	else {
		for (int i = 0; i < pow(2, n); i++) {
			int m = i;
			for (int j = 0; j < n; j++) {
				

				if (m % 2 == 0){
					arr[j] = 'a';
				}
				else {
					arr[j] = 'b';
				}
				m = m / 2;
		}

			for (int j = n - 1; j > -1; j--) {
				printf("%c", arr[j]);
			}
			printf("\n");

	}
		
	}
}

int main() {
	int n;
	printf("문자열의 길이를 입력하여라(단, 16이하) : ");
	scanf("%d", &n);

	rep(n);

	return 0;
}


/*
#include <stdio.h>
#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

int n;
char str[17];

void fill(int i) {
	if (i == n) {
		str[i] = '\0';
		printf("%s\n", str);
		return;
	}
	str[i] = 'a';
	fill(i + 1);

	str[i] = 'b';
	fill(i + 1);
}

int main() {
	printf("16이하의 문자열의 길이 n을 입력하세요 : ");
	scanf("%d", &n);
	fill(0);
	return 0;
}
*/