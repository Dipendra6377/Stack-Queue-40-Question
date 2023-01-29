// using stack
class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        Stack<Character> st = new Stack<>();
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                if(!st.isEmpty())
                    res+=c;
                st.push(c);
            }
            else{
                st.pop();
                if(!st.isEmpty())
                    res+=c;
            }   
        }
        return res;
    }
}
