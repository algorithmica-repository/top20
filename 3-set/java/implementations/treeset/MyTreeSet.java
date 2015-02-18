import java.util.LinkedList;
import java.util.Queue;


public class MyTreeSet<Key extends Comparable<Key>> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Node left, right;  // left and right subtree references
        private int N;             // number of nodes in subtree

        public Node(Key key, int N) {
            this.key = key;
            this.N = N;
        }
    }

    // is the treeset empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // return number of keys in BST
    public int size() {
        return size(root);
    }
    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }


    // does there exist a given key?
    public boolean contains(Key key) {
        return auxContains(root, key);
    }

    private boolean auxContains(Node x, Key key) {
        if (x == null) return false;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return auxContains(x.left, key);
        else if (cmp > 0) return auxContains(x.right, key);
        else              return true;
    }

    // inserting a key
    public void add(Key key) {
        root = add(root, key);
    }

    private Node add(Node x, Key key) {
        if (x == null) return new Node(key, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = add(x.left,  key);
        else if (cmp > 0) x.right = add(x.right, key);
        else              x.key   = key;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }


    //deleting minimum from tree
    public void removeMin() {
        if (isEmpty()) throw new RuntimeException("underflow");
        root = removeMin(root);
    }

    private Node removeMin(Node x) {
        if (x.left == null) return x.right;
        x.left = removeMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

  //deleting maximum from tree
    public void removeMax() {
        if (isEmpty()) throw new RuntimeException("underflow");
        root = removeMax(root);
    }

    private Node removeMax(Node x) {
        if (x.right == null) return x.left;
        x.right = removeMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //removing the key from tree
    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = remove(x.left,  key);
        else if (cmp > 0) x.right = remove(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = removeMin(t.right);
            x.left = t.left;
        } 
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    } 


    //finding tree minimum
    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 

  //finding tree maximum
    public Key max() {
        if (isEmpty()) return null;
        return max(root).key;
    } 

    private Node max(Node x) { 
        if (x.right == null) return x; 
        else                 return max(x.right); 
    } 

    
    //Finding the element of rank k
    public Key select(int k) {
        if (k < 0 || k >= size()) return null;
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k 
    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

   
    //Range search
    public Queue<Key> getKeys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 
    
    //in-order display
    public Queue<Key> display() {
    	Queue<Key> queue = new LinkedList<Key>();
    	auxdisplay(root, queue);
    	return queue;
    }
    
    private void auxdisplay(Node x, Queue<Key> queue) {
    	if(x == null) return;
    	auxdisplay(x.left, queue);
    	queue.add(x.key);
    	auxdisplay(x.right, queue);
    }
    
    // level order traversal
    public Queue<Key> levelOrder() {
        Queue<Key> keys = new LinkedList<Key>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node x = queue.remove();
            if (x == null) continue;
            keys.add(x.key);
            queue.add(x.left);
            queue.add(x.right);
        }
        return keys;
    }

    // height of this BST (one-node tree has height 1)
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }


}