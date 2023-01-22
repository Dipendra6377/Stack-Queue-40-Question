// Using Stack
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch=='{' || ch=='(' || ch=='['){
                st.push(ch);
            }
            else{
                if(st.empty()){
                    return false;
                }
                if((st.peek()=='{' && ch=='}') ||
                (st.peek()=='(' && ch==')') ||
                (st.peek()=='[' && ch==']')){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}

//Using array(Beats 100%)

class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        int arr[]=new int[n];
        int index=0;
        if(n%2!=0){
            return false;
        }

        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '[': arr[index]='['; index++; break;
                case '(': arr[index]='('; index++;   break;
                case '{': arr[index]='{'; index++;  break;
                case ']': index--; if(index<0 || arr[index]!='[')  return false ;break;
                case ')': index--; if(index<0 || arr[index]!='(')  return false ;break;
                case '}': index--; if(index<0 || arr[index]!='{') return false; break;
            }
        }
        if(index!=0) return false;
        return true;
    }
}
