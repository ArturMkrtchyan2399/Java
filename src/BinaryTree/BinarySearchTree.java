package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {

    private Node head;

    public void add(Integer value) {
        head = addRecursion(head, value);
    }

    private Node addRecursion(Node current, Integer value) {
        if (current == null) {
            return new Node(value);
        }
        if (value > current.value) {
            current.right = addRecursion(current.right, value);
        } else if (value < current.value) {
            current.left = addRecursion(current.left, value);
        } else {
            return current;
        }
        return current;
    }

    public boolean contains(int value) {
        return find(head, value) != null;
    }

    private Node find(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value == value) {
            return current;
        }
        if (current.value < value) {
            return find(current.right, value);
        }
        return find(current.left, value);
    }

    public Integer max() {
        Node current = head;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public Integer min() {
        Node current = head;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }


    public void delete(Integer value) {
        head = deleteRec(head, value);
    }

    private Node deleteRec(Node head, Integer value) {
        if (head == null) {
            return head;
        }
        if (value < head.value) {
            head.left = deleteRec(head.left, value);
        } else if (value > head.value) {
            head.right = deleteRec(head.right, value);
        } else {
            if (head.left == null)
                return head.right;
            else if (head.right == null)
                return head.left;

            head.value = minValueNode(head.right);

            head.right = deleteRec(head.right, head.value);
        }
        return head;
    }

    private Integer minValueNode(Node right) {
        Integer minv = right.value;
        while (right.left != null) {
            minv = right.left.value;
            right = right.left;
        }
        return minv;
    }

    public void printByLevel() {
        if (head == null) {
            return;
        }

        Queue<Node> deque = new ArrayDeque<>();
        deque.offer(head);
        while (!deque.isEmpty()) {
            Node current = deque.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                deque.offer(current.left);
            }
            if (current.right != null) {
                deque.offer(current.right);
            }
        }
    }

    public void sortTree() {
        sortTreePrint(head);
    }
    private void sortTreePrint(Node node) {
        if (node == null) {
            return;
        }
        sortTreePrint(node.left);
        System.out.printf("%s ", node.value);
        sortTreePrint(node.right);
    }
}
