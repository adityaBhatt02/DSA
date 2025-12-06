package Trees;

public class BST {
   public static Node insert(Node root ,int val) {
       if (root == null) {
          return new Node(val);
       }

       if(val < root.value) {
           root.left = insert(root.left , val);
       } else if (val > root.value) {
           root.right = insert(root.right , val);
       } else {
           System.out.println("Duplicates not allowed!");
       }

       return root;
   }

   public static boolean checkTheNodeIsPresentOrNot(Node root , int target) {
       if (root == null) {
           return false;
       }

       Node currentNode = root;

       while (currentNode != null) {
       if(currentNode.value == target) {
           return true;
       } else if (currentNode.value > target) {
           currentNode = currentNode.left;
       }else {
           currentNode = currentNode.right;
       }}
       return false;
   }


   public static Node search(Node root , int target) {
      if (root == null || root.value == target) {
          return root;
      }

      if (root.value > target) {
          return search(root.left , target);
      }
      else {
          return search(root.right , target);
      }
   }

   public static void preOrder(Node root) {
       if (root != null) {
           System.out.println(root.value);
           preOrder(root.left);
           preOrder(root.right);
       }
   }
   public static void inOrder(Node root) {
       if (root != null) {
           inOrder(root.left);
           System.out.println(root.value);
           inOrder(root.right);
       }
   }
   public static void postOrder(Node root) {
       if (root != null) {
           postOrder(root.left);
           postOrder(root.right);
           System.out.println(root.value);
       }
   }


    private static class Node {
        int value;
        Node left , right;

        Node(int val) {
            this.value = val;
            this.left = this.right = null;
        }
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(8);

        System.out.println("Preorder: ");
        preOrder(root);
        System.out.println();

        System.out.println("Postorder: ");
        postOrder(root);
        System.out.println();

        System.out.println("Inorder: ");
        inOrder(root);
        System.out.println();


        // Search a value
        int target = 69;
        Node found = search(root, target);
        if (found != null) {
            System.out.println("Found: " + found.value);
        } else {
            System.out.println("Node " + target + " not found!");
        }

        // Insert the value
        root = insert(root, target);

        // Inorder again
        System.out.print("Inorder after inserting " + target + ": ");
        inOrder(root);
        System.out.println();
    }
    }