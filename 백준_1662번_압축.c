#include <stdio.h>
#include<string.h>
#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

char input[51] = "";

//input[i]에 여는 괄호가 있는데, 짝이 맞는 닫는 괄호의 index를 돌려줌
int find_close(int i) {
	int open = 0;
	while (1) {
		if (input[i] == '(') open++;
		if (input[i] == ')') open--;

		if (open == 0) return i;
		i++;
	}

}

//input[1]부터 inputp[r-1]까지의 문자열의 압출을 풀어서 길이를 돌려준다.
int f(int l, int r) {
	int count = 0;
	for (int i = l; i < r; i++) {
		if (input[i] == '(') {
			count--;
			int repeat = input[i - 1] - '0';
			int close_index = find_close(i);
			//input[i] = '('
			//input[close_index] = ')'

			count += repeat * f(i + 1, close_index);
			i = close_index;
		}
		else count++;
	}

	return count;
}

int main() {
	scanf("%s", input);
	printf("%d\n", f(0, strlen(input)));

	return 0;
}


/*char s1[50];

void extract(char s1[], int cur) {
	int count = 0;
	int i;
	int result;

	for (i = cur; i >= 0; i--) {
		if (s1[i] == '(') {
			break;
		}
		else if (s1[i] == ')') {
			result = recur(s1, i - 1);
			i = result;
		}
	}
}


int main() {
	printf("압축된 문자열을 입력하세요 : ");
	scanf("%s", s1);

}*/