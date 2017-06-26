import java.util.LinkedList;
import java.util.Queue;


public class TreeDepth {

	public static int treeDepth1(TreeNode root) {
		if(root == null) return 0;
		int lh = treeDepth1(root.left);
		int rh = treeDepth1(root.right);
		return Math.max(lh, rh) + 1;
	}
	
	public static int treeDepth2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int nlevels = 0;
		while(true) {
			TreeNode tmp = q.remove();
			if(tmp == null) {
				++nlevels;
				if(! q.isEmpty())
					q.add(null);
				else 
					break;
			} else {
				if(tmp.left != null) q.add(tmp.left);
				if(tmp.right != null) q.add(tmp.right);
			}
		}
		return nlevels;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree2(root);
		System.out.println(treeDepth1(root));
		System.out.println(treeDepth2(root));
	}

}
