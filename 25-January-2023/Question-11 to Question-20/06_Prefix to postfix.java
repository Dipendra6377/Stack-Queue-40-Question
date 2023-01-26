class Solution {
    static String preToPost(String exp) {
        // code here
        Stack<String> st=new Stack<>();
        int n=exp.length();
        
        for(int i=n-1;i>=0;i--){
            char c=exp.charAt(i);
            
            if(isoperator(c)){
                String op1 = st.pop();
                String op2 = st.pop();
                
                st.push(op1 + op2 + c);
            }
            else{
                st.push(c+"");
            }
        }
        return st.pop();
    }
    static boolean isoperator(char c){
        if(c=='/' || c=='*' || c=='+' || c=='-'){
            return true;
        }
        return false;
    }
}
