#include <math.h>
#include <stdio.h>
#pragma warning (disable : 4996)

int check(int num); //2�������� �ƴ��� �˻��ϴ� �Լ��Դϴ�.
int change(int num); //2������ 10������ ��ȯ�ϴ� �Լ��Դϴ�.


int main(void) {

	int x = 0;

	printf("-1 �Է½� ���� �˴ϴ�.\n");

	while (x != -1) {

		printf("2���� ���ڸ� �Է��ϼ��� : ");
		scanf("%d", &x);

		if (check(x) == 0) {
			printf("2������ �ƴմϴ�.\n\n");
			continue;
		}
		else {
			printf("%d�� 10���� = %d �Դϴ�.\n\n", x, change(x));
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