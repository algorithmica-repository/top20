struct arraylist {
	int* array;
	int size;
};

struct arraylist* init() {
	al = malloc(sizeof(struct arraylist));
	al->array = malloc(10 * sizeof(int));
	al->size = 0;
}
void add(struct arraylist* al, int e) {
	
}

void display(struct arraylist* al) {
	
}

int main() {
	struct arraylist* al;
	al = init();
	add(al, 10);
	add(al, 20);
	display(al);
	return 0;
}

