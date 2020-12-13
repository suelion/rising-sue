#include<stdio.h>
#include<stdlib.h>
#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

typedef struct person_t_ {
	int name;
	struct person_t_* next;

}person_t;

person_t* get_new_person(int name) {
	person_t* p = (person_t*)malloc(sizeof(person_t));
	p->name = name;
	p->next = NULL;
	return p;
}

int main() {
	int n, k, i, j;
	scanf("%d %d", &n, &k);
	
	person_t* head = NULL, *p, *prev = NULL;

	head = get_new_person(1);
	p = head;
	printf("<");
	for (i = 2; i <= n; i++) {
		p->next = get_new_person(i);
		p = p->next;
	}
	p->next = head;

	for (i = 0; i < n - 1; i++) {
		for (j = 0; j < k; j++) {
			prev = p;
			p = p->next;
		}
		//p를 제거합니다.
		printf("%d, ", p->name);
		prev->next = p->next;

		free(p);

		p = prev;
	}
	printf("%d>", p->name);
	free(p);

	return 0;
}


/*
void Josephus(int n, int m) {
	int s1[5001] = { 0 };
	int j = 1;
	
	printf("<");
	for (int i = 0; i < n; i++) {
		int count = 0;
		while (1) {
			if (s1[j] == 0)
				count++;
			if (count == m) {
				s1[j] = -1;
				if (i == n - 1)
					printf("%d>", j);
				else
					printf("%d, ", j);
				break;
			}
			j++;
			if (j > n)
				j = 1;
		}
	}
}

int main() {
	int n, m;
	printf("(N, K)를 입력하세요");
	scanf("%d %d", &n, &m);
	Josephus(n, m);
}*/