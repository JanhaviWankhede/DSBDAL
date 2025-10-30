package daa_final_practical;

import java.util.PriorityQueue;

//Creating Huffman tree node
class Node implements Comparable<Node> {
 int freq;           // frequency of symbol
 String symbol;      // symbol name (character)
 Node left;          // left child
 Node right;         // right child
 String huff = "";   // tree direction (0/1)

 Node(int freq, String symbol) {
     this.freq = freq;
     this.symbol = symbol;
 }

 Node(int freq, String symbol, Node left, Node right) {
     this.freq = freq;
     this.symbol = symbol;
     this.left = left;
     this.right = right;
 }

 @Override
 public int compareTo(Node nxt) {
     return this.freq - nxt.freq; // For min-heap behavior
 }
}

public class HuffmanCoding {

 // Recursive function to print Huffman codes
 static void printNodes(Node node, String val) {
     String newVal = val + node.huff;

     if (node.left != null)
         printNodes(node.left, newVal);
     if (node.right != null)
         printNodes(node.right, newVal);

     // If this node is a leaf node, print its code
     if (node.left == null && node.right == null)
         System.out.println(node.symbol + " -> " + newVal);
 }

 public static void main(String[] args) {

     char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
     int[] freq = { 5, 9, 12, 13, 16, 45 };

     PriorityQueue<Node> nodes = new PriorityQueue<>();

     // Convert characters and frequencies into Huffman tree nodes
     for (int i = 0; i < chars.length; i++) {
         nodes.add(new Node(freq[i], String.valueOf(chars[i])));
     }

     // Combine nodes until only one remains (root)
     while (nodes.size() > 1) {
         Node left = nodes.poll();
         Node right = nodes.poll();

         left.huff = "0";
         right.huff = "1";

         Node newNode = new Node(left.freq + right.freq, left.symbol + right.symbol, left, right);
         nodes.add(newNode);
     }

     // Print Huffman codes by traversing the tree
     printNodes(nodes.peek(), "");
 }
}
