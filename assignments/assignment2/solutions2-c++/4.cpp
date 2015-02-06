//merge sort linked list
//O(nlog*n) time
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



Listnodeptr sortedMerge(Listnodeptr l1, Listnodeptr l2)
{
	if(l2==NULL)
		return l1;

	Listnodeptr ans,cur;
	ans=NULL;;

	while(l1!=NULL && l2!=NULL) //while both are not empty, compare nd fill ans linked list
	{
		if(l1->data <= l2->data)
		{
			ans==NULL?(ans=l1):(cur->next=l1); //check if first node in ans or else
			cur=l1;
			l1=l1->next;
		}
		else
		{
			ans==NULL?(ans=l2):(cur->next=l2);
			cur=l2;
			l2=l2->next;
		}
	}

	while(l1!=NULL) //if l1 is remaining
	{
		cur->next=l1;
		cur=l1;
		l1=l1->next;
	}

	while(l2!=NULL) //if l2 is left
	{
		cur->next=l2;
		cur=l2;
		l2=l2->next;
	}

	cur->next=NULL;

	return ans;
}
	


//split list into two parts
void split(Listnodeptr start, Listnodeptr *l1, Listnodeptr *l2)
{
	if(start==NULL || start->next==NULL)
	{
		*l1=start;
		*l2=NULL;
	}

	Listnodeptr slow,fast,slowPre;
	slow=fast=start;

	while(fast!=NULL && fast->next!=NULL) //loop to get slow at mid point
	{
		slowPre=slow;
		slow=slow->next;
		fast=fast->next->next;
	}

	if(fast!=NULL)//in case of odd length
		fast=fast->next;

	*l1=start;  //set head of first half
	slowPre->next=NULL; //end first half
	*l2=slow; //set head of second half
}


//mergeSort
void mergeSort(Listnodeptr *start)
{
	if(*start==NULL || (*start)->next==NULL)
		return;

	Listnodeptr l1,l2;
	split(*start,&l1,&l2); //split list

	//got recursive
	mergeSort(&l1);
	mergeSort(&l2);

	//combine both
	*start=sortedMerge(l1,l2);
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
	mergeSort(&startptr);
	printList(startptr);

	return 0;
}

