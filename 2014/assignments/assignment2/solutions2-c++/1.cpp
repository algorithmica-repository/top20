//given a linked list of two elements, r nd b, find the longest element with any element
//using two value maxSoFar nd currentMax nd keeping track of last element

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


int maxSeq(Listnodeptr start)
{
	if(start==NULL)
		return 0;
	else if(start->next==NULL)
		return 1;

	int maxSoFar,curMax;
	int pre;

	pre=start->data; //take cur->data nd update 1 as length so far nd curMax
	maxSoFar=1;
	curMax=1;

	start=start->next;

	while(start!=NULL)
	{
		if(start->data==pre)
		{
			curMax++;
			if(curMax>maxSoFar)
				maxSoFar=curMax;
			start=start->next;
		}
		else
		{
			curMax=1;
			pre=start->data;
			start=start->next;
		}
	}
	return maxSoFar;
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
		printf("%d %c**\n",data,data);
		insert(&startptr,data);
	}


	printList(startptr);
	printf("longest seq szie: %d\n",maxSeq(startptr));


	return 0;
}

