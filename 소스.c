#include <stdio.h>
#pragma warning (disable : 4996)

int change(int decimal) //10������ 2������ ��ȯ�ϴ� �Լ��Դϴ�. 
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

	printf("-1 �Է½� ���� �˴ϴ�.\n");

	while (x != -1) {
		printf("���ڸ� �Է��ϼ��� : ");
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


	printf("-1�Է½� ���� �˴ϴ�.\n");

	while (1) {
		printf("���ڸ� �Է��ϼ��� : ");
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

int change(int num); //2������ 10������ ��ȯ�ϴ� �Լ��Դϴ�.


int main(void) {

	int x = 0;

	printf("-1 �Է½� ���� �˴ϴ�.\n");

	while (x != -1) {

		printf("10���� ���ڸ� �Է��ϼ��� : ");
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
