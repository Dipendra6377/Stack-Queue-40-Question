// GFG

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int arr[], int n)
    {
        // Your code here
        Stack<Integer> st= new Stack<>();
        int[] days=new int[n];
        st.push(0);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                days[i]=i+1;
            }
            else{
                days[i]=i-st.peek();
            }
            st.push(i);
        }
        return days;
    }
    
}
