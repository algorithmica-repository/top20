import java.io.*;
import java.util.*;
class Row{
	String c0,c1,c2,c3,c4;
	public Row(String c0,String c1,String c2,String c3,String c4){
		this.c1=c1;
		this.c2=c2;
		this.c3=c3;
		this.c4=c4;
		this.c0=c0;
	}
	public void display(){
		System.out.println(c0+" "+c1+" "+c2+" "+c3+" "+c4);
	}
}
class ClassSorting {
	public static void main(String[] args)throws IOException {
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		String line;
		System.out.println("Enter num of rows");
		int n=Integer.parseInt(buffer.readLine());
		Row row;
		int i=0;
		LinkedList<Row> list=new LinkedList<Row>();
		TreeMap<String,Row> tc0=new TreeMap<String,Row>();
		TreeMap<String,Row> tc1=new TreeMap<String,Row>();
		TreeMap<String,Row> tc2=new TreeMap<String,Row>();
		TreeMap<String,Row> tc3=new TreeMap<String,Row>();
		TreeMap<String,Row> tc4=new TreeMap<String,Row>();
		System.out.println("Enter 5 column values of every row in each line(each column is space seperated in every row):"); 
		for(i=0;i<n;i++){
			line=buffer.readLine();
			String tmparr[]=line.split(" ");
			row=new Row(tmparr[0],tmparr[1],tmparr[2],tmparr[3],tmparr[4]);
			list.add(row);
			tc0.put(tmparr[0],row);
			tc1.put(tmparr[1],row);
			tc2.put(tmparr[2],row);
			tc3.put(tmparr[3],row);
			tc4.put(tmparr[4],row);
		}
		
		while(true){
			System.out.println("Select column number to be sorted(0-4):");
			int selected=Integer.parseInt(buffer.readLine());
			if(selected<0||selected>4)
				break;
			switch(selected){
				case 0:
						for (Map.Entry<String, Row> entry : tc0.entrySet()) {
							entry.getValue().display();
						}
					break;
				case 1:
						for (Map.Entry<String, Row> entry : tc1.entrySet()) {
							entry.getValue().display();
						}
					break;
				case 2:
						for (Map.Entry<String, Row> entry : tc2.entrySet()) {
							entry.getValue().display();
						}
					break;
				case 3:
						for (Map.Entry<String, Row> entry : tc3.entrySet()) {
							entry.getValue().display();
						}
					break;
				case 4:
						for (Map.Entry<String, Row> entry : tc4.entrySet()) {
							entry.getValue().display();
						}
					break;
			}		
		}
		System.out.println("Do you want to remove least recently used row:(y/n)");
		String input=buffer.readLine();
		if(input.equals("Y")||input.equals("y")){
			Row removed=list.removeFirst();
			tc0.remove(removed.c0);
			tc1.remove(removed.c1);
			tc2.remove(removed.c2);
			tc3.remove(removed.c3);
			tc4.remove(removed.c4);
			System.out.println("After removing:");
			for (Map.Entry<String, Row> entry : tc0.entrySet()) {
				entry.getValue().display();
			}
		}
	}
}
/*
OUTPUT:
Enter num of rows
5
Enter 5 column values of every row in each line(each column is space seperated in every row):
a b c d e
b c d e a
c d e a b
d e a b c
e a b c d
Select column number to be sorted(0-4):
1
e a b c d
a b c d e
b c d e a
c d e a b
d e a b c
Select column number to be sorted(0-4):
5
Do you want to remove least recently used row:(y/n)
y
After removing:
b c d e a
c d e a b
d e a b c
e a b c d
*/

