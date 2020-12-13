#include <stdio.h>
#pragma warning (disable : 4996)

int change(int decimal) //10진수를 2진수로 변환하는 함수입니다. 
{
	int binary = 0;

	for (int s = 1, r = 0; decimal != 0;)
	{
		r = decimal % 2;
		binary = binary + s * r;
		decimal /= 2;
		s *= 10;

	}
	return binary;
}
int main(void) {
	int x = 0;

	printf("-1 입력시 종료 됩니다.\n");

	while (x != -1) {
		printf("숫자를 입력하세요 : ");
		scanf("%d", &x);

		printf("%d\n\n", change(x));
	}
	return 0;
}



/*
#include <stdio.h>
#pragma warning (disable : 4996)

int main(void) {

	int x, r;


	printf("-1입력시 종료 됩니다.\n");

	while (1) {
		printf("숫자를 입력하세요 : ");
		scanf("%d", &x);

		if (x == -1)
			break;

		int s = 1;
		int sum = 0;
		while (x != 0) {
			r = x % 2;
			sum = sum + s * r;

			x /= 2;

			s *= 10;


		}
		printf("%d\n\n", sum);

	}


	return 0;
}
*/


/*
#include <math.h>
#include <stdio.h>
#pragma warning (disable : 4996)

int change(int num); //2진수를 10진수로 변환하는 함수입니다.


int main(void) {

	int x = 0;

	printf("-1 입력시 종료 됩니다.\n");

	while (x != -1) {

		printf("10진수 숫자를 입력하세요 : ");
		scanf("%d", &x);

		printf("%d\n\n", change(x));
	}

	return 0;
}

int change(int num) {

	int sum = 0;

	for (int s = 0; num != 0; s++) {
		sum += (int)pow(10, s) * (num % 2);
		num /= 2;
	}
	return sum;
}
*/
