class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Map<Character,Integer> priority = new HashMap<>();
        priority.put('(',0);
        priority.put('+',1);
        priority.put('-',1);
        priority.put('*',2);
        priority.put('/',2);
        priority.put('^',3);
        
        Stack<Character> st = new Stack<>();
        String ans="";
        
        for(int i=0;i<exp.length();i++){
            char c= exp.charAt(i);
            if(c=='('){
                st.push(c);
            }
            
            else if(c==')'){
                while(st.peek()!='('){
                    ans+=st.pop();
                }
                    st.pop();
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^'){
                while(!st.isEmpty() && priority.get(st.peek())>=priority.get(c)){
                    ans+=st.pop();
                }
                st.push(c);
            }
            else{
                ans+=c;
            }
        }
        
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}
