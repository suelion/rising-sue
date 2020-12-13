#include <stdio.h>
#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

int nCr(int n, int r) {
	if (r == 0 || r == n) {
		return 1;
	}
	else {
		return nCr(n - 1, r - 1) + nCr(n - 1, r);
	}
}

//int nCr(int n, int r) {
//	if (r == 0) return 1;
//	if (n == r) return 1;
//	return nCr(n - 1, r - 1) + nCr(n - 1, r);
//}



int main(void) {
	int n, r;
	printf("n과 r을 입력하세요 : ");
	scanf("%d %d", &n, &r);
	printf("%d", nCr(n, r));
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