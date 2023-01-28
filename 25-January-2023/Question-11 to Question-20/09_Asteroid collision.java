class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> st = new Stack<>();
        int n=ast.length;
        for(int i=0;i<n;i++){
            if(ast[i]<=0){
                while(!st.isEmpty() && st.peek()>0 && st.peek()<ast[i]*-1)
                    st.pop();
                if(!st.isEmpty() && st.peek()==ast[i]*-1)
                    st.pop();
                else if(!st.isEmpty() && st.peek()>=-1*ast[i])
                    continue;
                else
                    st.push(ast[i]);

            }
            else
                st.push(ast[i]);
        }
        int size =st.size();
        int[] arr=new int[size];
        for(int i=size-1;i>=0;i--){
            arr[i]=st.pop();
        }
        return arr;
    }
}


//2nd approach

class Solution {
    public static int[] asteroidCollision(int N, int[] ast) {
        // code here
        int top=-1;
        for(int x:ast){
            boolean blast=true;
            while(blast && x<0 && top>=0 &&ast[top]>0){
                blast=ast[top]+x<0;
                if(ast[top]+x<=0) top--;
            }
            if(blast) ast[++top]=x;
        }
        return Arrays.copyOf(ast,top+1);
    }
}
