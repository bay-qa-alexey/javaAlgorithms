//20. Valid Parentheses (easy)


import java.util.Stack;

public class ValidParentheses {

    static public void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String phrase = "({[]})";
        System.out.println(validParentheses.isValid(phrase));
    }

    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();
        for(char ch : s.toCharArray()) {
            switch(ch) {
                case '(':
                    myStack.add(')');
                    break;
                case '{':
                    myStack.add('}');
                    break;
                case '[':
                    myStack.add(']');
                    break;
                default:
                    if(myStack.isEmpty() || myStack.pop() != ch) {
                        return false;
                    }
            }
        }
        return myStack.isEmpty();
    }
}
