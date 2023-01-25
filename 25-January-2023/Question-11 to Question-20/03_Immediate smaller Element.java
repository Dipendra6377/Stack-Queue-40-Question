class Solution {
    void immediateSmaller(int arr[], int n) {
        // code here
        
        Stack<Integer> st =new Stack<>();
        for(int i=n-1;i>=0;i--){
            int temp=arr[i];     // its bcox in next arr[i] value will change
            if(!st.isEmpty() && arr[i]>st.peek()){
                arr[i]=st.peek();
            }
            else arr[i]=-1;
            
            if(!st.isEmpty()){
                st.pop();
            }
            st.push(temp);
        }
        
        
    }
}
