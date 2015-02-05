//given a linked list divide the list into two halves nd appedn the second half in the front
//do in one single pass only

//O(n) time
//O(1) space

#include<iostream>
#include<cstdio>
#include<cstdlib>


using namespace std;

struct node
{
	int data;
	struct node *next;
	struct node *arbitptr;
};

typedef struct node Listnode;
typedef Listnode *Listnodeptr;

void printList(Listnodeptr startptr)
{
	if(startptr)
	{
		while(startptr)
		{
			printf("%d-->",startptr->data);
			startptr = startptr->next;
		}
		printf("NULL\n\n");
	}
	else
	{
		printf("list is empty\n");
	}
}

void insert(Listnodeptr *startptr, int data)
{
	Listnodeptr newnode = (Listnode *)malloc(sizeof(Listnode));
	Listnodeptr preptr=NULL;
	Listnodeptr currentptr = *startptr;
	if(newnode)
	{
		newnode->data = data;
		newnode->next = NULL;

		while(currentptr != NULL)//iterate to the end
		{
			preptr = currentptr;
			currentptr = currentptr->next;
		}

		if(preptr == NULL)//if list is empty
		{
			*startptr = newnode;
		}
		else //else insert at the end of the list
		{
			preptr->next = newnode;
		}
	}
	else
	{
		printf("error: out of memory\n");
	}
}

//delete func

void deleteList(Listnodeptr *startptr)
{
	Listnodeptr temp;

	while(*startptr != NULL)
	{
		temp= *startptr;
		*startptr = (*startptr)->next;
		printf("%d deleted\n",temp->data);
		free(temp);
	}
}


//insert second half in the front om one pass
void modifyList(Listnodeptr *start)
{
	if(*start==NULL)
		return;

	if((*start)->next==NULL)
		return;


	Listnodeptr fast,slow,fastPre, slowPre;
	fast=slow=*start;
	slowPre=NULL;


	while(fast!=NULL && fast->next!=NULL) //iterate till fast reached end or last node
	{
		slowPre=slow;
		fastPre=fast;
		slow=slow->next;
		fast=fast->next->next;
	}
	fastPre=fastPre->next; //cause its 2 ndoes behind fast

	if(fast!=NULL) //even length
	{
		slowPre=slow;
		slow=slow->next;
		fastPre=fast;
		fast=fast->next;
	}

	fastPre->next=*start;  //set next of last node to he start
	*start=slow; //set *start to start node of second half
	slowPre->next=NULL; //set NULL to last node of first half
}


int main()
{
	Listnodeptr startptr = NULL;
	int n, data, i,nValue;
	int hasLoop = 0;//false

	printf("enter the no of elements in the list: ");
	scanf("%d",&n);

	printf("enter all the elements: ");
	for(i=0;i<n;i++)
	{
		scanf("%d",&data);
		insert(&startptr,data);
	}


	printList(startptr);

	modifyList(&startptr);

	printList(startptr);

	return 0;
}

