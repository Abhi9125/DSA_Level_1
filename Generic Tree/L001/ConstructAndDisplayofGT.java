import java.util.*;
public class ConstructAndDisplayofGT{
  private static class Node{  // node class define 
    int data;
    ArrayList<Node> children; // children define in node 
    
    Node(int val){  // constructer
      data = val;
      children = new ArrayList<> ();
    }
    
  }
    
    public static Node constructGT(Integer arr[]){
      Stack<Node> st = new Stack<>();  
      Node root = new Node(arr[0]);
      st.push(root);
      int idx = 1;
      while(idx < arr.length){
        Integer val = arr[idx];
        if(val == null){
          st.pop();
        }else{
          Node Cnode = new Node(val);
          Node par = st.peek();
          par.children.add(Cnode);
          st.push(Cnode);
        }
        idx++;
      }
      return(root);
    } 
    
    public static void Display(Node root){
      System.out.print(root.data+"->");
      for(Node child : root.children){
        System.out.print(child.data+" ");
      }
      
      System.out.println();
      
      for(Node child : root.children){
        Display(child);
      }
    }
    
    public static void main(String argv[]){
      Integer arr[] ={10, 20, null, 30, 40, 50, null,null,null,null};
      Node root = constructGT(arr);
      Display(root);      
    }
}
