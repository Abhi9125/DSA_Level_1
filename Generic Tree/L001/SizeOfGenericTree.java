/*Size Of Generic Tree
Medium
1. You are given a partially written GenericTree class.
2. You are required to complete the body of size function. The function is expected to count the number of nodes in the tree and return it.
3. Input and Output is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

Sample Output
6 */

import java.io.*;
import java.util.*;

public class SizeOfGenericTree {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node){
    // write your code here
    int ans = 1;
    for(Node child : node.children){
      ans += size(child);
    }

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    int sz = size(root);
    System.out.println(sz);
    // display(root);
  }

}