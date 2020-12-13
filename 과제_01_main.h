#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NUM_LISTS 100

#ifdef _MSC_VER
#pragma warning(disable:4996)
#endif

typedef struct node_t_ {
	int data;
	struct node_t_* next;
	struct node_t_* prev;
} node_t;

typedef struct list_t_ {
	int count;
	node_t* head;
} list_t;
