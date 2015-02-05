//given a linked list clone it
//using arbitary pointer nd inserting duplicate of each node between it nd the next node

//O(n) time


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


//clone a list
Listnodeptr clone(Listnodeptr start)
{
	if(start==NULL || start->next==NULL)
		return start;

	
	Listnodeptr cur,next,newnode;
	cur=start;

	while(cur!=NULL) //every time create a node nd insert it between teh current node nd the next node
	{
		next=cur->next; 

		newnode=(Listnodeptr)malloc(sizeof(Listnode));
		newnode->data=cur->data;
		newnode->arbitptr=NULL;
		
		
		cur->next=newnode;
		newnode->next=next;

		cur=next;
	}


	//now iterate the list nd set the arbit pointers for the new nodes

	cur=start;

	while(cur!=NULL)
	{
		next=cur->next->next;

		cur->next->arbitptr=cur->arbitptr->next;
		cur=next;
	}


	Listnodeptr secondList=start->next; //initialize second list
	Listnodeptr temp;
	cur=start;
	while(cur!=NULL) //now split the list nd update next pointers
	{
		temp=start->next; //track cloned node
		next=cur->next->next;

		cur->next=cur->next->next;
		if(temp->next)
			temp->next=temp->next->next;

		cur=next;
	}

	//append NULL at the end of clonedlist
	temp->next=NULL;
	return secondList;
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

	startptr->arbitptr=startptr->next;
	startptr->next->arbitptr=startptr;
	Listnodeptr clonedList= clone(startptr);

	printf("original list:\n");
	printList(startptr);

	printf("cloned list:\n");
	printList(clonedList);


	return 0;
}

