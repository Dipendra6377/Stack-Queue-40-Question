class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        
        int ind=0;
        int n=nums.length;
        int[] res = new int[n-k+1];

        for(int i=0;i<n;i++){
            if(!q.isEmpty() && q.peek()==i-k){
                q.poll();
            }

            while(!q.isEmpty() && nums[i]>=nums[q.peekLast()]){
                q.pollLast();
            }
            q.offer(i);

            if(i>=k-1){
                res[ind++] =nums[q.peek()];
            }
        }
        return res;

    }
}


// Iterative
class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n-k+1;i++){
            int max=0;
            
            for(int j=0;j<k;j++){
                if(arr[j+i]>max){
                    max=arr[j+i];
                }
            }
            list.add(max);
        }
        return list;
    }
}
