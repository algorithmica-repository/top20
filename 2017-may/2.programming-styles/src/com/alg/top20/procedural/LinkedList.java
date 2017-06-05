struct listnode {
	int data;
	struct listnode* next;
};

struct linkedlist {
	struct listnode* first;
	struct listnode* last;
	int size;
};

struct linkedlist* init() {
	struct linkedlist* ll;
	ll = malloc(sizeof(linkelist));
	ll->first == ll->last = null;
	ll->size = 0;
	return ll;
}
void add(struct linkedlist* ll, int e) {
	
}
void display(struct linkedlist* ll) {
	
}
int main() {
	struct linkedlist* ll;
	ll = init();
	add(ll, 10);
	add(ll, 20);
	display(ll);
}