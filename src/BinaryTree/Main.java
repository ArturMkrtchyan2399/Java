package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(50);
        tree.add(-30);
        tree.add(20);
        tree.add(5);
        tree.add(-70);
        tree.add(60);
        tree.add(0);
        System.out.println(tree.contains(5));
        tree.delete(5);
        System.out.println(tree.contains(5));

        System.out.println("Printing in sorted order");
        tree.sortTree();
        System.out.println("\nPrinting by level");
        tree.printByLevel();

        System.out.println("\nMax element is " + tree.max());
        System.out.println("Min element is " + tree.min());
    }
}
