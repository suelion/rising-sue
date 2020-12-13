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
    printf("숫자를 입력하세요 : ");
    scanf("%d", &x);
    if (x % 2 == 0)
        for (i = 0; i < x; i++)
        {
            print_space(x - i);
            print_star(i);
            printf("\n");
        }
    else if (x % 2 == 1)
        printf("짝수가 아닙니다.");
    else
        printf("원하는 숫자가 아닙니다.");
    return 0;
}
