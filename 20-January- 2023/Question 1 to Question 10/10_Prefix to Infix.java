class Solution {
    static String preToInfix(String exp) {
        // code here
        int n=exp.length();
        Stack<String> st=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            char c=exp.charAt(i);
            if(isOperator(c)){
                String op1 =st.pop();
                String op2 =st.pop();
                String temp="("+op1+c+op2+")";
                
                st.push(temp);
            }
            else{
                st.push(c+"");
            }
        }
        return st.pop();
    }
    static boolean isOperator(char c){
        if(c=='/' || c=='+' || c=='-' || c=='*'){
            return true;
        }
        
        return false;
        
    }
}
