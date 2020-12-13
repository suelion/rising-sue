#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#ifdef _MSC_VER
#pragma warning(disable: 4996)
#endif

typedef struct _node_t {
	int data;
	struct _node_t* left;
	struct _node_t* right;
}node_t;

node_t* create_node(int data) {
	node_t* node = (node_t*)malloc(sizeof(node_t));
	node->data = data;
	node->left = node->right = NULL;

	return node;
}

node_t* root; 
   
void initialize() {
	root = create_node(0);
}

int add(char pos_string[], int data) {

	node_t **t; 
	t = &root;

	for (int i = 0; i < strlen(pos_string); i++) {
		if (*t == NULL)
			return -1;
		else if (pos_string[i] == 'L') { 
			t = &(*t)->left;
		}                   
		else if (pos_string[i] == 'R') {
			t = &(*t)->right;
		} 
		else 
			return -1;
	}
	if (*t != NULL) {
		return -1;
	}

	*t = create_node(data);

	return 1;
}

int delete(char pos_string[]) {

	node_t** t;
	t = &root;

	for (int i = 0; i < strlen(pos_string); i++) {
		if (*t == NULL)
			return -1;
		else if (pos_string[i] == 'L') { 
			t = &(*t)->left;
		}
		else if (pos_string[i] == 'R') { 
			t = &(*t)->right;
		}
		else 
			return -1;
	}
	if (*t == NULL)
		return -1;

	if ((*t)->left == NULL && (*t)->right == NULL) {
		free(*t);
		*t = NULL;
		return 1;
	}
	return -1;
}

void preorder(node_t* node) {
	if (node == NULL)
		return;

	printf("%d ", node->data);
	preorder(node->left);
	preorder(node->right);
}

void inorder(node_t* node) {
	if (node == NULL)
		return;

	inorder(node->left);
	printf("%d ", node->data);
	inorder(node->right);
}

void postorder(node_t* node) {
	if (node == NULL)
		return;

	postorder(node->left);
	postorder(node->right);
	printf("%d ", node->data);
}

int main() {
	char command[30], pos_string[30];
	int data, res;

	initialize();

	while (1) {
		scanf("%s", command);

		if (!strcmp(command, "add")) {
			scanf("%s %d", pos_string, &data);
			res = add(pos_string, data);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "delete")) {
			scanf("%s", pos_string);
			res = delete(pos_string);
			printf("%d\n", res);
		}
		else if (!strcmp(command, "preorder")) {
			preorder(root);
			printf("\n");
		}
		else if (!strcmp(command, "inorder")) {
			inorder(root);
			printf("\n");
		}
		else if (!strcmp(command, "postorder")) {
			postorder(root);
			printf("\n");
		}
		else if (!strcmp(command, "exit")) {
			break;
		}
	}

	return 0;
}