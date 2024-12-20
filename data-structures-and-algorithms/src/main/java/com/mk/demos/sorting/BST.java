package com.mk.demos.sorting;

/**
 * BST
 *
 * @author WangChen
 * Created on 2024/12/19
 * @since 1.0
 */
public class BST { //TODO ? 二叉树排序树

    public static void main(String[] args) {
        Node node = new Node(10);
        node.insert(5);
        node.insert(15);
        node.insert(8);
        node.insert(3);
        node.insert(7);
        node.insert(12);
        node.insert(18);
        System.out.println(node.contains(7));
        System.out.println(node.contains(17));
        node.printInOrder();
        System.out.println("============");
        node.printPreOrder();
        System.out.println("============");
        node.printPostOrder();
    }

    // 二叉树排序树
    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int value) {
            if (value <= data) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public boolean contains(int value) {
            if (value == data) {
                return true;
            } else if (value < data) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            }
        }

        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.println(data);
            if (right != null) {
                right.printInOrder();
            }
        }

        public void printPreOrder() {
            System.out.println(data);
            if (left != null) {
                left.printPreOrder();
            }
            if (right != null) {
                right.printPreOrder();
            }
        }

        public void printPostOrder() {
            if (left != null) {
                left.printPostOrder();
            }
            if (right != null) {
                right.printPostOrder();
            }
            System.out.println(data);
        }
    }
}
