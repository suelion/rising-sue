#include <stdio.h>
#pragma warning (disable : 4996)
void print_star(int num)
{
    for (int i = 0; i <= num; i++)
        printf("*");
}
void print_space(int num)
{
    for (int i = 0; i < num; i++)
        printf(" ");
}
int main(void)
{
    int x, i, j;
    printf("���ڸ� �Է��ϼ��� : ");
    scanf("%d", &x);
    if (x % 2 == 0)
        for (i = 0; i < x; i++)
        {
            print_space(x - i);
            print_star(i);
            printf("\n");
        }
    else if (x % 2 == 1)
        printf("¦���� �ƴմϴ�.");
    else
        printf("���ϴ� ���ڰ� �ƴմϴ�.");
    return 0;
}
