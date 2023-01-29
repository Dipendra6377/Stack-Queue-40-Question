// 1st approach

class Solution {
    public int maxDepth(String s) {
        int count=0;
        int max=0;
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if(c=='('){
                count++;
                max=Math.max(max,count);
            }
            if(c==')'){
                count--;
            }
        }
        return max;
    }
}



//2 using stack

class Solution {
    public int maxDepth(String s) {
        int count=0;
        int max=0;
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            if(c=='('){
                st.push(c);
                max=Math.max(max,st.size());
            }
            if(c==')'){
                st.pop();
            }
        }
        return max;
    }
}
