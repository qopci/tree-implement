import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {

    // Int Tree
    TreeNode<Integer> root = new TreeNode<>(77, null, null);
    root.left = new TreeNode<>(22, null, null);
    root.right = new TreeNode<>(87, null, null);
    root.right.left = new TreeNode<>(9, null, null);
    root.left.right = new TreeNode<>(33, null, null);
    root.left.right.left = new TreeNode<>(86, null, null);

    // String Tree
    TreeNode<String> stringRoot = new TreeNode<>("hello", null, null);
    stringRoot.left = new TreeNode<>("hi", null, null);
    stringRoot.right = new TreeNode<>("hey", null, null);

    // System.out.println(countLevels(root));

    TreeNode<Integer> megaRoot = new TreeNode<>(0, null, null);

    TreeNode<Integer> current = megaRoot;
    for (int i = 1; i <= 999999; i++) {
      current.left = new TreeNode<>(i, null, null);
      current = current.left;
    }

    preOrderIter(root);

    // preOrder(root);
    // inOrder(root);
    // postOrder(root);
    // greaterThan(root, 25);
    // int result = countNodes(root);
    // System.out.println(result);
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> nodeStack = new Stack<>();

    nodeStack.push(node);

    while (!nodeStack.empty()) {
      TreeNode<T> current = nodeStack.pop();

      if (current == null) {
        continue;
      }
      System.out.println(current.value);
      nodeStack.push(current.right);
      nodeStack.push(current.left);
    }
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

  public static <T> int countLevels(TreeNode<T> node) {
    if (node == null) {
      return 0;
    }
    // height of larger subtree + 1
    int leftHeight = countLevels(node.left);
    int rightHeight = countLevels(node.right);
    int biggerHeight = Math.max(leftHeight, rightHeight);

    return biggerHeight + 1;
  }

  // null -> true
  public static boolean allOdd(TreeNode<Integer> node) {
    if (node == null) {
      return true;
    }
    return node.value % 2 != 0 &&
          allOdd(node.left) &&
          allOdd(node.right);
  }
}
