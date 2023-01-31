class Solution {
    public String removeKdigits(String s, int K) {
        int n=s.length();
        
        if(K>=n){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        String newWord;

        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char d=s.charAt(i);
        
            while(!st.isEmpty() && K>0 && d<st.peek()){
                st.pop();
                K--;
            }
            if(st.isEmpty() && d == '0')
                continue;
            
            st.push(d);
        }
        
        while(K>0 && !st.isEmpty()){
            st.pop();
            K--;
        }
        
        if(st.isEmpty()){
            return "0";
        }
        
        
        while(!st.isEmpty()){
           sb.append(st.peek());
            st.pop(); 
        }
       newWord = sb.reverse().toString();
        return newWord;
    }
}
