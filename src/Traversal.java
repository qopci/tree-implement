public class Traversal {
  public static void main(String[] args) {

    // Int Tree
    TreeNode<Integer> root = new TreeNode<>(77, null, null);
    root.left = new TreeNode<>(22, null, null);
    root.right = new TreeNode<>(86, null, null);
    root.right.left = new TreeNode<>(9, null, null);
    root.left.right = new TreeNode<>(33, null, null);
    root.left.right.left = new TreeNode<>(86, null, null);

    // String Tree
    TreeNode<String> stringRoot = new TreeNode<>("hello", null, null);
    stringRoot.left = new TreeNode<>("hi", null, null);
    stringRoot.right = new TreeNode<>("hey", null, null);

    preOrder(stringRoot);

    // preOrder(root);
    // inOrder(root);
    // postOrder(root);
    // greaterThan(root, 25);
    // int result = countNodes(root);
    // System.out.println(result);
  }

  public static <T> void preOrder(TreeNode<T> node) {
    if (node == null) {
      return;
    }
    System.out.println(node.value);
    preOrder(node.left);
    preOrder(node.right);
  }

  public static <T> void inOrder(TreeNode<T> node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
  }

  public static <T> void postOrder(TreeNode<T> node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value);
  }

  public static void greaterThan(TreeNode<Integer> node, int threshold) {
    if (node == null) {
      return;
    }

    if (node.value > threshold) {
      System.out.println(node.value);
    }
    greaterThan(node.left, threshold);
    greaterThan(node.right, threshold);
  }

  public static <T> int countNodes(TreeNode<T> node) {
    if (node == null) {
      return 0;
    }
    return 1 + countNodes(node.left) + countNodes(node.right);
  }
}
