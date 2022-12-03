package leetcode;
import java.util.Stack;
public class BalancedParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s= "(){}{}{)}{()}}{}{}{)()({}}{}{}";
       System.out.println(checkBalanced(s));
	}
	public static String checkBalanced(String inputStr){//Function to check parentheses
		Stack<Character> s = new Stack<>(); //The stack
		for(char i : inputStr.toCharArray()){
		if (i=='[' || i=='{' || i=='(')
		s.push(i);
		else if (i=='}' || i==']' || i==')')
		if (s.size()>0 && s.pop()==i)
		s.pop();
		else
		return "Unbalanced";
		}
		if (s.size() == 0)
		return "Balanced";
		else
		return "Unbalanced";
		}
}

