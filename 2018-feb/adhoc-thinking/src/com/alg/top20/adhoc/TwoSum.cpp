#include <iostream>
#include <algorithm>
#include <set>
using namespace std;

// sort and check adjacent element 
int findDuplicate1(int arr[],int n){
	sort(arr,arr+n);
	for(int i=1;i<n;++i){
		if(arr[i]==arr[i-1]){
			return arr[i];
		}
	}
	return -1;
}

//in place check
int findDuplicate2(int arr[],int n){
		
	for(int i=0;i<n;i++){
		if(arr[abs(arr[i])] < 0)
		      return abs(arr[i]);
		else       
		     arr[abs(arr[i])]*=-1;
	}
	return 0;
}
//using set data structure
int findDuplicate3(int arr[],int n){
	set<int> st;
	st.insert(arr[0]);
	for(int i=1;i<n;i++){
		if(st.find(arr[i])!=st.end())
		        return arr[i];
		st.insert(arr[i]);
	}
}

int main(){
	int n;
	cin>>n;
	int arr[n];
	int i;
	
	// generating a test case
	for(i=0;i<n-1;i++){
		arr[i]=n-i-1;
	}
	arr[i]=n-1; //making last element duplicate
	
	cout<<findDuplicate1(arr,n);
	cout<<findDuplicate2(arr,n);
	cout<<findDuplicate3(arr,n);
	
}
