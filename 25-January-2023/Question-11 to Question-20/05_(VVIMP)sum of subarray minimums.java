class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long M = (long)1e9 + 7;
        long sum=0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int idx1=0;idx1<n+1;idx1++){
            int currval=(idx1<n)?arr[idx1]:0;

            while(stack.peek()!=-1 && currval<arr[stack.peek()]){
                int index=stack.pop();
                int idx2 = stack.peek();

                int left=index-idx2;
                int right=idx1-index;

                long ans = (long)(left*right*(long)arr[index])%M;
                sum+=ans;
                sum%=M;
            }
            stack.push(idx1);
        }
        return (int)sum;
    }
}
