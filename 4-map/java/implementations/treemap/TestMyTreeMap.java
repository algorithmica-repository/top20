
public class TestMyTreeMap {
    public static void main(String[] args) { 
        String test = "A L G O R I T H M I C A"; 
        String[] keys = test.split(" "); 
        int N = keys.length; 
        MyTreeMap<String, Integer> st = new MyTreeMap<String, Integer>();
        for (int i = 0; i < N; i++) 
            st.put(keys[i], i); 

        System.out.println("size = " + st.size());
        System.out.println("min  = " + st.min());
        System.out.println("max  = " + st.max());
        System.out.println("height=" + st.height());
        System.out.println();



        // print keys in order using select
        System.out.println("Testing select");
        System.out.println("--------------------------------");
        for (int i = 0; i < st.size(); i++)
            System.out.println(i + " " + st.select(i)); 
        System.out.println();

        // test range search and range count
        String[] from = { "A", "Z", "L", "O", "B", "C" };
        String[] to   = { "Z", "A", "L", "Z", "G", "L" };
        System.out.println("range search");
        System.out.println("-------------------");
        for (int i = 0; i < from.length; i++) {
            System.out.printf("%s-%s: ", from[i], to[i]);
            for (String s : st.keys(from[i], to[i]))
                System.out.print(s + " ");
            System.out.println();
        }
        System.out.println();

        // delete the smallest keys
        for (int i = 0; i < st.size() / 2; i++) {
            st.deleteMin();
        }
        System.out.println("After deleting the smallest " + st.size() / 2 + " keys");
        System.out.println("--------------------------------");
        for (String s : st.keys("A", "T")) 
            System.out.println(s + " " + st.get(s)); 
        System.out.println();


        System.out.println("After adding back N keys");
        System.out.println("--------------------------------");
        for (int i = 0; i < N; i++) 
            st.put(keys[i], i); 
        for (String s : st.keys("A", "T")) 
            System.out.println(s + " " + st.get(s)); 
        System.out.println();

    }
}


