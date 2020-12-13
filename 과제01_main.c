#include "°úÁ¦_01_main.h"

list_t lists[NUM_LISTS];

node_t* create_node(int data) {
	node_t* node = (node_t*)malloc(sizeof(node_t));
	node->data = data;
	node->next = NULL;
	node->prev = NULL;

	return node;
}

void initialize() {
	int i = 0;
	for (i; i < NUM_LISTS; i++) {
		lists[i].count = 0;
		lists[i].head = NULL;
	}
}

int insert(int id, int pos, int data) {
	if (pos < -1 || pos > lists[id].count) {
		return -1;
	}

	++lists[id].count;

	node_t* nNode = create_node(data);

	if (!lists[id].head) {
		lists[id].head = nNode;
		return 1;
	}

	if (pos == -1) {
		pos = lists[id].count - 1;
	}

	if (pos == 0) {
		nNode->next = lists[id].head;
		lists[id].head->prev = nNode;
		lists[id].head = nNode;
		return 1;
	}

	node_t* tmp = lists[id].head;
	for (int i = 0; i < pos - 1; ++i) {
		tmp = tmp->next;
	}
	nNode->next = tmp->next;
	tmp->next = nNode;
	nNode->prev = tmp;
	if (nNode->next) {
		nNode->next->prev = nNode;
	}
	return 1;
}

int find(int id, int data) {
	node_t* seek = lists[id].head;
	int i = 0;
	if (lists[id].head == NULL)
		return -1;

	while (i <= lists[id].count) {
		if (seek->data == data)
			return i;
	
		if (i == (lists[id].count)-1 && seek->data != data) 
			return -1;
		
		seek = seek->next;
		i++;
	}
}

int delete(int id, int pos) {
	if (id < 0 || id >= NUM_LISTS) {
		return -1;
	}
	if (pos >= lists[id].count) {
		return -1;
	}
	if (!lists[id].count) {
		return -1;
	}


	if (pos == -1) {
		pos = lists[id].count - 1;
	}

	--lists[id].count;

	node_t* tmp = lists[id].head;
	if (pos == 0) {
		lists[id].head = tmp->next;
	}

	else {
		for (int i = 0; i < pos; ++i) {
			tmp = tmp->next;
		}
	}

	if (tmp->prev) {
		tmp->prev->next = tmp->next;
	}
	if (tmp->next) {
		tmp->next->prev = tmp->prev;
	}
	free(tmp);
	return 1;
}

int count(int id) {
	if (lists[id].count == NULL)
		return 0;
	else
		return lists[id].count;
}

void reset(int id) {
	node_t* tmp;
	node_t* node = lists[id].head;
	while (node != NULL) {
		tmp = node->next;
		free(node);
		node = tmp;
	}
	free(node);
	lists[id].head = NULL;
	lists[id].count = 0;
}

void print(int id) {
	node_t* p = lists[id].head;

	if (lists[id].head == NULL){
		printf("\n");
		return;
	}

	while (p) {
		printf("%d ", p->data);
		p = p->next;
	}
	printf("\n");
}

void print_reverse(int id) {
	node_t* rp = lists[id].head;

	if (lists[id].head == NULL) {
		printf("\n");
		return;
	}

	while (rp->next != NULL) {
		rp = rp->next;
	}
	while (rp != NULL) {
		printf("%d ", rp->data);
		rp = rp->prev;
	}
	printf("\n");
	
}

int main() {
	char command[30];
	int id, pos, data, res;

	initialize();

	while (1) {
		scanf("%s", command);

		if (!strcmp(command, "insert")) {
			scanf("%d %d %d", &id, &pos, &data);
			res = insert(id, pos, data);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "find")) {
			scanf("%d %d", &id, &data);
			res = find(id, data);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "delete")) {
			scanf("%d %d", &id, &pos);
			res = delete(id, pos);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "count")) {
			scanf("%d", &id);
			res = count(id);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "reset")) {
			scanf("%d", &id);
			reset(id);
		}
		else if (!strcmp(command, "print")) {
			scanf("%d", &id);
			print(id);
		}
		else if (!strcmp(command, "print_reverse")) {
			scanf("%d", &id);
			print_reverse(id);
		}
		else if (!strcmp(command, "exit")) {
			break;
		}
	}
	return 0;
}