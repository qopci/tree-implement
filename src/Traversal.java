public class Traversal {
  public static void main(String[] args) {

    TreeNode root = new TreeNode(77, null, null);
    root.left = new TreeNode(22, null, null);
    root.right = new TreeNode(86, null, null);
    root.left.right = new TreeNode(33, null, null);

    // System.out.println(root.left.right.value); 
    // preOrder(root);
    // inOrder(root);
    postOrder(root);
  }

  public static void preOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.println(node.value);
    preOrder(node.left);
    preOrder(node.right);
  }

  public static void inOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
  }

  public static void postOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value);
  }
}
