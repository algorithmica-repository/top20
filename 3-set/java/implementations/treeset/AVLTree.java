
public class AVLTree {	
	
	//Function to compute height of a tree
	public static int height(TreeNode current){
		if(current == null)
			return 0;
		return current.height;
	}
	
	 /*    y                                   x
	      / \                                 / \ 
	     x  leaf3       --------->        leaf1  y
	    / \                                    /  \
	   /   \                                  /    \
	 leaf1 leaf2                            leaf2  leaf3    */
	/*                 Right Rotate                 */
	public static TreeNode rightrotate(TreeNode y){
		TreeNode x = y.left;
		TreeNode leaf = x.right;
		
		x.right = y;
		y.left = leaf;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	 /*    y                                   x
          / \                                 / \ 
         x  leaf3       <---------        leaf1  y
        / \                                    /  \
       /   \                                  /    \
    leaf1 leaf2                            leaf2  leaf3    */
     /*                 Left Rotate                 */
	
	public static TreeNode leftrotate(TreeNode x){
		TreeNode y = x.right;
		TreeNode leaf = y.left;
		
		y.left = x;
		x.right = leaf;
		
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		
		return y;
	}
	
	
	//Get Balance factor of TreeNode current
	public static int getBalance(TreeNode current){
		if(current == null)
			return 0;
		return height(current.left) - height(current.right);
	}
	
	//Performs insert operation
	public static TreeNode insert(TreeNode current, int key){
		
		
		//Condition for adding first node
		if(current == null)
			return new TreeNode(key);
		
		//Normal BST insertion
		if(key < current.key)
			current.left = insert(current.left, key);
		else
			current.right = insert(current.right, key);
		
		//Updating height of the ancestor node
		current.height = Math.max(height(current.left), height(current.right)) + 1;
		
		//getting balance factor to check if the node is unbalanced
		int balance = getBalance(current);
		
		//4 conditions of unbalancing
		if(balance > 1 && key < current.left.key)
			return rightrotate(current);
		if(balance < -1 && key > current.right.key)
			return leftrotate(current);
		if(balance > 1 && key > current.left.key)
		{
			current.left = leftrotate(current.left);
			return rightrotate(current);
		}
		
		if(balance < -1 && key < current.right.key)
		{
			current.right = rightrotate(current.right);
			return leftrotate(current);
		}
		
		return current;
	}
	
	//Tree traversal preOrder
	public static void preOrder(TreeNode root){
		if(root != null)
		{
			System.out.println(root.key);
			preOrder(root.left);
			
			preOrder(root.right);
		}
	}
	
	public static void main(String args[])
	{
		  TreeNode root = null;
		  root = insert(root, 10);
		  root = insert(root, 20);
		  root = insert(root, 30);
		  root = insert(root, 40);
		  root = insert(root, 50);
		  root = insert(root, 25);
		  preOrder(root);
		
	}

	
	

}
