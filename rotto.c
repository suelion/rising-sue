#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#pragma warning (disable : 4996)

int getMoney(int count);
int compLottoNum(void);
int num[6];

int main(void)
{
	int org_money = 10000;
	char answer;
	int count = 0;

	while (1)
	{
		char answer = NULL;
		printf("------------------------------\n");
		printf("������ ������ �ִ� �� : %d\n", org_money);
		printf("�º��� ���� : 1000��\n");

		if (org_money < 1000) {
			printf("������ �� �� �����ϴ�.");

			return 0;
		}

		printf("�º����� ��ðڽ��ϱ�?(y/n) : ");
		scanf(" %c", &answer);

		if (answer == 'y') {
			count++;
			printf("%d", count);
			org_money = getMoney(count);


			printf("==============================\n");
			printf("<<<<<<<���� ���� �Ϸ�!>>>>>>>\n");
			printf("1���� 20������ �� 6���� �Է��ϼ���\n");
			scanf("%d %d %d %d %d %d", &num[0], &num[1], &num[2], &num[3], &num[4], &num[5]);

			switch (compLottoNum())
			{
			case 0:
				printf("��! ���� ��ȸ��. . .\n");
				break;
			case 1:
				printf("1000�� ��÷!!!\n");
				break;
			case 2:
				printf("2000�� ��÷!!!\n");
				break;
			case 3:
				printf("4000�� ��÷!!!\n");
				break;
			case 4:
				printf("10���� ��÷!!!\n");
				break;
			case 5:
				printf("100���� ��÷!!!\n");
				break;
			case 6:
				printf("1000���� ��÷!!!\n");
				break;
			default:
				break;
			}
		}
		else if (answer == 'n')
			break;


	}
	return 0;
}

int getMoney(int count) {
	return 10000 - count * 1000;
}

int compLottoNum(void) {
	int x[6] = { rand() % 20 + 1, rand() % 20 + 1, rand() % 20 + 1, rand() % 20 + 1, rand() % 20 + 1, rand() % 20 + 1 };
	int flag = 0;

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			if (x[i] == num[i])
				flag++;
		}
	}
	return flag;
}
