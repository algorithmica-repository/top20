package algorithmica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class paragraph {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String mystring;
		String[] line;
		int i=1,value,count=0,maxcount=0,linenumber=0;
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\rohith\\algoritmica\\algorithmica\\src\\testcases\\paragraph.txt"));
		while((mystring=br.readLine())!=null)
		{
			count=0;
			
			line=mystring.split(" ");
			for(String s:line)
			{
				//check whether list is empty
				
				if(map.containsKey(s))
				{
					value=map.get(s);
					if(value<i)
					{
						map.remove(s);
						map.put(s,i);
						count++;
					}
				}
				else
				{
					map.put(s, i);
					count++;
				}
			}
			if(count>maxcount)
			{
				maxcount=count;
				linenumber=i;
			}
			i++;
		}
		System.out.print(maxcount+" "+linenumber+" "+map.size());
	}

}
