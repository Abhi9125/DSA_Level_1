import java.util.*;
import java.util.Stack;
public class Main{
     public static boolean DuplicateBracket(String exp){
        Stack <Character> st = new Stack<>();
        for(int idx = 0; idx < exp.length(); idx++){
            char ch = exp.charAt(idx);
            if(ch == ')'){
            if(st.peek() == '('){
                return true;
            }else{
                while(st.peek() != '('){
                    st.pop();
                }
                st.pop();
            }
         }else if(ch == ' '){
            continue;
         }else {
            st.push(ch);
         }
        }
         return false;
      }
   public static void main(String argv[]){
      Scanner scn = new Scanner(System.in);
      String exp = scn.nextLine();
       
      System.out.println(DuplicateBracket(exp));

   }
}

