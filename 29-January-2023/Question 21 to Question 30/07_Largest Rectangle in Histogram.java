// Naive
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            int min =Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                min =Math.min(min,heights[j]);
                maxArea=Math.max(maxArea,min*(j-i+1));
            }
        }
        return maxArea;
    }
}

// better approach
// time complexity O(N) space complexity O(3N)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) left[i]=0;
            else left[i]=st.peek()+1;

            st.push(i);
        }
        while(!st.isEmpty()) st.pop();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) right[i]=n-1;
            else right[i]=st.peek()-1;

            st.push(i);
        }
        int ans=0;

        for(int i=0;i<n;i++){
            ans=Math.max(ans,(right[i]-left[i]+1)*heights[i]);
        }
        return ans;
    }
}

// Optimised approach TC O(N) && SC O(N)

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int max=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int h = heights[st.peek()];
                st.pop();
                int width=0;
                if(st.isEmpty()) width=i;
                else width=i-st.peek()-1;

                max=Math.max(max,width*h);

            }
            st.push(i);
            
        }
        return max;
    }
}
