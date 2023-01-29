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


//using iterative approach
class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        int k=0;
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') count++;
            else count--;

            if(count==0){
                res+=s.substring(k+1,i);
                k=i+1;
            }
        }
        return res;
    }
}
