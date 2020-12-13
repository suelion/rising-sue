#include <math.h>
#include <stdio.h>
#pragma warning (disable : 4996)

int check(int num); //2진수인지 아닌지 검사하는 함수입니다.
int change(int num); //2진수를 10진수로 변환하는 함수입니다.


int main(void) {

	int x = 0;

	printf("-1 입력시 종료 됩니다.\n");

	while (x != -1) {

		printf("2진수 숫자를 입력하세요 : ");
		scanf("%d", &x);

		if (check(x) == 0) {
			printf("2진수가 아닙니다.\n\n");
			continue;
		}
		else {
			printf("%d의 10진수 = %d 입니다.\n\n", x, change(x));
		}
	}
	return 0;
}

int change(int num) {

	int sum = 0;

	for (int s = 0; num != 0; s++) {
		sum += (int)pow(2, s) * (num % 10);
		num /= 10;
	}
	return sum;
}

int check(int num) {

	for (; num != 0;) {
		if (num % 10 > 1)
			return 0;

		num /= 10;
	}
	return 1;
}