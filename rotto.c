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
		printf("◈현재 가지고 있는 돈 : %d\n", org_money);
		printf("◈복권 가격 : 1000원\n");

		if (org_money < 1000) {
			printf("복권을 살 수 없습니다.");

			return 0;
		}

		printf("◈복권을 사시겠습니까?(y/n) : ");
		scanf(" %c", &answer);

		if (answer == 'y') {
			count++;
			printf("%d", count);
			org_money = getMoney(count);


			printf("==============================\n");
			printf("<<<<<<<복권 구매 완료!>>>>>>>\n");
			printf("1부터 20까지의 수 6개를 입력하세요\n");
			scanf("%d %d %d %d %d %d", &num[0], &num[1], &num[2], &num[3], &num[4], &num[5]);

			switch (compLottoNum())
			{
			case 0:
				printf("꽝! 다음 기회에. . .\n");
				break;
			case 1:
				printf("1000원 당첨!!!\n");
				break;
			case 2:
				printf("2000원 당첨!!!\n");
				break;
			case 3:
				printf("4000원 당첨!!!\n");
				break;
			case 4:
				printf("10만원 당첨!!!\n");
				break;
			case 5:
				printf("100만원 당첨!!!\n");
				break;
			case 6:
				printf("1000만원 당첨!!!\n");
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
