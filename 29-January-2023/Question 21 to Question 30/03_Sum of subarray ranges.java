class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st1 =new Stack<>();
        Stack<Integer> st2 =new Stack<>();
        long sum=0;
        int n=nums.length;

        for(int i=0;i<=n;i++){
            while(!st1.isEmpty() && ( i == nums.length || nums[st1.peek()] < nums[i])){
                int currind=st1.pop();
                int left = st1.isEmpty() ? -1 : st1.peek(); 
                int right=i;
                
                sum+=(currind-left)*(right-currind)*(long)nums[currind];
            }
            while(!st2.isEmpty() && (i == nums.length || nums[st2.peek()] > nums[i])){
                int currind=st2.pop();
                int left = st2.isEmpty() ? -1 : st2.peek(); 
                int right=i;
                //System.out.println("hello");
                sum-=(currind-left)*(right-currind)*(long)nums[currind];
            }
            st1.push(i);
            st2.push(i);
        }
        return sum;
    }
}
