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


// leetcode using stack

class StockSpanner {
    Stack<int[]> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int day=1;
        while(!st.isEmpty() && price>=st.peek()[0]){
            day+=st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price,day});
        return day;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */



// leetcode using arraylist

class StockSpanner {
    ArrayList<Integer> list;
    int i;
    public StockSpanner() {
        list=new ArrayList<>();
        i=0;
    }
    
    public int next(int price) {
        list.add(i,price);
        int j=i;int day=0;

        while(list.get(j)<=price){
            if(j==0){
                day++;
                break;
            }
            else{
                day++;
                j--;
            }
        }
        i++;
        return day;
    }
}
